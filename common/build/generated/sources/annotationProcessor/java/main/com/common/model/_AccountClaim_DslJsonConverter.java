package com.common.model;



@javax.annotation.processing.Generated("dsl_json")
public class _AccountClaim_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.common.model.AccountClaim.class, objectConverter);
		__dsljson.registerReader(com.common.model.AccountClaim.class, objectConverter);
		__dsljson.registerWriter(com.common.model.AccountClaim.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.common.model.AccountClaim>, com.dslplatform.json.JsonReader.BindObject<com.common.model.AccountClaim> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.common.model.AccountClaim read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.common.model.AccountClaim());
		}
		private static final byte[] quoted_username = "\"username\":".getBytes(utf8);
		private static final byte[] name_username = "username".getBytes(utf8);
		private static final byte[] quoted_bitSet = ",\"bitSet\":".getBytes(utf8);
		private static final byte[] name_bitSet = "bitSet".getBytes(utf8);
		private static final byte[] quoted_role = ",\"role\":".getBytes(utf8);
		private static final byte[] name_role = "role".getBytes(utf8);
		private static final byte[] quoted_accountId = ",\"account_id\":".getBytes(utf8);
		private static final byte[] name_accountId = "account_id".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.common.model.AccountClaim instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.common.model.AccountClaim instance) {
			writer.writeAscii(quoted_username);
			if (instance.getUsername() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getUsername(), writer);
			writer.writeAscii(quoted_bitSet);
			if (instance.getBitSet() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getBitSet(), writer);
			writer.writeAscii(quoted_role);
			if (instance.getRole() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getRole(), writer);
			writer.writeAscii(quoted_accountId);
			if (instance.getAccountId() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.common.model.AccountClaim instance) {
			boolean hasWritten = false;
			if (instance.getUsername() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_username); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getUsername(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getBitSet() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_bitSet); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getBitSet(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getRole() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_role); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getRole(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAccountId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_accountId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.common.model.AccountClaim bind(final com.dslplatform.json.JsonReader reader, final com.common.model.AccountClaim instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.common.model.AccountClaim readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.common.model.AccountClaim instance = new com.common.model.AccountClaim();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.common.model.AccountClaim instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 864 || !reader.wasLastName(name_username)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setUsername(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 619 || !reader.wasLastName(name_bitSet)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setBitSet(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 434 || !reader.wasLastName(name_role)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setRole(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1049 || !reader.wasLastName(name_accountId)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 4);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.common.model.AccountClaim instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 2003883388:
					reader.getNextToken();
					instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 268382745:
					reader.getNextToken();
					instance.setRole(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -731580544:
					reader.getNextToken();
					instance.setBitSet(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 1320097209:
					reader.getNextToken();
					instance.setUsername(com.dslplatform.json.StringConverter.READER.read(reader));
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
					case 268382745:
						reader.getNextToken();
						instance.setRole(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -731580544:
						reader.getNextToken();
						instance.setBitSet(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 1320097209:
						reader.getNextToken();
						instance.setUsername(com.dslplatform.json.StringConverter.READER.read(reader));
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
