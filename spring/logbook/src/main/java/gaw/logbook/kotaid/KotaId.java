package gaw.logbook.kotaid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KotaId {
	@JsonProperty("ID")
	private int id;
	
	@NotNull(message="Kota not null")
	@Size(min=1, message="Kota not null")
	@JsonProperty("Kota")
	private String kota;
	
	@JsonProperty("Provinsi")
	private String provinsi;
	
	
	@JsonProperty("Bps2010")
	private int bps2010;
	
	@JsonProperty("Kemendagri2015")
	private int kemendagri2015;
	
	public KotaId() {
		super();
	}

	public KotaId(int id, String kota, String provinsi, int bps2010, int kemendagri2015) {
		super();
		this.id = id;
		this.kota = kota;
		this.provinsi = provinsi;
		this.bps2010 = bps2010;
		this.kemendagri2015 = kemendagri2015;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public String getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}
	public int getBps2010() {
		return bps2010;
	}
	public void setBps2010(int bps2010) {
		this.bps2010 = bps2010;
	}
	public int getKemendagri2015() {
		return kemendagri2015;
	}
	public void setKemendagri2015(int kemendagri2015) {
		this.kemendagri2015 = kemendagri2015;
	}
}
