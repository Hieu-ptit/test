package com.admin_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _TypeMedia_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		EnumConverter enumConverter = new EnumConverter();
		__dsljson.registerWriter(com.admin_management.model.response.TypeMedia.class, enumConverter);
		__dsljson.registerReader(com.admin_management.model.response.TypeMedia.class, enumConverter);
	}
	public final static class EnumConverter implements com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.TypeMedia>, com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.TypeMedia> {
		public void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.TypeMedia value) {
			if (value == null) writer.writeNull();
			else {
				{ writer.writeByte((byte)'"'); writer.writeAscii(value.name()); writer.writeByte((byte)'"'); }
			}
		}
		public com.admin_management.model.response.TypeMedia read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return readStatic(reader);
		}
		public static com.admin_management.model.response.TypeMedia readStatic(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			switch (reader.calcHash()) {
				case 1538971482:
					return com.admin_management.model.response.TypeMedia.IMAGE;
				case 859270736:
					return com.admin_management.model.response.TypeMedia.EXCEL;
				case 1894199125:
					return com.admin_management.model.response.TypeMedia.OTHER;
				default:
					return com.admin_management.model.response.TypeMedia.valueOf(reader.getLastName());
			}
		}
	}
}
