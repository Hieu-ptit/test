package com.common.model;



@javax.annotation.processing.Generated("dsl_json")
public class _Gender_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		EnumConverter enumConverter = new EnumConverter();
		__dsljson.registerWriter(com.common.model.Gender.class, enumConverter);
		__dsljson.registerReader(com.common.model.Gender.class, enumConverter);
	}
	public final static class EnumConverter implements com.dslplatform.json.JsonWriter.WriteObject<com.common.model.Gender>, com.dslplatform.json.JsonReader.ReadObject<com.common.model.Gender> {
		public void write(final com.dslplatform.json.JsonWriter writer, final com.common.model.Gender value) {
			if (value == null) writer.writeNull();
			else {
				{ writer.writeByte((byte)'"'); writer.writeAscii(value.name()); writer.writeByte((byte)'"'); }
			}
		}
		public com.common.model.Gender read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return readStatic(reader);
		}
		public static com.common.model.Gender readStatic(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			switch (reader.calcHash()) {
				case -852314096:
					return com.common.model.Gender.MALE;
				case -2035096615:
					return com.common.model.Gender.FEMALE;
				case 1589871459:
					return com.common.model.Gender.UNDEFINED;
				default:
					return com.common.model.Gender.valueOf(reader.getLastName());
			}
		}
	}
}
