package com.permission.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _RoleResponse_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.permission.model.response.RoleResponse.class, objectConverter);
		__dsljson.registerReader(com.permission.model.response.RoleResponse.class, objectConverter);
		__dsljson.registerWriter(com.permission.model.response.RoleResponse.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.permission.model.response.RoleResponse>, com.dslplatform.json.JsonReader.BindObject<com.permission.model.response.RoleResponse> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private final com.dslplatform.json.JsonReader.ReadObject<java.lang.String> key_reader_bitSetModule;
		private final com.dslplatform.json.JsonWriter.WriteObject<java.lang.String> key_writer_bitSetModule;
		private final com.dslplatform.json.JsonReader.ReadObject<java.lang.Integer> value_reader_bitSetModule;
		private final com.dslplatform.json.JsonWriter.WriteObject<java.lang.Integer> value_writer_bitSetModule;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
			this.key_reader_bitSetModule = com.dslplatform.json.StringConverter.READER;
			this.key_writer_bitSetModule = com.dslplatform.json.StringConverter.WRITER;
			this.value_reader_bitSetModule = com.dslplatform.json.NumberConverter.NULLABLE_INT_READER;
			this.value_writer_bitSetModule = com.dslplatform.json.NumberConverter.INT_WRITER;
		}
		public com.permission.model.response.RoleResponse read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.permission.model.response.RoleResponse());
		}
		private static final byte[] quoted_bitSetModule = "\"bitSetModule\":".getBytes(utf8);
		private static final byte[] name_bitSetModule = "bitSetModule".getBytes(utf8);
		private static final byte[] quoted_id = ",\"id\":".getBytes(utf8);
		private static final byte[] name_id = "id".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.permission.model.response.RoleResponse instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.permission.model.response.RoleResponse instance) {
			writer.writeAscii(quoted_bitSetModule);
			if (instance.getBitSetModule() == null) writer.writeNull();
			else writer.serialize(instance.getBitSetModule(), key_writer_bitSetModule, value_writer_bitSetModule);
			writer.writeAscii(quoted_id);
			com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.permission.model.response.RoleResponse instance) {
			boolean hasWritten = false;
			if (instance.getBitSetModule() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_bitSetModule); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getBitSetModule(), key_writer_bitSetModule, value_writer_bitSetModule);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getId() != 0) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_id); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getName() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_name); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.permission.model.response.RoleResponse bind(final com.dslplatform.json.JsonReader reader, final com.permission.model.response.RoleResponse instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.permission.model.response.RoleResponse readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.permission.model.response.RoleResponse instance = new com.permission.model.response.RoleResponse();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.permission.model.response.RoleResponse instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1233 || !reader.wasLastName(name_bitSetModule)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setBitSetModule(reader.readMap(key_reader_bitSetModule, value_reader_bitSetModule));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 205 || !reader.wasLastName(name_id)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setId(com.dslplatform.json.NumberConverter.deserializeInt(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 417 || !reader.wasLastName(name_name)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 3);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.permission.model.response.RoleResponse instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -1925595674:
					reader.getNextToken();
					instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 926444256:
					reader.getNextToken();
					instance.setId(com.dslplatform.json.NumberConverter.deserializeInt(reader));
					reader.getNextToken();
					break;
				case 731934696:
					reader.getNextToken();
					instance.setBitSetModule(reader.readMap(key_reader_bitSetModule, value_reader_bitSetModule));
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
					case 926444256:
						reader.getNextToken();
						instance.setId(com.dslplatform.json.NumberConverter.deserializeInt(reader));
						reader.getNextToken();
						break;
					case 731934696:
						reader.getNextToken();
						instance.setBitSetModule(reader.readMap(key_reader_bitSetModule, value_reader_bitSetModule));
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
