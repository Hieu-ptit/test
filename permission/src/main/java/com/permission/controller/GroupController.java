package com.permission.controller;

import com.common.model.response.Response;
import com.permission.model.response.GroupInfo;
import com.permission.model.response.GroupResponse;
import com.permission.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@RestController
@Validated
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public Response<List<GroupResponse>> getAllByModule(@Min(value = 0, message = "4161")
                                                        @RequestParam(value = "module-id") int moduleId) {
        return Response.ofSucceeded(groupService.getAllByModuleId(moduleId));
    }

    @GetMapping("/log")
    public Response<List<GroupInfo>> getAll() {
        return Response.ofSucceeded(groupService.getAll());
    }

    @GetMapping("/validation")
    public Response<Boolean> validateGroups(@Min(value = 0, message = "4159") @RequestParam("module-id") int moduleId,
                                            @RequestBody Set<String> groupIdSet) {

        return Response.ofSucceeded(groupService.validateGroups(moduleId, groupIdSet));
    }

}
