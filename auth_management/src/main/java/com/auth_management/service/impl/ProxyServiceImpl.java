package com.auth_management.service.impl;

import com.auth_management.service.ProxyService;
import com.auth_management.util.ForwardBodyHandler;
import com.common.util.Json;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Log4j2
@Service
public class ProxyServiceImpl implements ProxyService {
    private static final Set<String> skippedHeaders = Set.of("host", "connection", "content-length", "upgrade");
    private final HttpClient httpClient;
    private final int ignorePrefixLength;
    private final ApiDistribute apiDistribute;
    private final Logger logger = LogManager.getLogger(getClass());

    public ProxyServiceImpl(HttpClient httpClient, @Value("${server.servlet.context-path}") String contextPath, ApiDistribute apiDistribute) {
        this.httpClient = httpClient;
        ignorePrefixLength = contextPath.length();
        this.apiDistribute = apiDistribute;
    }

    @Override
    public CompletableFuture<Void> forward(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return doForward(request, response, newBodyPublisher(request));
    }

    @Override
    public CompletableFuture<HttpResponse<byte[]>> forwardRequest(HttpServletRequest request) {
        HttpRequest.Builder forwardReq = getBuilder(request, newBodyPublisher(request));
        return httpClient.sendAsync(forwardReq.build(), HttpResponse.BodyHandlers.ofByteArray());
    }

    HttpRequest.BodyPublisher newBodyPublisher(HttpServletRequest request) {
        long contentLength = request.getContentLengthLong();
        if (contentLength == 0) {
            return HttpRequest.BodyPublishers.noBody();
        }
        var bodyPublisher = HttpRequest.BodyPublishers.ofInputStream(() -> {
            try {
                return request.getInputStream();
            } catch (IOException e) {
                log.error("can't get input stream of request to forward", e);
                return null;
            }
        });
        if (contentLength > 0) {
            bodyPublisher = HttpRequest.BodyPublishers.fromPublisher(bodyPublisher, contentLength);
        }
        return bodyPublisher;
    }

    @Override
    public CompletableFuture<Void> forwardWithBody(HttpServletRequest request, HttpServletResponse response, Object body) throws IOException {
        return forwardWithBody(request, response, Json.encode(body));
    }

    @Override
    public CompletableFuture<Void> forwardWithBody(HttpServletRequest request, HttpServletResponse response, byte[] body) throws IOException {
        var bodyPublisher = HttpRequest.BodyPublishers.ofByteArray(body);
        return doForward(request, response, bodyPublisher);
    }

    private CompletableFuture<Void> doForward(HttpServletRequest request, HttpServletResponse response, HttpRequest.BodyPublisher bodyPublisher) throws IOException {
        HttpRequest.Builder forwardReq = getBuilder(request, bodyPublisher);
        return httpClient.sendAsync(forwardReq.build(), new ForwardBodyHandler(response))
                .thenApply(resp -> null);
    }

    private HttpRequest.Builder getBuilder(HttpServletRequest request, HttpRequest.BodyPublisher bodyPublisher) {
        URI uri = resolveTargetUri(request);
        logger.info("Forward to: " + uri);
        var forwardReq = HttpRequest.newBuilder(uri)
                .method(request.getMethod(), bodyPublisher);

        forwardHeaders(forwardReq, request);
        return forwardReq;
    }

    private void forwardHeaders(HttpRequest.Builder builder, HttpServletRequest request) {
        var headers = request.getHeaderNames();
        String header;
        while (headers.hasMoreElements()) {
            header = headers.nextElement();
            if (skippedHeaders.contains(header)) {
                continue;
            }
            var values = request.getHeaders(header);
            while (values.hasMoreElements()) {
                builder.header(header, values.nextElement());
            }
        }
    }

    private URI resolveTargetUri(HttpServletRequest request) {

        // get Base Uri
        String baseUrl = apiDistribute.distribute(request.getRequestURI());

        var requestURI = request.getRequestURI();
        var builder = new StringBuilder()
                .append(baseUrl)
                .append(requestURI, ignorePrefixLength, requestURI.length());
        if (request.getQueryString() != null) {
            builder.append('?').append(request.getQueryString());
        }
        return URI.create(builder.toString());
    }
}
