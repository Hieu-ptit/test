package com.permission.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _RoleResponseDetail_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.permission.model.response.RoleResponseDetail.class, objectConverter);
		__dsljson.registerReader(com.permission.model.response.RoleResponseDetail.class, objectConverter);
		__dsljson.registerWriter(com.permission.model.response.RoleResponseDetail.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.permission.model.response.RoleResponseDetail>, com.dslplatform.json.JsonReader.BindObject<com.permission.model.response.RoleResponseDetail> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.permission.model.response.RoleResponse> reader_roleResponses;
		private com.dslplatform.json.JsonReader.ReadObject<com.permission.model.response.RoleResponse> reader_roleResponses() {
			if (reader_roleResponses == null) {
				java.lang.reflect.Type manifest = com.permission.model.response.RoleResponse.class;
				reader_roleResponses = __dsljson.tryFindReader(manifest);
				if (reader_roleResponses == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_roleResponses;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.permission.model.response.RoleResponse> writer_roleResponses;
		private com.dslplatform.json.JsonWriter.WriteObject<com.permission.model.response.RoleResponse> writer_roleResponses() {
			if (writer_roleResponses == null) {
				java.lang.reflect.Type manifest = com.permission.model.response.RoleResponse.class;
				writer_roleResponses = __dsljson.tryFindWriter(manifest);
				if (writer_roleResponses == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_roleResponses;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.permission.model.response.RoleResponseDetail read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.permission.model.response.RoleResponseDetail());
		}
		private static final byte[] quoted_roleResponses = "\"role_responses\":".getBytes(utf8);
		private static final byte[] name_roleResponses = "role_responses".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.permission.model.response.RoleResponseDetail instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.permission.model.response.RoleResponseDetail instance) {
			writer.writeAscii(quoted_roleResponses);
			if (instance.getRoleResponses() == null) writer.writeNull();
			else writer.serialize(instance.getRoleResponses(), writer_roleResponses());
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.permission.model.response.RoleResponseDetail instance) {
			boolean hasWritten = false;
			if (instance.getRoleResponses() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_roleResponses); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getRoleResponses(), writer_roleResponses());
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.permission.model.response.RoleResponseDetail bind(final com.dslplatform.json.JsonReader reader, final com.permission.model.response.RoleResponseDetail instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.permission.model.response.RoleResponseDetail readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.permission.model.response.RoleResponseDetail instance = new com.permission.model.response.RoleResponseDetail();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.permission.model.response.RoleResponseDetail instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1523 || !reader.wasLastName(name_roleResponses)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setRoleResponses(reader.readCollection(reader_roleResponses()));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 1);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.permission.model.response.RoleResponseDetail instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -1180531358:
					reader.getNextToken();
					instance.setRoleResponses(reader.readCollection(reader_roleResponses()));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case -1180531358:
						reader.getNextToken();
						instance.setRoleResponses(reader.readCollection(reader_roleResponses()));
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
