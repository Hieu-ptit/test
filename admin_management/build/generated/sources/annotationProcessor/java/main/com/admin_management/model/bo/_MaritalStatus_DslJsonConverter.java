package com.admin_management.model.bo;



@javax.annotation.processing.Generated("dsl_json")
public class _MaritalStatus_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		EnumConverter enumConverter = new EnumConverter();
		__dsljson.registerWriter(com.admin_management.model.bo.MaritalStatus.class, enumConverter);
		__dsljson.registerReader(com.admin_management.model.bo.MaritalStatus.class, enumConverter);
	}
	public final static class EnumConverter implements com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.MaritalStatus>, com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.MaritalStatus> {
		public void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.bo.MaritalStatus value) {
			if (value == null) writer.writeNull();
			else {
				{ writer.writeByte((byte)'"'); writer.writeAscii(value.name()); writer.writeByte((byte)'"'); }
			}
		}
		public com.admin_management.model.bo.MaritalStatus read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return readStatic(reader);
		}
		public static com.admin_management.model.bo.MaritalStatus readStatic(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			switch (reader.calcHash()) {
				case 671277138:
					return com.admin_management.model.bo.MaritalStatus.UNMARRIED;
				case 1039924087:
					return com.admin_management.model.bo.MaritalStatus.MARRIED;
				default:
					return com.admin_management.model.bo.MaritalStatus.valueOf(reader.getLastName());
			}
		}
	}
}
