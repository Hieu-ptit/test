package com.auth_management.model.request;



@javax.annotation.processing.Generated("dsl_json")
public class _CreateFile_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.request.CreateFile.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.request.CreateFile.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.request.CreateFile.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.request.CreateFile>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.request.CreateFile> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<java.util.List<com.auth_management.model.request.FileRequest>> reader_filesRequest;
		private com.dslplatform.json.JsonReader.ReadObject<java.util.List<com.auth_management.model.request.FileRequest>> reader_filesRequest() {
			if (reader_filesRequest == null) {
				java.lang.reflect.Type manifest = com.dslplatform.json.runtime.Generics.makeParameterizedType(java.util.List.class, com.auth_management.model.request.FileRequest.class);
				reader_filesRequest = __dsljson.tryFindReader(manifest);
				if (reader_filesRequest == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_filesRequest;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<java.util.List<com.auth_management.model.request.FileRequest>> writer_filesRequest;
		private com.dslplatform.json.JsonWriter.WriteObject<java.util.List<com.auth_management.model.request.FileRequest>> writer_filesRequest() {
			if (writer_filesRequest == null) {
				java.lang.reflect.Type manifest = com.dslplatform.json.runtime.Generics.makeParameterizedType(java.util.List.class, com.auth_management.model.request.FileRequest.class);
				writer_filesRequest = __dsljson.tryFindWriter(manifest);
				if (writer_filesRequest == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_filesRequest;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.auth_management.model.request.CreateFile read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.request.CreateFile());
		}
		private static final byte[] quoted_filesRequest = "\"files_request\":".getBytes(utf8);
		private static final byte[] name_filesRequest = "files_request".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.CreateFile instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.CreateFile instance) {
			writer.writeAscii(quoted_filesRequest);
			if (instance.getFilesRequest() == null) writer.writeNull();
			else writer_filesRequest().write(writer, instance.getFilesRequest());
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.CreateFile instance) {
			boolean hasWritten = false;
			if (instance.getFilesRequest() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_filesRequest); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_filesRequest().write(writer, instance.getFilesRequest());
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.request.CreateFile bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.CreateFile instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.request.CreateFile readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.request.CreateFile instance = new com.auth_management.model.request.CreateFile();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.CreateFile instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1403 || !reader.wasLastName(name_filesRequest)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setFilesRequest(reader_filesRequest().read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 1);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.CreateFile instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -551692966:
					reader.getNextToken();
					instance.setFilesRequest(reader_filesRequest().read(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case -551692966:
						reader.getNextToken();
						instance.setFilesRequest(reader_filesRequest().read(reader));
						reader.getNextToken();
						break;
					default:
						reader.getNextToken();
						reader.skip();
				}
			}
			if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
		}
	}
}
