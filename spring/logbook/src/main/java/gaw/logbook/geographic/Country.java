package gaw.logbook.geographic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
	@JsonProperty("RowNumber")
	private int rowNumber;

	@JsonProperty("CountryCode2")
	private String countryCode2;
	
	@JsonProperty("CountryCode3")
	private String countryCode3;
	
	@JsonProperty("Country")
	private String country;
	
	@JsonProperty("ContinentCode")
	private String continentCode;
	
	@JsonProperty("Continent")
	private String continent;	
	
	public Country() {
		super();
	}

	public Country(int rowNumber, String countryCode2, String countryCode3, String country, String continentCode,
			String continent) {
		super();
		this.rowNumber = rowNumber;
		this.countryCode2 = countryCode2;
		this.countryCode3 = countryCode3;
		this.country = country;
		this.continentCode = continentCode;
		this.continent = continent;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getCountryCode2() {
		return countryCode2;
	}

	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	public String getCountryCode3() {
		return countryCode3;
	}

	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinentCode() {
		return continentCode;
	}

	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}	
	
	
}
