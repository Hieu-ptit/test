package com.auth_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _AccountAuth_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.response.AccountAuth.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.response.AccountAuth.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.response.AccountAuth.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.response.AccountAuth>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.response.AccountAuth> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<java.time.ZonedDateTime> reader_createdAt;
		private com.dslplatform.json.JsonReader.ReadObject<java.time.ZonedDateTime> reader_createdAt() {
			if (reader_createdAt == null) {
				java.lang.reflect.Type manifest = java.time.ZonedDateTime.class;
				reader_createdAt = __dsljson.tryFindReader(manifest);
				if (reader_createdAt == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_createdAt;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<java.time.ZonedDateTime> writer_createdAt;
		private com.dslplatform.json.JsonWriter.WriteObject<java.time.ZonedDateTime> writer_createdAt() {
			if (writer_createdAt == null) {
				java.lang.reflect.Type manifest = java.time.ZonedDateTime.class;
				writer_createdAt = __dsljson.tryFindWriter(manifest);
				if (writer_createdAt == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_createdAt;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.response.CredentialImages> reader_avatar;
		private com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.response.CredentialImages> reader_avatar() {
			if (reader_avatar == null) {
				java.lang.reflect.Type manifest = com.auth_management.model.response.CredentialImages.class;
				reader_avatar = __dsljson.tryFindReader(manifest);
				if (reader_avatar == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_avatar;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.response.CredentialImages> writer_avatar;
		private com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.response.CredentialImages> writer_avatar() {
			if (writer_avatar == null) {
				java.lang.reflect.Type manifest = com.auth_management.model.response.CredentialImages.class;
				writer_avatar = __dsljson.tryFindWriter(manifest);
				if (writer_avatar == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_avatar;
		}
		private com.dslplatform.json.JsonReader.ReadObject<java.time.ZonedDateTime> reader_updatedAt;
		private com.dslplatform.json.JsonReader.ReadObject<java.time.ZonedDateTime> reader_updatedAt() {
			if (reader_updatedAt == null) {
				java.lang.reflect.Type manifest = java.time.ZonedDateTime.class;
				reader_updatedAt = __dsljson.tryFindReader(manifest);
				if (reader_updatedAt == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_updatedAt;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<java.time.ZonedDateTime> writer_updatedAt;
		private com.dslplatform.json.JsonWriter.WriteObject<java.time.ZonedDateTime> writer_updatedAt() {
			if (writer_updatedAt == null) {
				java.lang.reflect.Type manifest = java.time.ZonedDateTime.class;
				writer_updatedAt = __dsljson.tryFindWriter(manifest);
				if (writer_updatedAt == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_updatedAt;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.auth_management.model.response.AccountAuth read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.response.AccountAuth());
		}
		private static final byte[] quoted_updatedAt = "\"updatedAt\":".getBytes(utf8);
		private static final byte[] name_updatedAt = "updatedAt".getBytes(utf8);
		private static final byte[] quoted_status = ",\"status\":".getBytes(utf8);
		private static final byte[] name_status = "status".getBytes(utf8);
		private static final byte[] quoted_username = ",\"username\":".getBytes(utf8);
		private static final byte[] name_username = "username".getBytes(utf8);
		private static final byte[] quoted_avatar = ",\"avatar\":".getBytes(utf8);
		private static final byte[] name_avatar = "avatar".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		private static final byte[] quoted_phone = ",\"phone\":".getBytes(utf8);
		private static final byte[] name_phone = "phone".getBytes(utf8);
		private static final byte[] quoted_code = ",\"code\":".getBytes(utf8);
		private static final byte[] name_code = "code".getBytes(utf8);
		private static final byte[] quoted_createdAt = ",\"createdAt\":".getBytes(utf8);
		private static final byte[] name_createdAt = "createdAt".getBytes(utf8);
		private static final byte[] quoted_accountId = ",\"account_id\":".getBytes(utf8);
		private static final byte[] name_accountId = "account_id".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.AccountAuth instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.AccountAuth instance) {
			writer.writeAscii(quoted_updatedAt);
			if (instance.getUpdatedAt() == null) writer.writeNull();
			else writer_updatedAt().write(writer, instance.getUpdatedAt());
			writer.writeAscii(quoted_status);
			if (instance.getStatus() == null) writer.writeNull();
			else { writer.writeByte((byte)'"'); writer.writeAscii(instance.getStatus().name()); writer.writeByte((byte)'"'); }
			writer.writeAscii(quoted_username);
			if (instance.getUsername() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getUsername(), writer);
			writer.writeAscii(quoted_avatar);
			if (instance.getAvatar() == null) writer.writeNull();
			else writer_avatar().write(writer, instance.getAvatar());
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
			writer.writeAscii(quoted_phone);
			if (instance.getPhone() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getPhone(), writer);
			writer.writeAscii(quoted_code);
			if (instance.getCode() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
			writer.writeAscii(quoted_createdAt);
			if (instance.getCreatedAt() == null) writer.writeNull();
			else writer_createdAt().write(writer, instance.getCreatedAt());
			writer.writeAscii(quoted_accountId);
			if (instance.getAccountId() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.response.AccountAuth instance) {
			boolean hasWritten = false;
			if (instance.getUpdatedAt() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_updatedAt); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_updatedAt().write(writer, instance.getUpdatedAt());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getStatus() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_status); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				{ writer.writeByte((byte)'"'); writer.writeAscii(instance.getStatus().name()); writer.writeByte((byte)'"'); }
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getUsername() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_username); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getUsername(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAvatar() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_avatar); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_avatar().write(writer, instance.getAvatar());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getName() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_name); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getPhone() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_phone); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getPhone(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getCode() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_code); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getCreatedAt() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_createdAt); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_createdAt().write(writer, instance.getCreatedAt());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAccountId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_accountId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.response.AccountAuth bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.AccountAuth instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.response.AccountAuth readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.response.AccountAuth instance = new com.auth_management.model.response.AccountAuth();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.AccountAuth instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 924 || !reader.wasLastName(name_updatedAt)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setUpdatedAt(reader_updatedAt().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 676 || !reader.wasLastName(name_status)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setStatus(reader.wasNull() ? null : com.common.model.bo._AccountStatus_DslJsonConverter.EnumConverter.readStatic(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 864 || !reader.wasLastName(name_username)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setUsername(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 639 || !reader.wasLastName(name_avatar)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setAvatar(reader_avatar().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 417 || !reader.wasLastName(name_name)) { bindSlow(reader, instance, 4); return; }
			reader.getNextToken();
			instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 538 || !reader.wasLastName(name_phone)) { bindSlow(reader, instance, 5); return; }
			reader.getNextToken();
			instance.setPhone(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 411 || !reader.wasLastName(name_code)) { bindSlow(reader, instance, 6); return; }
			reader.getNextToken();
			instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 909 || !reader.wasLastName(name_createdAt)) { bindSlow(reader, instance, 7); return; }
			reader.getNextToken();
			instance.setCreatedAt(reader_createdAt().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1049 || !reader.wasLastName(name_accountId)) { bindSlow(reader, instance, 8); return; }
			reader.getNextToken();
			instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 9);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.response.AccountAuth instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 2003883388:
					reader.getNextToken();
					instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 370722958:
					reader.getNextToken();
					instance.setCreatedAt(reader_createdAt().read(reader));
					reader.getNextToken();
					break;
				case -114201356:
					reader.getNextToken();
					instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 2000032175:
					reader.getNextToken();
					instance.setPhone(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -1925595674:
					reader.getNextToken();
					instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 573852100:
					reader.getNextToken();
					instance.setAvatar(reader_avatar().read(reader));
					reader.getNextToken();
					break;
				case 1320097209:
					reader.getNextToken();
					instance.setUsername(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -1169459217:
					reader.getNextToken();
					instance.setStatus(reader.wasNull() ? null : com.common.model.bo._AccountStatus_DslJsonConverter.EnumConverter.readStatic(reader));
					reader.getNextToken();
					break;
				case -501731915:
					reader.getNextToken();
					instance.setUpdatedAt(reader_updatedAt().read(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 2003883388:
						reader.getNextToken();
						instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 370722958:
						reader.getNextToken();
						instance.setCreatedAt(reader_createdAt().read(reader));
						reader.getNextToken();
						break;
					case -114201356:
						reader.getNextToken();
						instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 2000032175:
						reader.getNextToken();
						instance.setPhone(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -1925595674:
						reader.getNextToken();
						instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 573852100:
						reader.getNextToken();
						instance.setAvatar(reader_avatar().read(reader));
						reader.getNextToken();
						break;
					case 1320097209:
						reader.getNextToken();
						instance.setUsername(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -1169459217:
						reader.getNextToken();
						instance.setStatus(reader.wasNull() ? null : com.common.model.bo._AccountStatus_DslJsonConverter.EnumConverter.readStatic(reader));
						reader.getNextToken();
						break;
					case -501731915:
						reader.getNextToken();
						instance.setUpdatedAt(reader_updatedAt().read(reader));
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
