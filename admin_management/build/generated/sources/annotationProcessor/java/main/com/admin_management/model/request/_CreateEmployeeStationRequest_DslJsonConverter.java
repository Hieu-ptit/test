package com.admin_management.model.request;



@javax.annotation.processing.Generated("dsl_json")
public class _CreateEmployeeStationRequest_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.admin_management.model.request.CreateEmployeeStationRequest.class, objectConverter);
		__dsljson.registerReader(com.admin_management.model.request.CreateEmployeeStationRequest.class, objectConverter);
		__dsljson.registerWriter(com.admin_management.model.request.CreateEmployeeStationRequest.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.admin_management.model.request.CreateEmployeeStationRequest>, com.dslplatform.json.JsonReader.BindObject<com.admin_management.model.request.CreateEmployeeStationRequest> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.admin_management.model.request.CreateEmployeeStationRequest read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.admin_management.model.request.CreateEmployeeStationRequest());
		}
		private static final byte[] quoted_stationId = "\"station_id\":".getBytes(utf8);
		private static final byte[] name_stationId = "station_id".getBytes(utf8);
		private static final byte[] quoted_employeeId = ",\"employee_id\":".getBytes(utf8);
		private static final byte[] name_employeeId = "employee_id".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.CreateEmployeeStationRequest instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.CreateEmployeeStationRequest instance) {
			writer.writeAscii(quoted_stationId);
			if (instance.getStationId() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getStationId(), writer);
			writer.writeAscii(quoted_employeeId);
			if (instance.getEmployeeId() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getEmployeeId(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.CreateEmployeeStationRequest instance) {
			boolean hasWritten = false;
			if (instance.getStationId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_stationId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getStationId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getEmployeeId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_employeeId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getEmployeeId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.admin_management.model.request.CreateEmployeeStationRequest bind(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.CreateEmployeeStationRequest instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.admin_management.model.request.CreateEmployeeStationRequest readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.admin_management.model.request.CreateEmployeeStationRequest instance = new com.admin_management.model.request.CreateEmployeeStationRequest();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.CreateEmployeeStationRequest instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1070 || !reader.wasLastName(name_stationId)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setStationId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1164 || !reader.wasLastName(name_employeeId)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setEmployeeId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 2);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.CreateEmployeeStationRequest instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -792049449:
					reader.getNextToken();
					instance.setEmployeeId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
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
					case -792049449:
						reader.getNextToken();
						instance.setEmployeeId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
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
