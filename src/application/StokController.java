package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.iste.mysql.util.VeriTabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class StokController {

	public StokController() {
		baglanti = VeriTabaniUtil.Baglan();

	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Stok> table_ana;

	@FXML
	private TableColumn<Stok, Integer> motoid_col;

	@FXML
	private TableColumn<Stok, String> marka_col;

	@FXML
	private TableColumn<Stok, String> modelyili_col;

	@FXML
	private TableColumn<Stok, String> renk_col;

	@FXML
	private TableColumn<Stok, Float> fiyat_col;

	@FXML
	private TableColumn<Stok, String> fatura_col;

	@FXML
	private TableColumn<Stok, String> motorno_col;

	@FXML
	private TableColumn<Stok, String> sasi_col;

	@FXML
	private TextField modelyili_txt;

	@FXML
	private TextField marka_txt;

	@FXML
	private TextField fiyat_txt;

	@FXML
	private TextField renk_txt;

	@FXML
	private TextField fatura_txt;

	@FXML
	private TextField motorno_txt;

	@FXML
	private TextField sasi_txt;

	@FXML
	private Button yeni_kayit_btn;

	@FXML
	private Button guncelle_btn;

	@FXML
	private Button sil_btn;

	@FXML
	private Button tablo_gubcelle;

	@FXML
	private Label lbl_sonuc;

	Connection baglanti = null;
	PreparedStatement sorgu = null;
	ResultSet getirilen = null;
	String sql;

	public void DegerGetir(TableView tablo) {

		sql = "select * from stok";
		ObservableList<Stok> stokList = FXCollections.observableArrayList();

		try {
			sorgu = baglanti.prepareStatement(sql);
			ResultSet getirilen = sorgu.executeQuery();
			while (getirilen.next()) {
				stokList.add(new Stok(getirilen.getInt("motorID"), getirilen.getString("motorMarka"),
						getirilen.getString("motorModelYili"), getirilen.getString("motorRenk"),
						getirilen.getFloat("motorFiyat"), getirilen.getString("motorSasiNo"),
						getirilen.getString("motorMotorNo"), getirilen.getString("motorFaturaKesildiMi")));
			}

			motoid_col.setCellValueFactory(new PropertyValueFactory<>("motorID"));
			marka_col.setCellValueFactory(new PropertyValueFactory<>("motorMarka"));
			modelyili_col.setCellValueFactory(new PropertyValueFactory<>("motorModelYili"));
			renk_col.setCellValueFactory(new PropertyValueFactory<>("motorRenk"));
			fiyat_col.setCellValueFactory(new PropertyValueFactory<>("motorFiyat"));
			fatura_col.setCellValueFactory(new PropertyValueFactory<>("motorFaturaKesildiMi"));
			motorno_col.setCellValueFactory(new PropertyValueFactory<>("motorMotorNo"));
			sasi_col.setCellValueFactory(new PropertyValueFactory<>("motorSasiNo"));

			table_ana.setItems(stokList);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void guncelle_btn_Click(ActionEvent event) {
		
		sql = "update stok set motorMarka=?, motorModelYili=?, motorRenk=?, motorFiyat=?, motorSasiNo=?, motorMotorNo=?, motorFaturaKesildiMi=? where motorMarka=?";
		try {
			sorgu = baglanti.prepareStatement(sql);

			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, marka_txt.getText().trim());
			sorgu.setString(2, modelyili_txt.getText().trim());
			sorgu.setString(3, renk_txt.getText().trim());

			sorgu.setFloat(4, Float.valueOf(fiyat_txt.getText().trim()));
			sorgu.setString(5, sasi_txt.getText().trim());

			sorgu.setString(6, motorno_txt.getText().trim());
			sorgu.setString(7, fatura_txt.getText().trim());
			sorgu.setString(8, marka_txt.getText().trim());
			sorgu.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

		

	}

	@FXML
	void sil_btn_Click(ActionEvent event) {
		sql = "delete from STOK where motorMarka=? and motorModelYili=? ";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, marka_txt.getText().trim());
			sorgu.setString(2, modelyili_col.getText().trim());
		

			sorgu.executeUpdate();

			

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		

	}

	@FXML
	void tablo_gubcelle__Click(ActionEvent event) {
		DegerGetir(table_ana);

	}

	@FXML
	void yeni_kayit_btn_Click(ActionEvent event) {

		sql = "insert into stok(motorMarka, motorModelYili, motorRenk, motorFiyat, motorSasiNo, motorMotorNo, motorFaturaKesildiMi) values(?,?,?,?,?,?,?)";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, marka_txt.getText().trim());
			sorgu.setString(2, modelyili_col.getText().trim());
			sorgu.setString(3, renk_txt.getText().trim());

			sorgu.setFloat(4, Float.valueOf(fiyat_txt.getText().trim()));
			sorgu.setString(5, sasi_txt.getText().trim());

			sorgu.setString(6, motorno_txt.getText().trim());
			sorgu.setString(7, fatura_txt.getText().trim());

			sorgu.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void table_ana_Click(MouseEvent event) {
		Stok stok = new Stok();
		stok = (Stok) table_ana.getItems().get(table_ana.getSelectionModel().getSelectedIndex());

		marka_txt.setText(stok.getMotorMarka());
		modelyili_txt.setText(stok.getMotorModelYili());
		renk_txt.setText(stok.getMotorRenk());
		fiyat_txt.setText(String.valueOf(stok.getMotorFiyat()));
		fatura_txt.setText(stok.getMotorFaturaKesildiMi());
		motorno_txt.setText(stok.getMotorMotorNo());
		sasi_txt.setText(stok.getMotorSasiNo());

	}

	@FXML
	void initialize() {
		DegerGetir(table_ana);

	}
}
