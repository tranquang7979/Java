package Model;

public class Company {
	private int Id, CityId;
	private String Logo,
    Banner,
    Name,
    Address,
    CompanyType,
    CountryFlag,
    CountryName,
    WorkingDay,
    OTOption,
    Description, CityName;
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	private int CompanySize;
	private float Rating;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public String getBanner() {
		return Banner;
	}
	public void setBanner(String banner) {
		Banner = banner;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCompanyType() {
		return CompanyType;
	}
	public void setCompanyType(String companyType) {
		CompanyType = companyType;
	}
	public int getCompanySize() {
		return CompanySize;
	}
	public void setCompanySize(int companySize) {
		CompanySize = companySize;
	}
	public String getCountryFlag() {
		return CountryFlag;
	}
	public void setCountryFlag(String countryFlag) {
		CountryFlag = countryFlag;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getWorkingDay() {
		return WorkingDay;
	}
	public void setWorkingDay(String workingDay) {
		WorkingDay = workingDay;
	}
	public String getOTOption() {
		return OTOption;
	}
	public void setOTOption(String oTOption) {
		OTOption = oTOption;
	}
	public float getRating() {
		return Rating;
	}
	public void setRating(float rating) {
		Rating = rating;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
}
