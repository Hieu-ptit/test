package com.auth_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _MediaResponse_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.response.MediaResponse.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.response.MediaResponse.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.response.MediaResponse.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.response.MediaResponse>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.response.MediaResponse> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.response.FileResponse> reader_fileResponses;
		private com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.response.FileResponse> reader_fileResponses() {
			if (reader_fileResponses == null) {
				java.lang.reflect.Type manifest = com.auth_management.model.response.FileResponse.class;
				reader_fileResponses = __dsljson.tryFindReader(manifest);
				if (reader_fileResponses == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_fileResponses;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.response.FileResponse> writer_fileResponses;
		private com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.response.FileResponse> writer_fileResponses() {
			if (writer_fileResponses == null) {
				java.lang.reflect.Type manifest = com.auth_management.model.response.FileResponse.class;
				writer_fileResponses = __dsljson.tryFindWriter(manifest);
				if (writer_fileResponses == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_fileResponses;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.auth_management.model.response.MediaResponse read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.response.MediaResponse());
		}
		private static final byte[] quoted_fileResponses = "\"file_responses\":".getBytes(utf8);
		private static final byte[] name_fileResponses = "file_responses".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.MediaResponse instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.MediaResponse instance) {
			writer.writeAscii(quoted_fileResponses);
			if (instance.getFileResponses() == null) writer.writeNull();
			else writer.serialize(instance.getFileResponses(), writer_fileResponses());
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.MediaResponse instance) {
			boolean hasWritten = false;
			if (instance.getFileResponses() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_fileResponses); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getFileResponses(), writer_fileResponses());
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.response.MediaResponse bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.MediaResponse instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.response.MediaResponse readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.response.MediaResponse instance = new com.auth_management.model.response.MediaResponse();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.MediaResponse instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1505 || !reader.wasLastName(name_fileResponses)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setFileResponses(reader.readCollection(reader_fileResponses()));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 1);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.MediaResponse instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 1105147744:
					reader.getNextToken();
					instance.setFileResponses(reader.readCollection(reader_fileResponses()));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 1105147744:
						reader.getNextToken();
						instance.setFileResponses(reader.readCollection(reader_fileResponses()));
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
