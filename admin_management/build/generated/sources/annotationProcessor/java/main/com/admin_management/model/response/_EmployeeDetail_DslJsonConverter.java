package com.admin_management.model.response;



@javax.annotation.processing.Generated("dsl_json")
public class _EmployeeDetail_DslJsonConverter implements com.dslplatform.json.Configuration {
	private static final java.nio.charset.Charset utf8 = java.nio.charset.Charset.forName("UTF-8");
	@Override
	public void configure(com.dslplatform.json.DslJson __dsljson) {
		ObjectFormatConverter objectConverter = new ObjectFormatConverter(__dsljson);
		__dsljson.registerBinder(com.admin_management.model.response.EmployeeDetail.class, objectConverter);
		__dsljson.registerReader(com.admin_management.model.response.EmployeeDetail.class, objectConverter);
		__dsljson.registerWriter(com.admin_management.model.response.EmployeeDetail.class, objectConverter);
	}
	public final static class ObjectFormatConverter implements com.dslplatform.json.runtime.FormatConverter<com.admin_management.model.response.EmployeeDetail>, com.dslplatform.json.JsonReader.BindObject<com.admin_management.model.response.EmployeeDetail> {
		private final boolean alwaysSerialize;
		private final com.dslplatform.json.DslJson __dsljson;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.LocationDetail> reader_ward;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.LocationDetail> reader_ward() {
			if (reader_ward == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.bo.LocationDetail.class;
				reader_ward = __dsljson.tryFindReader(manifest);
				if (reader_ward == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_ward;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.LocationDetail> writer_ward;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.LocationDetail> writer_ward() {
			if (writer_ward == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.bo.LocationDetail.class;
				writer_ward = __dsljson.tryFindWriter(manifest);
				if (writer_ward == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_ward;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.LocationDetail> reader_province;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.LocationDetail> reader_province() {
			if (reader_province == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.bo.LocationDetail.class;
				reader_province = __dsljson.tryFindReader(manifest);
				if (reader_province == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_province;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.LocationDetail> writer_province;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.LocationDetail> writer_province() {
			if (writer_province == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.bo.LocationDetail.class;
				writer_province = __dsljson.tryFindWriter(manifest);
				if (writer_province == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_province;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.FileResponse> reader_attachment;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.FileResponse> reader_attachment() {
			if (reader_attachment == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.FileResponse.class;
				reader_attachment = __dsljson.tryFindReader(manifest);
				if (reader_attachment == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_attachment;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.FileResponse> writer_attachment;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.FileResponse> writer_attachment() {
			if (writer_attachment == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.FileResponse.class;
				writer_attachment = __dsljson.tryFindWriter(manifest);
				if (writer_attachment == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_attachment;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_department;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_department() {
			if (reader_department == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				reader_department = __dsljson.tryFindReader(manifest);
				if (reader_department == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_department;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_department;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_department() {
			if (writer_department == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				writer_department = __dsljson.tryFindWriter(manifest);
				if (writer_department == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_department;
		}
		private com.dslplatform.json.JsonReader.ReadObject<java.util.List<com.admin_management.model.bo.CredentialImages>> reader_credentialImages;
		private com.dslplatform.json.JsonReader.ReadObject<java.util.List<com.admin_management.model.bo.CredentialImages>> reader_credentialImages() {
			if (reader_credentialImages == null) {
				java.lang.reflect.Type manifest = com.dslplatform.json.runtime.Generics.makeParameterizedType(java.util.List.class, com.admin_management.model.bo.CredentialImages.class);
				reader_credentialImages = __dsljson.tryFindReader(manifest);
				if (reader_credentialImages == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_credentialImages;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<java.util.List<com.admin_management.model.bo.CredentialImages>> writer_credentialImages;
		private com.dslplatform.json.JsonWriter.WriteObject<java.util.List<com.admin_management.model.bo.CredentialImages>> writer_credentialImages() {
			if (writer_credentialImages == null) {
				java.lang.reflect.Type manifest = com.dslplatform.json.runtime.Generics.makeParameterizedType(java.util.List.class, com.admin_management.model.bo.CredentialImages.class);
				writer_credentialImages = __dsljson.tryFindWriter(manifest);
				if (writer_credentialImages == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_credentialImages;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_positions;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.PropertiesResponse> reader_positions() {
			if (reader_positions == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				reader_positions = __dsljson.tryFindReader(manifest);
				if (reader_positions == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_positions;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_positions;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.PropertiesResponse> writer_positions() {
			if (writer_positions == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.PropertiesResponse.class;
				writer_positions = __dsljson.tryFindWriter(manifest);
				if (writer_positions == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_positions;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.CredentialImages> reader_avatar;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.CredentialImages> reader_avatar() {
			if (reader_avatar == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.bo.CredentialImages.class;
				reader_avatar = __dsljson.tryFindReader(manifest);
				if (reader_avatar == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_avatar;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.CredentialImages> writer_avatar;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.CredentialImages> writer_avatar() {
			if (writer_avatar == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.bo.CredentialImages.class;
				writer_avatar = __dsljson.tryFindWriter(manifest);
				if (writer_avatar == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_avatar;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.StationResponse> reader_stationList;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.response.StationResponse> reader_stationList() {
			if (reader_stationList == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.StationResponse.class;
				reader_stationList = __dsljson.tryFindReader(manifest);
				if (reader_stationList == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_stationList;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.StationResponse> writer_stationList;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.response.StationResponse> writer_stationList() {
			if (writer_stationList == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.response.StationResponse.class;
				writer_stationList = __dsljson.tryFindWriter(manifest);
				if (writer_stationList == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_stationList;
		}
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.LocationDetail> reader_district;
		private com.dslplatform.json.JsonReader.ReadObject<com.admin_management.model.bo.LocationDetail> reader_district() {
			if (reader_district == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.bo.LocationDetail.class;
				reader_district = __dsljson.tryFindReader(manifest);
				if (reader_district == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find reader for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return reader_district;
		}
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.LocationDetail> writer_district;
		private com.dslplatform.json.JsonWriter.WriteObject<com.admin_management.model.bo.LocationDetail> writer_district() {
			if (writer_district == null) {
				java.lang.reflect.Type manifest = com.admin_management.model.bo.LocationDetail.class;
				writer_district = __dsljson.tryFindWriter(manifest);
				if (writer_district == null) {
					throw new com.dslplatform.json.ConfigurationException("Unable to find writer for " + manifest + ". Enable runtime conversion by initializing DslJson with new DslJson<>(Settings.basicSetup())");
				}
			}
			return writer_district;
		}
		public ObjectFormatConverter(com.dslplatform.json.DslJson __dsljson) {
			this.alwaysSerialize = !__dsljson.omitDefaults;
			this.__dsljson = __dsljson;
		}
		public com.admin_management.model.response.EmployeeDetail read(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			if (reader.wasNull()) return null;
			return bind(reader, new com.admin_management.model.response.EmployeeDetail());
		}
		private static final byte[] quoted_maritalStatus = "\"maritalStatus\":".getBytes(utf8);
		private static final byte[] name_maritalStatus = "maritalStatus".getBytes(utf8);
		private static final byte[] quoted_fullAddress = ",\"fullAddress\":".getBytes(utf8);
		private static final byte[] name_fullAddress = "fullAddress".getBytes(utf8);
		private static final byte[] quoted_name = ",\"name\":".getBytes(utf8);
		private static final byte[] name_name = "name".getBytes(utf8);
		private static final byte[] quoted_district = ",\"district\":".getBytes(utf8);
		private static final byte[] name_district = "district".getBytes(utf8);
		private static final byte[] quoted_stationList = ",\"stationList\":".getBytes(utf8);
		private static final byte[] name_stationList = "stationList".getBytes(utf8);
		private static final byte[] quoted_phone = ",\"phone\":".getBytes(utf8);
		private static final byte[] name_phone = "phone".getBytes(utf8);
		private static final byte[] quoted_accountId = ",\"account_id\":".getBytes(utf8);
		private static final byte[] name_accountId = "account_id".getBytes(utf8);
		private static final byte[] quoted_religion = ",\"religion\":".getBytes(utf8);
		private static final byte[] name_religion = "religion".getBytes(utf8);
		private static final byte[] quoted_avatar = ",\"avatar\":".getBytes(utf8);
		private static final byte[] name_avatar = "avatar".getBytes(utf8);
		private static final byte[] quoted_positions = ",\"positions\":".getBytes(utf8);
		private static final byte[] name_positions = "positions".getBytes(utf8);
		private static final byte[] quoted_dateOfBirth = ",\"dateOfBirth\":".getBytes(utf8);
		private static final byte[] name_dateOfBirth = "dateOfBirth".getBytes(utf8);
		private static final byte[] quoted_sex = ",\"sex\":".getBytes(utf8);
		private static final byte[] name_sex = "sex".getBytes(utf8);
		private static final byte[] quoted_identityCardNumber = ",\"identityCardNumber\":".getBytes(utf8);
		private static final byte[] name_identityCardNumber = "identityCardNumber".getBytes(utf8);
		private static final byte[] quoted_address = ",\"address\":".getBytes(utf8);
		private static final byte[] name_address = "address".getBytes(utf8);
		private static final byte[] quoted_email = ",\"email\":".getBytes(utf8);
		private static final byte[] name_email = "email".getBytes(utf8);
		private static final byte[] quoted_credentialImages = ",\"credentialImages\":".getBytes(utf8);
		private static final byte[] name_credentialImages = "credentialImages".getBytes(utf8);
		private static final byte[] quoted_supplyAddress = ",\"supplyAddress\":".getBytes(utf8);
		private static final byte[] name_supplyAddress = "supplyAddress".getBytes(utf8);
		private static final byte[] quoted_department = ",\"department\":".getBytes(utf8);
		private static final byte[] name_department = "department".getBytes(utf8);
		private static final byte[] quoted_id = ",\"id\":".getBytes(utf8);
		private static final byte[] name_id = "id".getBytes(utf8);
		private static final byte[] quoted_attachment = ",\"attachment\":".getBytes(utf8);
		private static final byte[] name_attachment = "attachment".getBytes(utf8);
		private static final byte[] quoted_province = ",\"province\":".getBytes(utf8);
		private static final byte[] name_province = "province".getBytes(utf8);
		private static final byte[] quoted_ward = ",\"ward\":".getBytes(utf8);
		private static final byte[] name_ward = "ward".getBytes(utf8);
		private static final byte[] quoted_dateRange = ",\"dateRange\":".getBytes(utf8);
		private static final byte[] name_dateRange = "dateRange".getBytes(utf8);
		private static final byte[] quoted_nation = ",\"nation\":".getBytes(utf8);
		private static final byte[] name_nation = "nation".getBytes(utf8);
		private static final byte[] quoted_code = ",\"code\":".getBytes(utf8);
		private static final byte[] name_code = "code".getBytes(utf8);
		public final void write(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.EmployeeDetail instance) {
			if (instance == null) writer.writeNull();
			else {
				writer.writeByte((byte)'{');
				if (alwaysSerialize) { writeContentFull(writer, instance); writer.writeByte((byte)'}'); }
				else if (writeContentMinimal(writer, instance)) writer.getByteBuffer()[writer.size() - 1] = '}';
				else writer.writeByte((byte)'}');
			}
		}
		public void writeContentFull(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.EmployeeDetail instance) {
			writer.writeAscii(quoted_maritalStatus);
			if (instance.getMaritalStatus() == null) writer.writeNull();
			else { writer.writeByte((byte)'"'); writer.writeAscii(instance.getMaritalStatus().name()); writer.writeByte((byte)'"'); }
			writer.writeAscii(quoted_fullAddress);
			if (instance.getFullAddress() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getFullAddress(), writer);
			writer.writeAscii(quoted_name);
			if (instance.getName() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
			writer.writeAscii(quoted_district);
			if (instance.getDistrict() == null) writer.writeNull();
			else writer_district().write(writer, instance.getDistrict());
			writer.writeAscii(quoted_stationList);
			if (instance.getStationList() == null) writer.writeNull();
			else writer.serialize(instance.getStationList(), writer_stationList());
			writer.writeAscii(quoted_phone);
			if (instance.getPhone() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getPhone(), writer);
			writer.writeAscii(quoted_accountId);
			if (instance.getAccountId() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
			writer.writeAscii(quoted_religion);
			if (instance.getReligion() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getReligion(), writer);
			writer.writeAscii(quoted_avatar);
			if (instance.getAvatar() == null) writer.writeNull();
			else writer_avatar().write(writer, instance.getAvatar());
			writer.writeAscii(quoted_positions);
			if (instance.getPositions() == null) writer.writeNull();
			else writer_positions().write(writer, instance.getPositions());
			writer.writeAscii(quoted_dateOfBirth);
			if (instance.getDateOfBirth() == null) writer.writeNull();
			else com.dslplatform.json.JavaTimeConverter.serialize(instance.getDateOfBirth(), writer);
			writer.writeAscii(quoted_sex);
			if (instance.getSex() == null) writer.writeNull();
			else { writer.writeByte((byte)'"'); writer.writeAscii(instance.getSex().name()); writer.writeByte((byte)'"'); }
			writer.writeAscii(quoted_identityCardNumber);
			if (instance.getIdentityCardNumber() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getIdentityCardNumber(), writer);
			writer.writeAscii(quoted_address);
			if (instance.getAddress() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getAddress(), writer);
			writer.writeAscii(quoted_email);
			if (instance.getEmail() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getEmail(), writer);
			writer.writeAscii(quoted_credentialImages);
			if (instance.getCredentialImages() == null) writer.writeNull();
			else writer_credentialImages().write(writer, instance.getCredentialImages());
			writer.writeAscii(quoted_supplyAddress);
			if (instance.getSupplyAddress() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getSupplyAddress(), writer);
			writer.writeAscii(quoted_department);
			if (instance.getDepartment() == null) writer.writeNull();
			else writer_department().write(writer, instance.getDepartment());
			writer.writeAscii(quoted_id);
			if (instance.getId() == null) writer.writeNull();
			else com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
			writer.writeAscii(quoted_attachment);
			if (instance.getAttachment() == null) writer.writeNull();
			else writer.serialize(instance.getAttachment(), writer_attachment());
			writer.writeAscii(quoted_province);
			if (instance.getProvince() == null) writer.writeNull();
			else writer_province().write(writer, instance.getProvince());
			writer.writeAscii(quoted_ward);
			if (instance.getWard() == null) writer.writeNull();
			else writer_ward().write(writer, instance.getWard());
			writer.writeAscii(quoted_dateRange);
			if (instance.getDateRange() == null) writer.writeNull();
			else com.dslplatform.json.JavaTimeConverter.serialize(instance.getDateRange(), writer);
			writer.writeAscii(quoted_nation);
			if (instance.getNation() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getNation(), writer);
			writer.writeAscii(quoted_code);
			if (instance.getCode() == null) writer.writeNull();
			else com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
		}
		public boolean writeContentMinimal(final com.dslplatform.json.JsonWriter writer, final com.admin_management.model.response.EmployeeDetail instance) {
			boolean hasWritten = false;
			if (instance.getMaritalStatus() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_maritalStatus); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				{ writer.writeByte((byte)'"'); writer.writeAscii(instance.getMaritalStatus().name()); writer.writeByte((byte)'"'); }
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getFullAddress() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_fullAddress); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getFullAddress(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getName() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_name); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getName(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getDistrict() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_district); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_district().write(writer, instance.getDistrict());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getStationList() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_stationList); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getStationList(), writer_stationList());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getPhone() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_phone); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getPhone(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAccountId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_accountId); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getAccountId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getReligion() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_religion); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getReligion(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAvatar() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_avatar); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_avatar().write(writer, instance.getAvatar());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getPositions() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_positions); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_positions().write(writer, instance.getPositions());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getDateOfBirth() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_dateOfBirth); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.JavaTimeConverter.serialize(instance.getDateOfBirth(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getSex() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_sex); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				{ writer.writeByte((byte)'"'); writer.writeAscii(instance.getSex().name()); writer.writeByte((byte)'"'); }
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getIdentityCardNumber() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_identityCardNumber); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getIdentityCardNumber(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAddress() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_address); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getAddress(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getEmail() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_email); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getEmail(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getCredentialImages() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_credentialImages); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_credentialImages().write(writer, instance.getCredentialImages());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getSupplyAddress() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_supplyAddress); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getSupplyAddress(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getDepartment() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_department); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_department().write(writer, instance.getDepartment());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getId() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_id); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.NumberConverter.serialize(instance.getId(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getAttachment() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_attachment); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer.serialize(instance.getAttachment(), writer_attachment());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getProvince() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_province); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_province().write(writer, instance.getProvince());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getWard() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_ward); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				writer_ward().write(writer, instance.getWard());
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getDateRange() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_dateRange); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.JavaTimeConverter.serialize(instance.getDateRange(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getNation() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_nation); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getNation(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			if (instance.getCode() != null) {
				writer.writeByte((byte)'"'); writer.writeAscii(name_code); writer.writeByte((byte)'"'); writer.writeByte((byte)':');
				com.dslplatform.json.StringConverter.serialize(instance.getCode(), writer);
				writer.writeByte((byte)','); hasWritten = true;
			}
			return hasWritten;
		}
		public com.admin_management.model.response.EmployeeDetail bind(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.EmployeeDetail instance) throws java.io.IOException {
			if (reader.last() != '{') throw reader.newParseError("Expecting '{' for object start");
			reader.getNextToken();
			bindContent(reader, instance);
			return instance;
		}
		public com.admin_management.model.response.EmployeeDetail readContent(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
			com.admin_management.model.response.EmployeeDetail instance = new com.admin_management.model.response.EmployeeDetail();
 			bindContent(reader, instance);
			return instance;
		}
		public void bindContent(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.EmployeeDetail instance) throws java.io.IOException {
			if (reader.last() == '}') return;
			if (reader.fillNameWeakHash() != 1390 || !reader.wasLastName(name_maritalStatus)) { bindSlow(reader, instance, 0); return; }
			reader.getNextToken();
			instance.setMaritalStatus(reader.wasNull() ? null : com.admin_management.model.bo._MaritalStatus_DslJsonConverter.EnumConverter.readStatic(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1145 || !reader.wasLastName(name_fullAddress)) { bindSlow(reader, instance, 1); return; }
			reader.getNextToken();
			instance.setFullAddress(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 417 || !reader.wasLastName(name_name)) { bindSlow(reader, instance, 2); return; }
			reader.getNextToken();
			instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 870 || !reader.wasLastName(name_district)) { bindSlow(reader, instance, 3); return; }
			reader.getNextToken();
			instance.setDistrict(reader_district().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1182 || !reader.wasLastName(name_stationList)) { bindSlow(reader, instance, 4); return; }
			reader.getNextToken();
			instance.setStationList(reader.readCollection(reader_stationList()));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 538 || !reader.wasLastName(name_phone)) { bindSlow(reader, instance, 5); return; }
			reader.getNextToken();
			instance.setPhone(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1049 || !reader.wasLastName(name_accountId)) { bindSlow(reader, instance, 6); return; }
			reader.getNextToken();
			instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 857 || !reader.wasLastName(name_religion)) { bindSlow(reader, instance, 7); return; }
			reader.getNextToken();
			instance.setReligion(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 639 || !reader.wasLastName(name_avatar)) { bindSlow(reader, instance, 8); return; }
			reader.getNextToken();
			instance.setAvatar(reader_avatar().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1000 || !reader.wasLastName(name_positions)) { bindSlow(reader, instance, 9); return; }
			reader.getNextToken();
			instance.setPositions(reader_positions().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1100 || !reader.wasLastName(name_dateOfBirth)) { bindSlow(reader, instance, 10); return; }
			reader.getNextToken();
			if (reader.wasNull()) instance.setDateOfBirth(null);
			else instance.setDateOfBirth(com.dslplatform.json.JavaTimeConverter.deserializeDateTime(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 336 || !reader.wasLastName(name_sex)) { bindSlow(reader, instance, 11); return; }
			reader.getNextToken();
			instance.setSex(reader.wasNull() ? null : com.admin_management.model.bo._Gender_DslJsonConverter.EnumConverter.readStatic(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1869 || !reader.wasLastName(name_identityCardNumber)) { bindSlow(reader, instance, 12); return; }
			reader.getNextToken();
			instance.setIdentityCardNumber(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 742 || !reader.wasLastName(name_address)) { bindSlow(reader, instance, 13); return; }
			reader.getNextToken();
			instance.setAddress(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 520 || !reader.wasLastName(name_email)) { bindSlow(reader, instance, 14); return; }
			reader.getNextToken();
			instance.setEmail(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1649 || !reader.wasLastName(name_credentialImages)) { bindSlow(reader, instance, 15); return; }
			reader.getNextToken();
			instance.setCredentialImages(reader_credentialImages().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1395 || !reader.wasLastName(name_supplyAddress)) { bindSlow(reader, instance, 16); return; }
			reader.getNextToken();
			instance.setSupplyAddress(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1076 || !reader.wasLastName(name_department)) { bindSlow(reader, instance, 17); return; }
			reader.getNextToken();
			instance.setDepartment(reader_department().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 205 || !reader.wasLastName(name_id)) { bindSlow(reader, instance, 18); return; }
			reader.getNextToken();
			instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 1065 || !reader.wasLastName(name_attachment)) { bindSlow(reader, instance, 19); return; }
			reader.getNextToken();
			instance.setAttachment(reader.readCollection(reader_attachment()));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 870 || !reader.wasLastName(name_province)) { bindSlow(reader, instance, 20); return; }
			reader.getNextToken();
			instance.setProvince(reader_province().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 430 || !reader.wasLastName(name_ward)) { bindSlow(reader, instance, 21); return; }
			reader.getNextToken();
			instance.setWard(reader_ward().read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 907 || !reader.wasLastName(name_dateRange)) { bindSlow(reader, instance, 22); return; }
			reader.getNextToken();
			if (reader.wasNull()) instance.setDateRange(null);
			else instance.setDateRange(com.dslplatform.json.JavaTimeConverter.deserializeDateTime(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 649 || !reader.wasLastName(name_nation)) { bindSlow(reader, instance, 23); return; }
			reader.getNextToken();
			instance.setNation(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() == '}')  return;
			if (reader.last() != ',') throw reader.newParseError("Expecting ',' for other mandatory properties"); else reader.getNextToken();
			if (reader.fillNameWeakHash() != 411 || !reader.wasLastName(name_code)) { bindSlow(reader, instance, 24); return; }
			reader.getNextToken();
			instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
			if (reader.getNextToken() != '}') {
				if (reader.last() == ',') {
					reader.getNextToken();
					reader.fillNameWeakHash();
					bindSlow(reader, instance, 25);
				}
				if (reader.last() != '}') throw reader.newParseError("Expecting '}' for object end");
			}
		}
		private void bindSlow(final com.dslplatform.json.JsonReader reader, final com.admin_management.model.response.EmployeeDetail instance, int index) throws java.io.IOException {
			switch(reader.getLastHash()) {
				case -114201356:
					reader.getNextToken();
					instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 962051386:
					reader.getNextToken();
					instance.setNation(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -103332922:
					reader.getNextToken();
					if (reader.wasNull()) instance.setDateRange(null);
					else instance.setDateRange(com.dslplatform.json.JavaTimeConverter.deserializeDateTime(reader));
					reader.getNextToken();
					break;
				case 2063227699:
					reader.getNextToken();
					instance.setWard(reader_ward().read(reader));
					reader.getNextToken();
					break;
				case 426203205:
					reader.getNextToken();
					instance.setProvince(reader_province().read(reader));
					reader.getNextToken();
					break;
				case -1513391000:
					reader.getNextToken();
					instance.setAttachment(reader.readCollection(reader_attachment()));
					reader.getNextToken();
					break;
				case 926444256:
					reader.getNextToken();
					instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
					reader.getNextToken();
					break;
				case -818043577:
					reader.getNextToken();
					instance.setDepartment(reader_department().read(reader));
					reader.getNextToken();
					break;
				case -2025026426:
					reader.getNextToken();
					instance.setSupplyAddress(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 1035139394:
					reader.getNextToken();
					instance.setCredentialImages(reader_credentialImages().read(reader));
					reader.getNextToken();
					break;
				case -1970842681:
					reader.getNextToken();
					instance.setEmail(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 745154899:
					reader.getNextToken();
					instance.setAddress(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 473211880:
					reader.getNextToken();
					instance.setIdentityCardNumber(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -769189401:
					reader.getNextToken();
					instance.setSex(reader.wasNull() ? null : com.admin_management.model.bo._Gender_DslJsonConverter.EnumConverter.readStatic(reader));
					reader.getNextToken();
					break;
				case -1750396907:
					reader.getNextToken();
					if (reader.wasNull()) instance.setDateOfBirth(null);
					else instance.setDateOfBirth(com.dslplatform.json.JavaTimeConverter.deserializeDateTime(reader));
					reader.getNextToken();
					break;
				case 1591249019:
					reader.getNextToken();
					instance.setPositions(reader_positions().read(reader));
					reader.getNextToken();
					break;
				case 573852100:
					reader.getNextToken();
					instance.setAvatar(reader_avatar().read(reader));
					reader.getNextToken();
					break;
				case 1539931302:
					reader.getNextToken();
					instance.setReligion(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 2003883388:
					reader.getNextToken();
					instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 2000032175:
					reader.getNextToken();
					instance.setPhone(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -1104064325:
					reader.getNextToken();
					instance.setStationList(reader.readCollection(reader_stationList()));
					reader.getNextToken();
					break;
				case -1085887825:
					reader.getNextToken();
					instance.setDistrict(reader_district().read(reader));
					reader.getNextToken();
					break;
				case -1925595674:
					reader.getNextToken();
					instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case 630859148:
					reader.getNextToken();
					instance.setFullAddress(com.dslplatform.json.StringConverter.READER.read(reader));
					reader.getNextToken();
					break;
				case -2010193779:
					reader.getNextToken();
					instance.setMaritalStatus(reader.wasNull() ? null : com.admin_management.model.bo._MaritalStatus_DslJsonConverter.EnumConverter.readStatic(reader));
					reader.getNextToken();
					break;
				default:
					reader.getNextToken();
					reader.skip();
			}
			while (reader.last() == ','){
				reader.getNextToken();
				switch(reader.fillName()) {
					case -114201356:
						reader.getNextToken();
						instance.setCode(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 962051386:
						reader.getNextToken();
						instance.setNation(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -103332922:
						reader.getNextToken();
						if (reader.wasNull()) instance.setDateRange(null);
						else instance.setDateRange(com.dslplatform.json.JavaTimeConverter.deserializeDateTime(reader));
						reader.getNextToken();
						break;
					case 2063227699:
						reader.getNextToken();
						instance.setWard(reader_ward().read(reader));
						reader.getNextToken();
						break;
					case 426203205:
						reader.getNextToken();
						instance.setProvince(reader_province().read(reader));
						reader.getNextToken();
						break;
					case -1513391000:
						reader.getNextToken();
						instance.setAttachment(reader.readCollection(reader_attachment()));
						reader.getNextToken();
						break;
					case 926444256:
						reader.getNextToken();
						instance.setId(com.dslplatform.json.NumberConverter.NULLABLE_INT_READER.read(reader));
						reader.getNextToken();
						break;
					case -818043577:
						reader.getNextToken();
						instance.setDepartment(reader_department().read(reader));
						reader.getNextToken();
						break;
					case -2025026426:
						reader.getNextToken();
						instance.setSupplyAddress(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 1035139394:
						reader.getNextToken();
						instance.setCredentialImages(reader_credentialImages().read(reader));
						reader.getNextToken();
						break;
					case -1970842681:
						reader.getNextToken();
						instance.setEmail(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 745154899:
						reader.getNextToken();
						instance.setAddress(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 473211880:
						reader.getNextToken();
						instance.setIdentityCardNumber(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -769189401:
						reader.getNextToken();
						instance.setSex(reader.wasNull() ? null : com.admin_management.model.bo._Gender_DslJsonConverter.EnumConverter.readStatic(reader));
						reader.getNextToken();
						break;
					case -1750396907:
						reader.getNextToken();
						if (reader.wasNull()) instance.setDateOfBirth(null);
						else instance.setDateOfBirth(com.dslplatform.json.JavaTimeConverter.deserializeDateTime(reader));
						reader.getNextToken();
						break;
					case 1591249019:
						reader.getNextToken();
						instance.setPositions(reader_positions().read(reader));
						reader.getNextToken();
						break;
					case 573852100:
						reader.getNextToken();
						instance.setAvatar(reader_avatar().read(reader));
						reader.getNextToken();
						break;
					case 1539931302:
						reader.getNextToken();
						instance.setReligion(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 2003883388:
						reader.getNextToken();
						instance.setAccountId(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 2000032175:
						reader.getNextToken();
						instance.setPhone(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -1104064325:
						reader.getNextToken();
						instance.setStationList(reader.readCollection(reader_stationList()));
						reader.getNextToken();
						break;
					case -1085887825:
						reader.getNextToken();
						instance.setDistrict(reader_district().read(reader));
						reader.getNextToken();
						break;
					case -1925595674:
						reader.getNextToken();
						instance.setName(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case 630859148:
						reader.getNextToken();
						instance.setFullAddress(com.dslplatform.json.StringConverter.READER.read(reader));
						reader.getNextToken();
						break;
					case -2010193779:
						reader.getNextToken();
						instance.setMaritalStatus(reader.wasNull() ? null : com.admin_management.model.bo._MaritalStatus_DslJsonConverter.EnumConverter.readStatic(reader));
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
