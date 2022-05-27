package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.iste.mysql.util.VeriTabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.*;

public class CariHesaplarController {

	public CariHesaplarController() {
		baglanti = VeriTabaniUtil.Baglan();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<CariHesaplar> table_cari_hesap;

	@FXML
	private TableColumn<CariHesaplar, Integer> cariID_col;

	@FXML
	private TableColumn<CariHesaplar, String> isim_col;

	@FXML
	private TableColumn<CariHesaplar, String> soyisim_col;

	@FXML
	private TableColumn<CariHesaplar, String> tc_col;

	@FXML
	private TableColumn<CariHesaplar, Float> borc_col;

	@FXML
	private TableColumn<CariHesaplar, String> tarih_col;

	@FXML
	private TableColumn<CariHesaplar, String> adres_col;

	@FXML
	private TextField isim_txt;

	@FXML
	private TextField soyisim_txt;

	@FXML
	private TextField tc_txt;

	@FXML
	private TextField borc_txt;

	@FXML
	private TextField adres_txt;

	@FXML
	private Button btn_ekle;

	@FXML
	private Button btn_yenile;

	@FXML
	private Button btn_guncelle;

	@FXML
	private Button btn_sil;

	@FXML
	void btn_sil_Click(ActionEvent event) {
		sql = "delete from carihesaplar where cariAd=? and cariSoyad=? and cariTC=? and cariBorc=? and cariAdres=?";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, isim_txt.getText().trim());
			sorgu.setString(2, soyisim_txt.getText().trim());
			sorgu.setString(3, tc_txt.getText().trim());
			sorgu.setFloat(4, Float.valueOf(borc_txt.getText().trim()));
			sorgu.setString(5, adres_txt.getText().trim());
			sorgu.executeUpdate();

			

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}


	}

	Connection baglanti = null;
	PreparedStatement sorgu = null;
	ResultSet getirilen = null;
	String sql;

	public void DegerleriGetir(TableView tablo) {
		sql = "select * from carihesaplar";
		ObservableList<CariHesaplar> cariListele = FXCollections.observableArrayList();
		Timestamp t = new Timestamp(System.currentTimeMillis());

		try {
			sorgu = baglanti.prepareStatement(sql);
			ResultSet getirilen = sorgu.executeQuery();
			while (getirilen.next()) {
				cariListele.add(new CariHesaplar(getirilen.getInt("cariID"), getirilen.getString("cariAd"),
						getirilen.getString("cariSoyad"), getirilen.getString("cariTC"),
						getirilen.getString("cariAdres"), getirilen.getFloat("cariBorc"),
						getirilen.getString("cariDate")));
			}

			cariID_col.setCellValueFactory(new PropertyValueFactory<>("cariID"));
			isim_col.setCellValueFactory(new PropertyValueFactory<>("cariAd"));
			soyisim_col.setCellValueFactory(new PropertyValueFactory<>("cariSoyad"));
			tc_col.setCellValueFactory(new PropertyValueFactory<>("cariTC"));
			borc_col.setCellValueFactory(new PropertyValueFactory<>("cariBorc"));
			adres_col.setCellValueFactory(new PropertyValueFactory<>("cariAdres"));
			tarih_col.setCellValueFactory(new PropertyValueFactory<>("cariDate"));

			table_cari_hesap.setItems(cariListele);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void btn_ekle_click(ActionEvent event) {

		sql = "insert into carihesaplar(cariAd, cariSoyad, cariTC, cariBorc, cariAdres, cariDate) values(?,?,?,?,?,?)";
		try {
			Timestamp t = new Timestamp(System.currentTimeMillis());
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, isim_txt.getText().trim());
			sorgu.setString(2, soyisim_txt.getText().trim());
			sorgu.setString(3, tc_txt.getText().trim());
			sorgu.setFloat(4, Float.valueOf(borc_txt.getText().trim()));
			sorgu.setString(5, adres_txt.getText().trim());
			sorgu.setString(6, t.toString());
			sorgu.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void btn_guncelle_Click(ActionEvent event) {
		sql = "update carihesaplar set cariAd=?, cariSoyad=?, cariTC=?, cariBorc=?, cariAdres=?, cariDate=? where cariAd=?";
		try {
			sorgu = baglanti.prepareStatement(sql);

			Timestamp t = new Timestamp(System.currentTimeMillis());
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, isim_txt.getText().trim());
			sorgu.setString(2, soyisim_txt.getText().trim());
			sorgu.setString(3, tc_txt.getText().trim());
			sorgu.setFloat(4, Float.valueOf(borc_txt.getText().trim()));
			sorgu.setString(5, adres_txt.getText().trim());
			sorgu.setString(6, t.toString());
			sorgu.setString(7, isim_txt.getText().trim());

			
			sorgu.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void btn_yenile_click(ActionEvent event) {
		DegerleriGetir(table_cari_hesap);

	}

	@FXML
	void tbl_Click(MouseEvent event) {
		CariHesaplar cariHesaplar = new CariHesaplar();
		cariHesaplar = (CariHesaplar) table_cari_hesap.getItems()
				.get(table_cari_hesap.getSelectionModel().getSelectedIndex());
		isim_txt.setText(cariHesaplar.getCariAd());
		soyisim_txt.setText(cariHesaplar.getCariSoyad());
		tc_txt.setText(cariHesaplar.getCariTC());
		borc_txt.setText(String.valueOf(cariHesaplar.getCariBorc()));
		adres_txt.setText(cariHesaplar.getCariAdres());

	}

	@FXML
	void initialize() {
		DegerleriGetir(table_cari_hesap);

	}
}
