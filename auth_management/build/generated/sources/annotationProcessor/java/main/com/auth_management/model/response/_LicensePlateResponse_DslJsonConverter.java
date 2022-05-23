package com.auth_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _LicensePlateResponse_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.response.LicensePlateResponse.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.response.LicensePlateResponse.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.response.LicensePlateResponse.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.response.LicensePlateResponse>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.response.LicensePlateResponse> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.response.ResultResponse> reader_result;
		private com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.response.ResultResponse> reader_result() {
			if (reader_result == null) {
				java.lang.reflect.Type manifest = com.auth_management.model.response.ResultResponse.class;
				reader_result = __dsljson.tryFindReader(manifest);
				if (reader_result == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_result;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.response.ResultResponse> writer_result;
		private com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.response.ResultResponse> writer_result() {
			if (writer_result == null) {
				java.lang.reflect.Type manifest = com.auth_management.model.response.ResultResponse.class;
				writer_result = __dsljson.tryFindWriter(manifest);
				if (writer_result == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_result;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.auth_management.model.response.LicensePlateResponse read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.response.LicensePlateResponse());
		}
		private static final byte[] quoted_status = "\"status\":".getBytes(utf8);
		private static final byte[] name_status = "status".getBytes(utf8);
		private static final byte[] quoted_message = ",\"message\":".getBytes(utf8);
		private static final byte[] name_message = "message".getBytes(utf8);
		private static final byte[] quoted_result = ",\"result\":".getBytes(utf8);
		private static final byte[] name_result = "result".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.LicensePlateResponse instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.LicensePlateResponse instance) {
			writer.writeAscii(quoted_status);
			if (instance.getStatus() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getStatus(), writer);
			writer.writeAscii(quoted_message);
			if (instance.getMessage() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getMessage(), writer);
			writer.writeAscii(quoted_result);
			if (instance.getResult() == null) writer.writeNull();
			else writer.serialize(instance.getResult(), writer_result());
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.LicensePlateResponse instance) {
			boolean hasWritten = false;
			if (instance.getStatus() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_status); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getStatus(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getMessage() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_message); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getMessage(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getResult() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_result); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getResult(), writer_result());
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.response.LicensePlateResponse bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.LicensePlateResponse instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.response.LicensePlateResponse readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.response.LicensePlateResponse instance = new com.auth_management.model.response.LicensePlateResponse();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.LicensePlateResponse instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 676 || !reader.wasLastName(name_status)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setStatus(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 741 || !reader.wasLastName(name_message)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setMessage(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 671 || !reader.wasLastName(name_result)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setResult(reader.readCollection(reader_result()));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 3);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.LicensePlateResponse instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 171406884:
					reader.getNextToken();
					instance.setResult(reader.readCollection(reader_result()));
					reader.getNextToken();
					break;
				case 619841764:
					reader.getNextToken();
					instance.setMessage(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -1169459217:
					reader.getNextToken();
					instance.setStatus(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 171406884:
						reader.getNextToken();
						instance.setResult(reader.readCollection(reader_result()));
						reader.getNextToken();
						break;
					case 619841764:
						reader.getNextToken();
						instance.setMessage(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -1169459217:
						reader.getNextToken();
						instance.setStatus(com.dslplatform.json.StringConverter.READER.read(reader));
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
