package com.admin_management.model.bo;



@javax.annotation.processing.Generated("dsl_json")
public class _Gender_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		EnumConverter enumConverter = new EnumConverter();
		__dsljson.registerWriter(com.admin_management.model.bo.Gender.class, enumConverter);
		__dsljson.registerReader(com.admin_management.model.bo.Gender.class, enumConverter);
	}
	public final static class EnumConverter implements com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.Gender>, com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.Gender> {
		public void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.bo.Gender value) {
			if (value == null) writer.writeNull();
			else {
				{ writer.writeByte((byte)'"'); writer.writeAscii(value.name()); writer.writeByte((byte)'"'); }
			}
		}
		public com.admin_management.model.bo.Gender read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return readStatic(reader);
		}
		public static com.admin_management.model.bo.Gender readStatic(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			switch (reader.calcHash()) {
				case -852314096:
					return com.admin_management.model.bo.Gender.MALE;
				case -2035096615:
					return com.admin_management.model.bo.Gender.FEMALE;
				case 269742090:
					return com.admin_management.model.bo.Gender.THIRD_GENDER;
				default:
					return com.admin_management.model.bo.Gender.valueOf(reader.getLastName());
			}
		}
	}
}
