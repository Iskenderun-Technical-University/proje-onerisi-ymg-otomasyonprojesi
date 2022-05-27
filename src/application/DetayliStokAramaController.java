package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.iste.mysql.util.VeriTabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.sql.*;

public class DetayliStokAramaController {

	public DetayliStokAramaController() {
		baglanti = VeriTabaniUtil.Baglan();

	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txt_fiield_arama;

	@FXML
	private ComboBox<String> combo;

	@FXML
	private Button sogula_btn;

	@FXML
	private TableView<Stok> table_ana;

	@FXML
	private TableColumn<Stok, Integer> motoId_col;

	@FXML
	private TableColumn<Stok, String> marka_col;

	@FXML
	private TableColumn<Stok, String> model_col;

	@FXML
	private TableColumn<Stok, Float> fiyat_col;

	@FXML
	private TableColumn<Stok, String> fatura_col;

	Connection baglanti = null;
	PreparedStatement sorgu = null;
	ResultSet getirilen = null;
	String sql;

	public void DegerGetir(TableView tablo, String sql) {

		// sql = "select * from stok";
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

			motoId_col.setCellValueFactory(new PropertyValueFactory<>("motorID"));
			marka_col.setCellValueFactory(new PropertyValueFactory<>("motorMarka"));
			model_col.setCellValueFactory(new PropertyValueFactory<>("motorModelYili"));
			fiyat_col.setCellValueFactory(new PropertyValueFactory<>("motorFiyat"));
			fatura_col.setCellValueFactory(new PropertyValueFactory<>("motorFaturaKesildiMi"));

			table_ana.setItems(stokList);

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void combo_onclick(ActionEvent event) {

	}

	@FXML
	void sogula_btn_click(ActionEvent event) {

	}

	@FXML
	void txt_fiield_arama_KeyPressed(KeyEvent event) {

		if (txt_fiield_arama.getText().equals("")) {
			String sql = "select * from stok";

			DegerGetir(table_ana, sql);

		} else {
			String sql = "select * from stok where motorMarka like '%" + txt_fiield_arama.getText() + "%'";

			DegerGetir(table_ana, sql);
		}

	}

	@FXML
	void table_Click(MouseEvent event) {

	}

	@FXML
	void txt_fiield_arama_Onaction(ActionEvent event) {

	}

	@FXML
	void initialize() {
		DegerGetir(table_ana, "select * from stok");

	}
}
