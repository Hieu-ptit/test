package com.auth_management.model.request;



@javax.annotation.processing.Generated("dsl_json")
public class _AuthorRequest_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.request.AuthorRequest.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.request.AuthorRequest.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.request.AuthorRequest.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.request.AuthorRequest>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.request.AuthorRequest> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<java.util.Map<java.lang.Integer,java.util.Map<java.lang.String,java.lang.Integer>>> reader_bitSetModule;
		private com.dslplatform.json.JsonReader.ReadObject<java.util.Map<java.lang.Integer,java.util.Map<java.lang.String,java.lang.Integer>>> reader_bitSetModule() {
			if (reader_bitSetModule == null) {
				java.lang.reflect.Type manifest = com.dslplatform.json.runtime.Generics.makeParameterizedType(java.util.Map.class, java.lang.Integer.class, com.dslplatform.json.runtime.Generics.makeParameterizedType(java.util.Map.class, java.lang.String.class, java.lang.Integer.class));
				reader_bitSetModule = __dsljson.tryFindReader(manifest);
				if (reader_bitSetModule == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_bitSetModule;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<java.util.Map<java.lang.Integer,java.util.Map<java.lang.String,java.lang.Integer>>> writer_bitSetModule;
		private com.dslplatform.json.JsonWriter.WriteObject<java.util.Map<java.lang.Integer,java.util.Map<java.lang.String,java.lang.Integer>>> writer_bitSetModule() {
			if (writer_bitSetModule == null) {
				java.lang.reflect.Type manifest = com.dslplatform.json.runtime.Generics.makeParameterizedType(java.util.Map.class, java.lang.Integer.class, com.dslplatform.json.runtime.Generics.makeParameterizedType(java.util.Map.class, java.lang.String.class, java.lang.Integer.class));
				writer_bitSetModule = __dsljson.tryFindWriter(manifest);
				if (writer_bitSetModule == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_bitSetModule;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.auth_management.model.request.AuthorRequest read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.request.AuthorRequest());
		}
		private static final byte[] quoted_bitSetModule = "\"bit_set_module\":".getBytes(utf8);
		private static final byte[] name_bitSetModule = "bit_set_module".getBytes(utf8);
		private static final byte[] quoted_method = ",\"method\":".getBytes(utf8);
		private static final byte[] name_method = "method".getBytes(utf8);
		private static final byte[] quoted_path = ",\"path\":".getBytes(utf8);
		private static final byte[] name_path = "path".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.AuthorRequest instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.AuthorRequest instance) {
			writer.writeAscii(quoted_bitSetModule);
			if (instance.getBitSetModule() == null) writer.writeNull();
			else writer_bitSetModule().write(writer, instance.getBitSetModule());
			writer.writeAscii(quoted_method);
			if (instance.getMethod() == null) writer.writeNull();
			else { writer.writeByte((byte)'"'); writer.writeAscii(instance.getMethod().name()); writer.writeByte((byte)'"'); }
			writer.writeAscii(quoted_path);
			if (instance.getPath() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getPath(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.AuthorRequest instance) {
			boolean hasWritten = false;
			if (instance.getBitSetModule() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_bitSetModule); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_bitSetModule().write(writer, instance.getBitSetModule());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getMethod() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_method); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				{ writer.writeByte((byte)'"'); writer.writeAscii(instance.getMethod().name()); writer.writeByte((byte)'"'); }
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getPath() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_path); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getPath(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.request.AuthorRequest bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.AuthorRequest instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.request.AuthorRequest readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.request.AuthorRequest instance = new com.auth_management.model.request.AuthorRequest();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.AuthorRequest instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1487 || !reader.wasLastName(name_bitSetModule)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setBitSetModule(reader_bitSetModule().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 641 || !reader.wasLastName(name_method)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setMethod(reader.wasNull() ? null : com.auth_management.model.bo._Method_DslJsonConverter.EnumConverter.readStatic(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 429 || !reader.wasLastName(name_path)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setPath(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 3);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.AuthorRequest instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -2071507658:
					reader.getNextToken();
					instance.setPath(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -1421478096:
					reader.getNextToken();
					instance.setMethod(reader.wasNull() ? null : com.auth_management.model.bo._Method_DslJsonConverter.EnumConverter.readStatic(reader));
					reader.getNextToken();
					break;
				case -694569964:
					reader.getNextToken();
					instance.setBitSetModule(reader_bitSetModule().read(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case -2071507658:
						reader.getNextToken();
						instance.setPath(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -1421478096:
						reader.getNextToken();
						instance.setMethod(reader.wasNull() ? null : com.auth_management.model.bo._Method_DslJsonConverter.EnumConverter.readStatic(reader));
						reader.getNextToken();
						break;
					case -694569964:
						reader.getNextToken();
						instance.setBitSetModule(reader_bitSetModule().read(reader));
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
