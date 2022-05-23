package com.auth_management.model.request;



@javax.annotation.processing.Generated("dsl_json")
public class _ImageLicensePlatesRequest_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.auth_management.model.request.ImageLicensePlatesRequest.class, objectConverter);
		__dsljson.registerReader(com.auth_management.model.request.ImageLicensePlatesRequest.class, objectConverter);
		__dsljson.registerWriter(com.auth_management.model.request.ImageLicensePlatesRequest.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.auth_management.model.request.ImageLicensePlatesRequest>, com.dslplatform.json.JsonReader.BindObject<com.auth_management.model.request.ImageLicensePlatesRequest> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.auth_management.model.request.ImageLicensePlatesRequest read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.auth_management.model.request.ImageLicensePlatesRequest());
		}
		private static final byte[] quoted_url = "\"url\":".getBytes(utf8);
		private static final byte[] name_url = "url".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		private static final byte[] quoted_orderId = ",\"order_id\":".getBytes(utf8);
		private static final byte[] name_orderId = "order_id".getBytes(utf8);
		private static final byte[] quoted_accountId = ",\"account_id\":".getBytes(utf8);
		private static final byte[] name_accountId = "account_id".getBytes(utf8);
		private static final byte[] quoted_date = ",\"date\":".getBytes(utf8);
		private static final byte[] name_date = "date".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.ImageLicensePlatesRequest instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.ImageLicensePlatesRequest instance) {
			writer.writeAscii(quoted_url);
			if (instance.getUrl() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getUrl(), writer);
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
			writer.writeAscii(quoted_orderId);
			if (instance.getOrderId() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getOrderId(), writer);
			writer.writeAscii(quoted_accountId);
			if (instance.getAccountId() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
			writer.writeAscii(quoted_date);
			if (instance.getDate() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getDate(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.request.ImageLicensePlatesRequest instance) {
			boolean hasWritten = false;
			if (instance.getUrl() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_url); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getUrl(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getName() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_name); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getOrderId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_orderId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getOrderId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAccountId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_accountId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getDate() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_date); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getDate(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.auth_management.model.request.ImageLicensePlatesRequest bind(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.ImageLicensePlatesRequest instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.auth_management.model.request.ImageLicensePlatesRequest readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.auth_management.model.request.ImageLicensePlatesRequest instance = new com.auth_management.model.request.ImageLicensePlatesRequest();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.ImageLicensePlatesRequest instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 339 || !reader.wasLastName(name_url)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setUrl(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 417 || !reader.wasLastName(name_name)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 840 || !reader.wasLastName(name_orderId)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setOrderId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1049 || !reader.wasLastName(name_accountId)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 414 || !reader.wasLastName(name_date)) { bindSlow(reader, instance, 4); return; }
			reader.getNextToken();
			instance.setDate(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 5);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.auth_management.model.request.ImageLicensePlatesRequest instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -730669991:
					reader.getNextToken();
					instance.setDate(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 2003883388:
					reader.getNextToken();
					instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 1794397509:
					reader.getNextToken();
					instance.setOrderId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
					reader.getNextToken();
					break;
				case -1925595674:
					reader.getNextToken();
					instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
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
					case -730669991:
						reader.getNextToken();
						instance.setDate(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 2003883388:
						reader.getNextToken();
						instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 1794397509:
						reader.getNextToken();
						instance.setOrderId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
						reader.getNextToken();
						break;
					case -1925595674:
						reader.getNextToken();
						instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
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
