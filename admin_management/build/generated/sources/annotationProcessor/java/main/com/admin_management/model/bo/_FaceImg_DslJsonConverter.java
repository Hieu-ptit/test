package com.admin_management.model.bo;



@javax.annotation.processing.Generated("dsl_json")
public class _FaceImg_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		EnumConverter enumConverter = new EnumConverter();
		__dsljson.registerWriter(com.admin_management.model.bo.FaceImg.class, enumConverter);
		__dsljson.registerReader(com.admin_management.model.bo.FaceImg.class, enumConverter);
	}
	public final static class EnumConverter implements com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.FaceImg>, com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.FaceImg> {
		public void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.bo.FaceImg value) {
			if (value == null) writer.writeNull();
			else {
				{ writer.writeByte((byte)'"'); writer.writeAscii(value.name()); writer.writeByte((byte)'"'); }
			}
		}
		public com.admin_management.model.bo.FaceImg read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return readStatic(reader);
		}
		public static com.admin_management.model.bo.FaceImg readStatic(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			switch (reader.calcHash()) {
				case -1003558344:
					return com.admin_management.model.bo.FaceImg.FRONT;
				case 122316834:
					return com.admin_management.model.bo.FaceImg.BACK;
				default:
					return com.admin_management.model.bo.FaceImg.valueOf(reader.getLastName());
			}
		}
	}
}
