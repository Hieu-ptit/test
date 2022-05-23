package com.admin_management.model.bo;



@javax.annotation.processing.Generated("dsl_json")
public class _CredentialImages_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.admin_management.model.bo.CredentialImages.class, objectConverter);
		__dsljson.registerReader(com.admin_management.model.bo.CredentialImages.class, objectConverter);
		__dsljson.registerWriter(com.admin_management.model.bo.CredentialImages.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.admin_management.model.bo.CredentialImages>, com.dslplatform.json.JsonReader.BindObject<com.admin_management.model.bo.CredentialImages> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.admin_management.model.bo.CredentialImages read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.admin_management.model.bo.CredentialImages());
		}
		private static final byte[] quoted_url = "\"url\":".getBytes(utf8);
		private static final byte[] name_url = "url".getBytes(utf8);
		private static final byte[] quoted_type = ",\"type\":".getBytes(utf8);
		private static final byte[] name_type = "type".getBytes(utf8);
		private static final byte[] quoted_id = ",\"id\":".getBytes(utf8);
		private static final byte[] name_id = "id".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		private static final byte[] quoted_face = ",\"face\":".getBytes(utf8);
		private static final byte[] name_face = "face".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.bo.CredentialImages instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.bo.CredentialImages instance) {
			writer.writeAscii(quoted_url);
			if (instance.getUrl() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getUrl(), writer);
			writer.writeAscii(quoted_type);
			if (instance.getType() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getType(), writer);
			writer.writeAscii(quoted_id);
			com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
			writer.writeAscii(quoted_face);
			if (instance.getFace() == null) writer.writeNull();
			else { writer.writeByte((byte)'"'); writer.writeAscii(instance.getFace().name()); writer.writeByte((byte)'"'); }
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.bo.CredentialImages instance) {
			boolean hasWritten = false;
			if (instance.getUrl() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_url); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getUrl(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getType() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_type); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getType(), writer);
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
			if (instance.getFace() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_face); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				{ writer.writeByte((byte)'"'); writer.writeAscii(instance.getFace().name()); writer.writeByte((byte)'"'); }
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.admin_management.model.bo.CredentialImages bind(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.bo.CredentialImages instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.admin_management.model.bo.CredentialImages readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.admin_management.model.bo.CredentialImages instance = new com.admin_management.model.bo.CredentialImages();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.bo.CredentialImages instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 339 || !reader.wasLastName(name_url)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setUrl(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 450 || !reader.wasLastName(name_type)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setType(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 205 || !reader.wasLastName(name_id)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setId(com.dslplatform.json.NumberConverter.deserializeInt(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 417 || !reader.wasLastName(name_name)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 399 || !reader.wasLastName(name_face)) { bindSlow(reader, instance, 4); return; }
			reader.getNextToken();
			instance.setFace(reader.wasNull() ? null : com.admin_management.model.bo._FaceImg_DslJsonConverter.EnumConverter.readStatic(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 5);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.bo.CredentialImages instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 292255708:
					reader.getNextToken();
					instance.setFace(reader.wasNull() ? null : com.admin_management.model.bo._FaceImg_DslJsonConverter.EnumConverter.readStatic(reader));
					reader.getNextToken();
					break;
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
				case 1361572173:
					reader.getNextToken();
					instance.setType(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 848251934:
					reader.getNextToken();
					instance.setUrl(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 292255708:
						reader.getNextToken();
						instance.setFace(reader.wasNull() ? null : com.admin_management.model.bo._FaceImg_DslJsonConverter.EnumConverter.readStatic(reader));
						reader.getNextToken();
						break;
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
					case 1361572173:
						reader.getNextToken();
						instance.setType(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 848251934:
						reader.getNextToken();
						instance.setUrl(com.dslplatform.json.StringConverter.READER.read(reader));
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
