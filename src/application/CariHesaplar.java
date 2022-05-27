package application;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class CariHesaplar {
	

	private int cariID;
	private String cariAd;
	private String cariSoyad;
	private String cariTC;
	private String cariAdres;
	private Float cariBorc;
	private String cariDate;

	public CariHesaplar() {
	}

	

	



	public CariHesaplar(int cariID, String cariAd, String cariSoyad, String cariTC, String cariAdres, Float cariBorc,
			String cariDate) {
		this.cariID = cariID;
		this.cariAd = cariAd;
		this.cariSoyad = cariSoyad;
		this.cariTC = cariTC;
		this.cariAdres = cariAdres;
		this.cariBorc = cariBorc;
		this.cariDate = cariDate;
	}







	public int getCariID() {
		return cariID;
	}

	public void setCariID(int cariID) {
		this.cariID = cariID;
	}

	public String getCariAd() {
		return cariAd;
	}

	public void setCariAd(String cariAd) {
		this.cariAd = cariAd;
	}

	public String getCariSoyad() {
		return cariSoyad;
	}

	public void setCariSoyad(String cariSoyad) {
		this.cariSoyad = cariSoyad;
	}

	public String getCariTC() {
		return cariTC;
	}

	public void setCariTC(String cariTC) {
		this.cariTC = cariTC;
	}

	public String getCariAdres() {
		return cariAdres;
	}

	public void setCariAdres(String cariAdres) {
		this.cariAdres = cariAdres;
	}

	public Float getCariBorc() {
		return cariBorc;
	}

	public void setCariBorc(Float cariBorc) {
		this.cariBorc = cariBorc;
	}



	public String getCariDate() {
		return cariDate;
	}



	public void setCariDate(String cariDate) {
		this.cariDate = cariDate;
	}

	

}
