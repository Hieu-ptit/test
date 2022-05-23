package com.auth_management.model.request;



@javax.annotation.processing.Generated("dsl_json")
public class _FileRequest_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.request.FileRequest.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.request.FileRequest.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.request.FileRequest.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.request.FileRequest>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.request.FileRequest> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.auth_management.model.request.FileRequest read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.request.FileRequest());
		}
		private static final byte[] quoted_url = "\"url\":".getBytes(utf8);
		private static final byte[] name_url = "url".getBytes(utf8);
		private static final byte[] quoted_typeMedia = ",\"type_media\":".getBytes(utf8);
		private static final byte[] name_typeMedia = "type_media".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		private static final byte[] quoted_owner = ",\"owner\":".getBytes(utf8);
		private static final byte[] name_owner = "owner".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.FileRequest instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.FileRequest instance) {
			writer.writeAscii(quoted_url);
			if (instance.getUrl() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getUrl(), writer);
			writer.writeAscii(quoted_typeMedia);
			if (instance.getTypeMedia() == null) writer.writeNull();
			else { writer.writeByte((byte)'"'); writer.writeAscii(instance.getTypeMedia().name()); writer.writeByte((byte)'"'); }
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
			writer.writeAscii(quoted_owner);
			if (instance.getOwner() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getOwner(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.FileRequest instance) {
			boolean hasWritten = false;
			if (instance.getUrl() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_url); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getUrl(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getTypeMedia() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_typeMedia); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				{ writer.writeByte((byte)'"'); writer.writeAscii(instance.getTypeMedia().name()); writer.writeByte((byte)'"'); }
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getName() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_name); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getOwner() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_owner); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getOwner(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.request.FileRequest bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.FileRequest instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.request.FileRequest readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.request.FileRequest instance = new com.auth_management.model.request.FileRequest();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.FileRequest instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 339 || !reader.wasLastName(name_url)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setUrl(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1057 || !reader.wasLastName(name_typeMedia)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setTypeMedia(reader.wasNull() ? null : com.auth_management.model.bo._TypeMedia_DslJsonConverter.EnumConverter.readStatic(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 417 || !reader.wasLastName(name_name)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 555 || !reader.wasLastName(name_owner)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setOwner(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 4);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.FileRequest instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -177779500:
					reader.getNextToken();
					instance.setOwner(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -1925595674:
					reader.getNextToken();
					instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 1682158342:
					reader.getNextToken();
					instance.setTypeMedia(reader.wasNull() ? null : com.auth_management.model.bo._TypeMedia_DslJsonConverter.EnumConverter.readStatic(reader));
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
					case -177779500:
						reader.getNextToken();
						instance.setOwner(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -1925595674:
						reader.getNextToken();
						instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 1682158342:
						reader.getNextToken();
						instance.setTypeMedia(reader.wasNull() ? null : com.auth_management.model.bo._TypeMedia_DslJsonConverter.EnumConverter.readStatic(reader));
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
