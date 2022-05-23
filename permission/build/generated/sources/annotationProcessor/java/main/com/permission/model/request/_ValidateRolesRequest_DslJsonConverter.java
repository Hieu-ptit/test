package com.permission.model.request;



@javax.annotation.processing.Generated("dsl_json")
public class _ValidateRolesRequest_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.permission.model.request.ValidateRolesRequest.class, objectConverter);
		__dsljson.registerReader(com.permission.model.request.ValidateRolesRequest.class, objectConverter);
		__dsljson.registerWriter(com.permission.model.request.ValidateRolesRequest.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.permission.model.request.ValidateRolesRequest>, com.dslplatform.json.JsonReader.BindObject<com.permission.model.request.ValidateRolesRequest> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private final com.dslplatform.json.JsonReader.ReadObject<java.lang.Integer> reader_roleIds;
		private final com.dslplatform.json.JsonWriter.WriteObject<java.lang.Integer> writer_roleIds;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
			this.reader_roleIds = com.dslplatform.json.NumberConverter.NULLABLE_INT_READER;
			this.writer_roleIds = com.dslplatform.json.NumberConverter.INT_WRITER;
		}
		public com.permission.model.request.ValidateRolesRequest read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.permission.model.request.ValidateRolesRequest());
		}
		private static final byte[] quoted_roleIds = "\"role_ids\":".getBytes(utf8);
		private static final byte[] name_roleIds = "role_ids".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.permission.model.request.ValidateRolesRequest instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.permission.model.request.ValidateRolesRequest instance) {
			writer.writeAscii(quoted_roleIds);
			if (instance.getRoleIds() == null) writer.writeNull();
			else writer.serializeRaw(instance.getRoleIds(), writer_roleIds);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.permission.model.request.ValidateRolesRequest instance) {
			boolean hasWritten = false;
			if (instance.getRoleIds() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_roleIds); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serializeRaw(instance.getRoleIds(), writer_roleIds);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.permission.model.request.ValidateRolesRequest bind(final com.dslplatform.json.JsonReader reader, final com.permission.model.request.ValidateRolesRequest instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.permission.model.request.ValidateRolesRequest readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.permission.model.request.ValidateRolesRequest instance = new com.permission.model.request.ValidateRolesRequest();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.permission.model.request.ValidateRolesRequest instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 849 || !reader.wasLastName(name_roleIds)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setRoleIds(reader.readSet(reader_roleIds));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 1);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.permission.model.request.ValidateRolesRequest instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 1493629092:
					reader.getNextToken();
					instance.setRoleIds(reader.readSet(reader_roleIds));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 1493629092:
						reader.getNextToken();
						instance.setRoleIds(reader.readSet(reader_roleIds));
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
