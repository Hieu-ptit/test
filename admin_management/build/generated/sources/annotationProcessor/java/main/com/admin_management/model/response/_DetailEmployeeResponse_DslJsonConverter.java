package com.admin_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _DetailEmployeeResponse_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.admin_management.model.response.DetailEmployeeResponse.class, objectConverter);
		__dsljson.registerReader(com.admin_management.model.response.DetailEmployeeResponse.class, objectConverter);
		__dsljson.registerWriter(com.admin_management.model.response.DetailEmployeeResponse.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.admin_management.model.response.DetailEmployeeResponse>, com.dslplatform.json.JsonReader.BindObject<com.admin_management.model.response.DetailEmployeeResponse> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_position;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_position() {
			if (reader_position == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				reader_position = __dsljson.tryFindReader(manifest);
				if (reader_position == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_position;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_position;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_position() {
			if (writer_position == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				writer_position = __dsljson.tryFindWriter(manifest);
				if (writer_position == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_position;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_department;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_department() {
			if (reader_department == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				reader_department = __dsljson.tryFindReader(manifest);
				if (reader_department == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_department;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_department;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_department() {
			if (writer_department == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				writer_department = __dsljson.tryFindWriter(manifest);
				if (writer_department == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_department;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.admin_management.model.response.DetailEmployeeResponse read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.admin_management.model.response.DetailEmployeeResponse());
		}
		private static final byte[] quoted_stationId = "\"station_id\":".getBytes(utf8);
		private static final byte[] name_stationId = "station_id".getBytes(utf8);
		private static final byte[] quoted_department = ",\"department\":".getBytes(utf8);
		private static final byte[] name_department = "department".getBytes(utf8);
		private static final byte[] quoted_position = ",\"position\":".getBytes(utf8);
		private static final byte[] name_position = "position".getBytes(utf8);
		private static final byte[] quoted_employeeId = ",\"employee_id\":".getBytes(utf8);
		private static final byte[] name_employeeId = "employee_id".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		private static final byte[] quoted_code = ",\"code\":".getBytes(utf8);
		private static final byte[] name_code = "code".getBytes(utf8);
		private static final byte[] quoted_accountId = ",\"account_id\":".getBytes(utf8);
		private static final byte[] name_accountId = "account_id".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.DetailEmployeeResponse instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.DetailEmployeeResponse instance) {
			writer.writeAscii(quoted_stationId);
			if (instance.getStationId() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getStationId(), writer);
			writer.writeAscii(quoted_department);
			if (instance.getDepartment() == null) writer.writeNull();
			else writer_department().write(writer, instance.getDepartment());
			writer.writeAscii(quoted_position);
			if (instance.getPosition() == null) writer.writeNull();
			else writer_position().write(writer, instance.getPosition());
			writer.writeAscii(quoted_employeeId);
			if (instance.getEmployeeId() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getEmployeeId(), writer);
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
			writer.writeAscii(quoted_code);
			if (instance.getCode() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
			writer.writeAscii(quoted_accountId);
			if (instance.getAccountId() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.DetailEmployeeResponse instance) {
			boolean hasWritten = false;
			if (instance.getStationId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_stationId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getStationId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getDepartment() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_department); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_department().write(writer, instance.getDepartment());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getPosition() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_position); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_position().write(writer, instance.getPosition());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getEmployeeId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_employeeId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getEmployeeId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getName() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_name); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getCode() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_code); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAccountId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_accountId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.admin_management.model.response.DetailEmployeeResponse bind(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.DetailEmployeeResponse instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.admin_management.model.response.DetailEmployeeResponse readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.admin_management.model.response.DetailEmployeeResponse instance = new com.admin_management.model.response.DetailEmployeeResponse();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.DetailEmployeeResponse instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1070 || !reader.wasLastName(name_stationId)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setStationId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1076 || !reader.wasLastName(name_department)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setDepartment(reader_department().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 885 || !reader.wasLastName(name_position)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setPosition(reader_position().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1164 || !reader.wasLastName(name_employeeId)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setEmployeeId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 417 || !reader.wasLastName(name_name)) { bindSlow(reader, instance, 4); return; }
			reader.getNextToken();
			instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 411 || !reader.wasLastName(name_code)) { bindSlow(reader, instance, 5); return; }
			reader.getNextToken();
			instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1049 || !reader.wasLastName(name_accountId)) { bindSlow(reader, instance, 6); return; }
			reader.getNextToken();
			instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 7);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.DetailEmployeeResponse instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 2003883388:
					reader.getNextToken();
					instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -114201356:
					reader.getNextToken();
					instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -1925595674:
					reader.getNextToken();
					instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -792049449:
					reader.getNextToken();
					instance.setEmployeeId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
					reader.getNextToken();
					break;
				case -1823519222:
					reader.getNextToken();
					instance.setPosition(reader_position().read(reader));
					reader.getNextToken();
					break;
				case -818043577:
					reader.getNextToken();
					instance.setDepartment(reader_department().read(reader));
					reader.getNextToken();
					break;
				case 330360105:
					reader.getNextToken();
					instance.setStationId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
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
					case -114201356:
						reader.getNextToken();
						instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -1925595674:
						reader.getNextToken();
						instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -792049449:
						reader.getNextToken();
						instance.setEmployeeId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
						reader.getNextToken();
						break;
					case -1823519222:
						reader.getNextToken();
						instance.setPosition(reader_position().read(reader));
						reader.getNextToken();
						break;
					case -818043577:
						reader.getNextToken();
						instance.setDepartment(reader_department().read(reader));
						reader.getNextToken();
						break;
					case 330360105:
						reader.getNextToken();
						instance.setStationId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
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
