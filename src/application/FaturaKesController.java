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

public class FaturaKesController {

	public FaturaKesController() {
		baglanti = VeriTabaniUtil.Baglan();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Fatura> table_ana;

	@FXML
	private TableColumn<Fatura, Integer> faturaid_col;

	@FXML
	private TableColumn<Fatura, String> isim_col;

	@FXML
	private TableColumn<Fatura, String> soyisim_col;

	@FXML
	private TableColumn<Fatura, String> tc_col;

	@FXML
	private TableColumn<Fatura, Float> tutar_col;

	@FXML
	private TableColumn<Fatura, String> tarih_col;

	@FXML
	private TextField isim_txt;

	@FXML
	private TextField soyisim_txt;

	@FXML
	private TextField tc_txt;

	@FXML
	private TextField tutar_txt;

	@FXML
	private Button fatura_kes_btn;

	@FXML
	private Button sil_btn;

	@FXML
	private Button guncelle_buton;

	@FXML
	private Button tablo_guncelle_btn;

	Connection baglanti = null;
	PreparedStatement sorgu = null;
	ResultSet getirilen = null;
	String sql;

	public void Degerler(TableView tablo) {
		sql = "select * from faturalar";
		ObservableList<Fatura> faturaList = FXCollections.observableArrayList();

		try {

			sorgu = baglanti.prepareStatement(sql);
			ResultSet getirilen = sorgu.executeQuery();
			while (getirilen.next()) {
				faturaList.add(new Fatura(getirilen.getInt("faturaID"), getirilen.getString("musteriAd"),
						getirilen.getString("musteriSoyad"), getirilen.getString("musteriTC"),
						getirilen.getFloat("Fiyat"), getirilen.getString("Tarih")));
			}

			faturaid_col.setCellValueFactory(new PropertyValueFactory<>("faturaID"));
			isim_col.setCellValueFactory(new PropertyValueFactory<>("musteriAd"));
			soyisim_col.setCellValueFactory(new PropertyValueFactory<>("musteriSoyad"));
			tc_col.setCellValueFactory(new PropertyValueFactory<>("musteriTC"));
			tutar_col.setCellValueFactory(new PropertyValueFactory<>("Fiyat"));
			tarih_col.setCellValueFactory(new PropertyValueFactory<>("Tarih"));

			table_ana.setItems(faturaList);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void fatura_kes_btn_Click(ActionEvent event) {

		Timestamp t = new Timestamp(System.currentTimeMillis());

		sql = "insert into faturalar(musteriAd, musteriSoyad, musteriTC, Fiyat, Tarih) values(?,?,?,?,?)";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, isim_txt.getText().trim());
			sorgu.setString(2, soyisim_txt.getText().trim());
			sorgu.setString(3, tc_txt.getText().trim());

			sorgu.setFloat(4, Float.valueOf(tutar_txt.getText().trim()));
			sorgu.setString(5, t.toString());

			sorgu.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void guncelle_buton_click(ActionEvent event) {
		Timestamp t = new Timestamp(System.currentTimeMillis());


		sql = "update faturalar set musteriAd=?, musteriSoyad=?, musteriTC=?, Fiyat=?, Tarih=? where musteriAd=?";
		try {
			sorgu = baglanti.prepareStatement(sql);
			
			sorgu.setString(1, isim_txt.getText().trim());
			sorgu.setString(2, soyisim_txt.getText().trim());
			sorgu.setString(3, tc_txt.getText().trim());

			sorgu.setFloat(4, Float.valueOf(tutar_txt.getText().trim()));
			sorgu.setString(5, t.toString());
			sorgu.setString(6, isim_txt.getText().trim());


		
			sorgu.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}


	}

	@FXML
	void sil_btn_click(ActionEvent event) {
		
		sql = "delete from faturalar where musteriAd=? and musteriSoyad=? ";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, isim_txt.getText().trim());
			sorgu.setString(2, soyisim_txt.getText().trim());

			sorgu.executeUpdate();

			

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		
		

	}

	@FXML
	void table_ana_Click(MouseEvent event) {

		Fatura fatura = new Fatura();
		fatura = (Fatura) table_ana.getItems().get(table_ana.getSelectionModel().getSelectedIndex());

		isim_txt.setText(fatura.getMusteriAd());
		soyisim_txt.setText(fatura.getMusteriSoyad());
		tc_txt.setText(fatura.getMusteriTC());
		tutar_txt.setText(String.valueOf(fatura.getFiyat()));

	}

	@FXML
	void tablo_guncelle_btn_click(ActionEvent event) {
		Degerler(table_ana);

	}

	@FXML
	void initialize() {
		Degerler(table_ana);

	}
}
