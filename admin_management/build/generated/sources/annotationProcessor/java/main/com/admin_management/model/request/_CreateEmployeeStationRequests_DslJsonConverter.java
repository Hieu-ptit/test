package com.admin_management.model.request;



@javax.annotation.processing.Generated("dsl_json")
public class _CreateEmployeeStationRequests_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.admin_management.model.request.CreateEmployeeStationRequests.class, objectConverter);
		__dsljson.registerReader(com.admin_management.model.request.CreateEmployeeStationRequests.class, objectConverter);
		__dsljson.registerWriter(com.admin_management.model.request.CreateEmployeeStationRequests.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.admin_management.model.request.CreateEmployeeStationRequests>, com.dslplatform.json.JsonReader.BindObject<com.admin_management.model.request.CreateEmployeeStationRequests> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.request.CreateEmployeeStationRequest> reader_createEmployeeStationRequests;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.request.CreateEmployeeStationRequest> reader_createEmployeeStationRequests() {
			if (reader_createEmployeeStationRequests == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.request.CreateEmployeeStationRequest.class;
				reader_createEmployeeStationRequests = __dsljson.tryFindReader(manifest);
				if (reader_createEmployeeStationRequests == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_createEmployeeStationRequests;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.request.CreateEmployeeStationRequest> writer_createEmployeeStationRequests;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.request.CreateEmployeeStationRequest> writer_createEmployeeStationRequests() {
			if (writer_createEmployeeStationRequests == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.request.CreateEmployeeStationRequest.class;
				writer_createEmployeeStationRequests = __dsljson.tryFindWriter(manifest);
				if (writer_createEmployeeStationRequests == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_createEmployeeStationRequests;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.admin_management.model.request.CreateEmployeeStationRequests read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.admin_management.model.request.CreateEmployeeStationRequests());
		}
		private static final byte[] quoted_createEmployeeStationRequests = "\"create_employee_station_requests\":".getBytes(utf8);
		private static final byte[] name_createEmployeeStationRequests = "create_employee_station_requests".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.CreateEmployeeStationRequests instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.CreateEmployeeStationRequests instance) {
			writer.writeAscii(quoted_createEmployeeStationRequests);
			if (instance.getCreateEmployeeStationRequests() == null) writer.writeNull();
			else writer.serialize(instance.getCreateEmployeeStationRequests(), writer_createEmployeeStationRequests());
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.CreateEmployeeStationRequests instance) {
			boolean hasWritten = false;
			if (instance.getCreateEmployeeStationRequests() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_createEmployeeStationRequests); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getCreateEmployeeStationRequests(), writer_createEmployeeStationRequests());
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.admin_management.model.request.CreateEmployeeStationRequests bind(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.CreateEmployeeStationRequests instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.admin_management.model.request.CreateEmployeeStationRequests readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.admin_management.model.request.CreateEmployeeStationRequests instance = new com.admin_management.model.request.CreateEmployeeStationRequests();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.CreateEmployeeStationRequests instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 3439 || !reader.wasLastName(name_createEmployeeStationRequests)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setCreateEmployeeStationRequests(reader.readCollection(reader_createEmployeeStationRequests()));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 1);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.CreateEmployeeStationRequests instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 906298288:
					reader.getNextToken();
					instance.setCreateEmployeeStationRequests(reader.readCollection(reader_createEmployeeStationRequests()));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 906298288:
						reader.getNextToken();
						instance.setCreateEmployeeStationRequests(reader.readCollection(reader_createEmployeeStationRequests()));
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
