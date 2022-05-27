package application;

public class Stok {

	private int motorID;
	private String motorMarka;
	private String motorModelYili;
	private String motorRenk;
	private Float motorFiyat;
	private String motorSasiNo;
	private String motorMotorNo;
	private String motorFaturaKesildiMi;

	public Stok() {
	}

	public Stok(int motorID, String motorMarka, String motorModelYili, String motorRenk, Float motorFiyat,
			String motorSasiNo, String motorMotorNo, String motorFaturaKesildiMi) {
		this.motorID = motorID;
		this.motorMarka = motorMarka;
		this.motorModelYili = motorModelYili;
		this.motorRenk = motorRenk;
		this.motorFiyat = motorFiyat;
		this.motorSasiNo = motorSasiNo;
		this.motorMotorNo = motorMotorNo;
		this.motorFaturaKesildiMi = motorFaturaKesildiMi;
	}

	public int getMotorID() {
		return motorID;
	}

	public void setMotorID(int motorID) {
		this.motorID = motorID;
	}

	public String getMotorMarka() {
		return motorMarka;
	}

	public void setMotorMarka(String motorMarka) {
		this.motorMarka = motorMarka;
	}

	public String getMotorModelYili() {
		return motorModelYili;
	}

	public void setMotorModelYili(String motorModelYili) {
		this.motorModelYili = motorModelYili;
	}

	public String getMotorRenk() {
		return motorRenk;
	}

	public void setMotorRenk(String motorRenk) {
		this.motorRenk = motorRenk;
	}

	public Float getMotorFiyat() {
		return motorFiyat;
	}

	public void setMotorFiyat(Float motorFiyat) {
		this.motorFiyat = motorFiyat;
	}

	public String getMotorSasiNo() {
		return motorSasiNo;
	}

	public void setMotorSasiNo(String motorSasiNo) {
		this.motorSasiNo = motorSasiNo;
	}

	public String getMotorMotorNo() {
		return motorMotorNo;
	}

	public void setMotorMotorNo(String motorMotorNo) {
		this.motorMotorNo = motorMotorNo;
	}

	public String getMotorFaturaKesildiMi() {
		return motorFaturaKesildiMi;
	}

	public void setMotorFaturaKesildiMi(String motorFaturaKesildiMi) {
		this.motorFaturaKesildiMi = motorFaturaKesildiMi;
	}

}
