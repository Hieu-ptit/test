package com.admin_management.model.bo;



@javax.annotation.processing.Generated("dsl_json")
public class _DepartmentType_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		EnumConverter enumConverter = new EnumConverter();
		__dsljson.registerWriter(com.admin_management.model.bo.DepartmentType.class, enumConverter);
		__dsljson.registerReader(com.admin_management.model.bo.DepartmentType.class, enumConverter);
	}
	public final static class EnumConverter implements com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.DepartmentType>, com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.DepartmentType> {
		public void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.bo.DepartmentType value) {
			if (value == null) writer.writeNull();
			else {
				{ writer.writeByte((byte)'"'); writer.writeAscii(value.name()); writer.writeByte((byte)'"'); }
			}
		}
		public com.admin_management.model.bo.DepartmentType read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return readStatic(reader);
		}
		public static com.admin_management.model.bo.DepartmentType readStatic(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			switch (reader.calcHash()) {
				case 1283557251:
					return com.admin_management.model.bo.DepartmentType.ADMINISTRATIVE_COUNCIL;
				case -1937472687:
					return com.admin_management.model.bo.DepartmentType.FINANCIAL_ACCOUNTANT;
				case -964265298:
					return com.admin_management.model.bo.DepartmentType.ADMINISTRATIVE_STAFF;
				case 565824595:
					return com.admin_management.model.bo.DepartmentType.QUALITY_AND_ASSET_MANAGEMENT;
				case -1665812597:
					return com.admin_management.model.bo.DepartmentType.BUSINESS;
				case 530714630:
					return com.admin_management.model.bo.DepartmentType.TECHNICAL_MANAGEMENT;
				case -1667533036:
					return com.admin_management.model.bo.DepartmentType.INFORMATION_TECHNOLOGY;
				case -636404348:
					return com.admin_management.model.bo.DepartmentType.WAREHOUSE;
				case 1699341605:
					return com.admin_management.model.bo.DepartmentType.PETROL_STATIONS;
				case 532814747:
					return com.admin_management.model.bo.DepartmentType.CARRIAGE;
				default:
					return com.admin_management.model.bo.DepartmentType.valueOf(reader.getLastName());
			}
		}
	}
}
