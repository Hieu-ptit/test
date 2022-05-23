package com.admin_management.model.request;



@javax.annotation.processing.Generated("dsl_json")
public class _EmployeeIdRequest_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.admin_management.model.request.EmployeeIdRequest.class, objectConverter);
		__dsljson.registerReader(com.admin_management.model.request.EmployeeIdRequest.class, objectConverter);
		__dsljson.registerWriter(com.admin_management.model.request.EmployeeIdRequest.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.admin_management.model.request.EmployeeIdRequest>, com.dslplatform.json.JsonReader.BindObject<com.admin_management.model.request.EmployeeIdRequest> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private final com.dslplatform.json.JsonReader.ReadObject<java.lang.Integer> reader_employeeIds;
		private final com.dslplatform.json.JsonWriter.WriteObject<java.lang.Integer> writer_employeeIds;
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
			this.reader_employeeIds = com.dslplatform.json.NumberConverter.NULLABLE_INT_READER;
			this.writer_employeeIds = com.dslplatform.json.NumberConverter.INT_WRITER;
		}
		public com.admin_management.model.request.EmployeeIdRequest read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.admin_management.model.request.EmployeeIdRequest());
		}
		private static final byte[] quoted_employeeIds = "\"employee_ids\":".getBytes(utf8);
		private static final byte[] name_employeeIds = "employee_ids".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.EmployeeIdRequest instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.EmployeeIdRequest instance) {
			writer.writeAscii(quoted_employeeIds);
			if (instance.getEmployeeIds() == null) writer.writeNull();
			else writer.serialize(instance.getEmployeeIds(), writer_employeeIds);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.request.EmployeeIdRequest instance) {
			boolean hasWritten = false;
			if (instance.getEmployeeIds() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_employeeIds); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getEmployeeIds(), writer_employeeIds);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.admin_management.model.request.EmployeeIdRequest bind(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.EmployeeIdRequest instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.admin_management.model.request.EmployeeIdRequest readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.admin_management.model.request.EmployeeIdRequest instance = new com.admin_management.model.request.EmployeeIdRequest();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.EmployeeIdRequest instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1279 || !reader.wasLastName(name_employeeIds)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setEmployeeIds(reader.readCollection(reader_employeeIds));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 1);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.request.EmployeeIdRequest instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case 1383094828:
					reader.getNextToken();
					instance.setEmployeeIds(reader.readCollection(reader_employeeIds));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case 1383094828:
						reader.getNextToken();
						instance.setEmployeeIds(reader.readCollection(reader_employeeIds));
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
