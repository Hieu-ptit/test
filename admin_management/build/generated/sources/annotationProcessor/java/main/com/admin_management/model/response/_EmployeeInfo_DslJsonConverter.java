package com.admin_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _EmployeeInfo_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.admin_management.model.response.EmployeeInfo.class, objectConverter);
		__dsljson.registerReader(com.admin_management.model.response.EmployeeInfo.class, objectConverter);
		__dsljson.registerWriter(com.admin_management.model.response.EmployeeInfo.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.admin_management.model.response.EmployeeInfo>, com.dslplatform.json.JsonReader.BindObject<com.admin_management.model.response.EmployeeInfo> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.StationResponse> reader_station;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.StationResponse> reader_station() {
			if (reader_station == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.StationResponse.class;
				reader_station = __dsljson.tryFindReader(manifest);
				if (reader_station == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_station;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.StationResponse> writer_station;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.StationResponse> writer_station() {
			if (writer_station == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.StationResponse.class;
				writer_station = __dsljson.tryFindWriter(manifest);
				if (writer_station == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_station;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_positions;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_positions() {
			if (reader_positions == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				reader_positions = __dsljson.tryFindReader(manifest);
				if (reader_positions == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_positions;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_positions;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_positions() {
			if (writer_positions == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				writer_positions = __dsljson.tryFindWriter(manifest);
				if (writer_positions == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_positions;
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
		public com.admin_management.model.response.EmployeeInfo read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.admin_management.model.response.EmployeeInfo());
		}
		private static final byte[] quoted_department = "\"department\":".getBytes(utf8);
		private static final byte[] name_department = "department".getBytes(utf8);
		private static final byte[] quoted_id = ",\"id\":".getBytes(utf8);
		private static final byte[] name_id = "id".getBytes(utf8);
		private static final byte[] quoted_positions = ",\"positions\":".getBytes(utf8);
		private static final byte[] name_positions = "positions".getBytes(utf8);
		private static final byte[] quoted_station = ",\"station\":".getBytes(utf8);
		private static final byte[] name_station = "station".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		private static final byte[] quoted_code = ",\"code\":".getBytes(utf8);
		private static final byte[] name_code = "code".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.EmployeeInfo instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.EmployeeInfo instance) {
			writer.writeAscii(quoted_department);
			if (instance.getDepartment() == null) writer.writeNull();
			else writer_department().write(writer, instance.getDepartment());
			writer.writeAscii(quoted_id);
			if (instance.getId() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
			writer.writeAscii(quoted_positions);
			if (instance.getPositions() == null) writer.writeNull();
			else writer_positions().write(writer, instance.getPositions());
			writer.writeAscii(quoted_station);
			if (instance.getStation() == null) writer.writeNull();
			else writer.serialize(instance.getStation(), writer_station());
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
			writer.writeAscii(quoted_code);
			if (instance.getCode() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.EmployeeInfo instance) {
			boolean hasWritten = false;
			if (instance.getDepartment() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_department); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_department().write(writer, instance.getDepartment());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_id); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getPositions() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_positions); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_positions().write(writer, instance.getPositions());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getStation() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_station); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getStation(), writer_station());
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
			return hasWritten;
		}
		public com.admin_management.model.response.EmployeeInfo bind(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.EmployeeInfo instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.admin_management.model.response.EmployeeInfo readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.admin_management.model.response.EmployeeInfo instance = new com.admin_management.model.response.EmployeeInfo();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.EmployeeInfo instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1076 || !reader.wasLastName(name_department)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setDepartment(reader_department().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 205 || !reader.wasLastName(name_id)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1000 || !reader.wasLastName(name_positions)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setPositions(reader_positions().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 770 || !reader.wasLastName(name_station)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setStation(reader.readCollection(reader_station()));
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
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 6);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.EmployeeInfo instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
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
				case -1361630189:
					reader.getNextToken();
					instance.setStation(reader.readCollection(reader_station()));
					reader.getNextToken();
					break;
				case 1591249019:
					reader.getNextToken();
					instance.setPositions(reader_positions().read(reader));
					reader.getNextToken();
					break;
				case 926444256:
					reader.getNextToken();
					instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
					reader.getNextToken();
					break;
				case -818043577:
					reader.getNextToken();
					instance.setDepartment(reader_department().read(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
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
					case -1361630189:
						reader.getNextToken();
						instance.setStation(reader.readCollection(reader_station()));
						reader.getNextToken();
						break;
					case 1591249019:
						reader.getNextToken();
						instance.setPositions(reader_positions().read(reader));
						reader.getNextToken();
						break;
					case 926444256:
						reader.getNextToken();
						instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
						reader.getNextToken();
						break;
					case -818043577:
						reader.getNextToken();
						instance.setDepartment(reader_department().read(reader));
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
