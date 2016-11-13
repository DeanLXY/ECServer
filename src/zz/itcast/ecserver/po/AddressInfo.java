package zz.itcast.ecserver.po;

/**
 * 用户地址信息
 * 
 * @author wangx
 *
 */
public class AddressInfo {
	private int id;
	private String name;
	private String phoneNumber;
	private String fixedtel;
	// city_id 是id
	// cityId 是id对应的文本
	private String provinceId;
	private String cityId;
	private String areaId;
	private String addressDetail;
	private String zipCode;
	private boolean isDefault;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFixedtel() {
		return fixedtel;
	}

	public void setFixedtel(String fixedtel) {
		this.fixedtel = fixedtel;
	}


	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}


	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}


	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public AddressInfo(int id, String name, String phoneNumber, String fixedtel, String provinceId, String cityId,
			String areaId, String addressDetail, String zipCode, boolean isDefault) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.fixedtel = fixedtel;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.addressDetail = addressDetail;
		this.zipCode = zipCode;
		this.isDefault = isDefault;
	}

}
