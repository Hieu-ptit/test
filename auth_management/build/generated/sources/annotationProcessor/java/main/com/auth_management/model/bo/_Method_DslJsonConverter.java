package com.auth_management.model.bo;



@javax.annotation.processing.Generated("dsl_json")
public class _Method_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		EnumConverter enumConverter = new EnumConverter();
		__dsljson.registerWriter(com.auth_management.model.bo.Method.class, enumConverter);
		__dsljson.registerReader(com.auth_management.model.bo.Method.class, enumConverter);
	}
	public final static class EnumConverter implements com.dslplatform.json.JsonWriter.WriteObject<com.auth_management.model.bo.Method>, com.dslplatform.json.JsonReader.ReadObject<com.auth_management.model.bo.Method> {
		public void write(final com.dslplatform.json.JsonWriter writer, final com.auth_management.model.bo.Method value) {
			if (value == null) writer.writeNull();
			else {
				{ writer.writeByte((byte)'"'); writer.writeAscii(value.name()); writer.writeByte((byte)'"'); }
			}
		}
		public com.auth_management.model.bo.Method read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return readStatic(reader);
		}
		public static com.auth_management.model.bo.Method readStatic(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			switch (reader.calcHash()) {
				case -1763262857:
					return com.auth_management.model.bo.Method.GET;
				case 1929554311:
					return com.auth_management.model.bo.Method.POST;
				case -299258354:
					return com.auth_management.model.bo.Method.PUT;
				case -126775606:
					return com.auth_management.model.bo.Method.DELETE;
				default:
					return com.auth_management.model.bo.Method.valueOf(reader.getLastName());
			}
		}
	}
}
