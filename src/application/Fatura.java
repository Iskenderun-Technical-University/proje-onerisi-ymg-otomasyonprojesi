package application;

public class Fatura {

	private int faturaID;
	private String musteriAd;
	private String musteriSoyad;
	private String musteriTC;
	private Float Fiyat;
	private String Tarih;

	public Fatura() {
	}

	public Fatura(int faturaID, String musteriAd, String musteriSoyad, String musteriTC, Float fiyat, String tarih) {
		this.faturaID = faturaID;
		this.musteriAd = musteriAd;
		this.musteriSoyad = musteriSoyad;
		this.musteriTC = musteriTC;
		Fiyat = fiyat;
		Tarih = tarih;
	}

	public int getFaturaID() {
		return faturaID;
	}

	public void setFaturaID(int faturaID) {
		this.faturaID = faturaID;
	}

	public String getMusteriAd() {
		return musteriAd;
	}

	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}

	public String getMusteriSoyad() {
		return musteriSoyad;
	}

	public void setMusteriSoyad(String musteriSoyad) {
		this.musteriSoyad = musteriSoyad;
	}

	public String getMusteriTC() {
		return musteriTC;
	}

	public void setMusteriTC(String musteriTC) {
		this.musteriTC = musteriTC;
	}

	public Float getFiyat() {
		return Fiyat;
	}

	public void setFiyat(Float fiyat) {
		Fiyat = fiyat;
	}

	public String getTarih() {
		return Tarih;
	}

	public void setTarih(String tarih) {
		Tarih = tarih;
	}

}
