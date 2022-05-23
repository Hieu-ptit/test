package com.auth_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _LoginResponse_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.response.LoginResponse.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.response.LoginResponse.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.response.LoginResponse.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.response.LoginResponse>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.response.LoginResponse> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.response.AccountAuth> reader_accountAuth;
		private com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.response.AccountAuth> reader_accountAuth() {
			if (reader_accountAuth == null) {
				java.lang.reflect.Type manifest = com.auth_management.model.response.AccountAuth.class;
				reader_accountAuth = __dsljson.tryFindReader(manifest);
				if (reader_accountAuth == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_accountAuth;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.response.AccountAuth> writer_accountAuth;
		private com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.response.AccountAuth> writer_accountAuth() {
			if (writer_accountAuth == null) {
				java.lang.reflect.Type manifest = com.auth_management.model.response.AccountAuth.class;
				writer_accountAuth = __dsljson.tryFindWriter(manifest);
				if (writer_accountAuth == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_accountAuth;
		}
		private final com.dslplatform.json.JsonReader.ReadObject<java.lang.String> reader_actions;
		private final com.dslplatform.json.JsonWriter.WriteObject<java.lang.String> writer_actions;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
			this.reader_actions = com.dslplatform.json.StringConverter.READER;
			this.writer_actions = com.dslplatform.json.StringConverter.WRITER;
		}
		public com.auth_management.model.response.LoginResponse read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.response.LoginResponse());
		}
		private static final byte[] quoted_changePassword = "\"changePassword\":".getBytes(utf8);
		private static final byte[] name_changePassword = "changePassword".getBytes(utf8);
		private static final byte[] quoted_token = ",\"token\":".getBytes(utf8);
		private static final byte[] name_token = "token".getBytes(utf8);
		private static final byte[] quoted_actions = ",\"actions\":".getBytes(utf8);
		private static final byte[] name_actions = "actions".getBytes(utf8);
		private static final byte[] quoted_accountAuth = ",\"accountAuth\":".getBytes(utf8);
		private static final byte[] name_accountAuth = "accountAuth".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.LoginResponse instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.LoginResponse instance) {
			writer.writeAscii(quoted_changePassword);
			com.dslplatform.json.BoolConverter.serialize(instance.isChangePassword(), writer);
			writer.writeAscii(quoted_token);
			if (instance.getToken() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getToken(), writer);
			writer.writeAscii(quoted_actions);
			if (instance.getActions() == null) writer.writeNull();
			else writer.serialize(instance.getActions(), writer_actions);
			writer.writeAscii(quoted_accountAuth);
			if (instance.getAccountAuth() == null) writer.writeNull();
			else writer_accountAuth().write(writer, instance.getAccountAuth());
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.LoginResponse instance) {
			boolean hasWritten = false;
			if (instance.isChangePassword() != false) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_changePassword); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.BoolConverter.serialize(instance.isChangePassword(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getToken() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_token); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getToken(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getActions() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_actions); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getActions(), writer_actions);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAccountAuth() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_accountAuth); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_accountAuth().write(writer, instance.getAccountAuth());
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.response.LoginResponse bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.LoginResponse instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.response.LoginResponse readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.response.LoginResponse instance = new com.auth_management.model.response.LoginResponse();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.LoginResponse instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1465 || !reader.wasLastName(name_changePassword)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setChangePassword(com.dslplatform.json.BoolConverter.deserialize(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 545 || !reader.wasLastName(name_token)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setToken(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 753 || !reader.wasLastName(name_actions)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setActions(reader.readSet(reader_actions));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1151 || !reader.wasLastName(name_accountAuth)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setAccountAuth(reader_accountAuth().read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 4);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.LoginResponse instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 1791273706:
					reader.getNextToken();
					instance.setAccountAuth(reader_accountAuth().read(reader));
					reader.getNextToken();
					break;
				case -1246411164:
					reader.getNextToken();
					instance.setActions(reader.readSet(reader_actions));
					reader.getNextToken();
					break;
				case -1803949518:
					reader.getNextToken();
					instance.setToken(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 1367578336:
					reader.getNextToken();
					instance.setChangePassword(com.dslplatform.json.BoolConverter.deserialize(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 1791273706:
						reader.getNextToken();
						instance.setAccountAuth(reader_accountAuth().read(reader));
						reader.getNextToken();
						break;
					case -1246411164:
						reader.getNextToken();
						instance.setActions(reader.readSet(reader_actions));
						reader.getNextToken();
						break;
					case -1803949518:
						reader.getNextToken();
						instance.setToken(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 1367578336:
						reader.getNextToken();
						instance.setChangePassword(com.dslplatform.json.BoolConverter.deserialize(reader));
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
