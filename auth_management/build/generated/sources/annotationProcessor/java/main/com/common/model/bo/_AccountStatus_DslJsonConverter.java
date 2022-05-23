package com.common.model.bo;



@javax.annotation.processing.Generated("dsl_json")
public class _AccountStatus_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		EnumConverter enumConverter = new EnumConverter();
		__dsljson.registerWriter(com.common.model.bo.AccountStatus.class, enumConverter);
		__dsljson.registerReader(com.common.model.bo.AccountStatus.class, enumConverter);
	}
	public final static class EnumConverter implements com.dslplatform.json.JsonWriter.WriteObject<com.common.model.bo.AccountStatus>, com.dslplatform.json.JsonReader.ReadObject<com.common.model.bo.AccountStatus> {
		public void write(final com.dslplatform.json.JsonWriter writer, final com.common.model.bo.AccountStatus value) {
			if (value == null) writer.writeNull();
			else {
				{ writer.writeByte((byte)'"'); writer.writeAscii(value.name()); writer.writeByte((byte)'"'); }
			}
		}
		public com.common.model.bo.AccountStatus read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return readStatic(reader);
		}
		public static com.common.model.bo.AccountStatus readStatic(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			switch (reader.calcHash()) {
				case -253003359:
					return com.common.model.bo.AccountStatus.FIRST;
				case 827339759:
					return com.common.model.bo.AccountStatus.ACTIVE;
				case 834793944:
					return com.common.model.bo.AccountStatus.INACTIVE;
				case -126775606:
					return com.common.model.bo.AccountStatus.DELETE;
				default:
					return com.common.model.bo.AccountStatus.valueOf(reader.getLastName());
			}
		}
	}
}
