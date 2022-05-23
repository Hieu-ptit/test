package com.auth_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _ResultResponse_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.response.ResultResponse.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.response.ResultResponse.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.response.ResultResponse.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.response.ResultResponse>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.response.ResultResponse> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.auth_management.model.response.ResultResponse read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.response.ResultResponse());
		}
		private static final byte[] quoted_label = "\"label\":".getBytes(utf8);
		private static final byte[] name_label = "label".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.ResultResponse instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.ResultResponse instance) {
			writer.writeAscii(quoted_label);
			if (instance.getLabel() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getLabel(), writer);
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.ResultResponse instance) {
			boolean hasWritten = false;
			if (instance.getLabel() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_label); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getLabel(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getName() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_name); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.response.ResultResponse bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.ResultResponse instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.response.ResultResponse readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.response.ResultResponse instance = new com.auth_management.model.response.ResultResponse();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.ResultResponse instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 512 || !reader.wasLastName(name_label)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setLabel(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 417 || !reader.wasLastName(name_name)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 2);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.ResultResponse instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -1925595674:
					reader.getNextToken();
					instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -157870083:
					reader.getNextToken();
					instance.setLabel(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case -1925595674:
						reader.getNextToken();
						instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -157870083:
						reader.getNextToken();
						instance.setLabel(com.dslplatform.json.StringConverter.READER.read(reader));
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
