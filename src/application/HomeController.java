package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.iste.mysql.util.VeriTabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class HomeController {

	public HomeController() {
		baglanti = VeriTabaniUtil.Baglan();
	}

	@FXML
	private Label lbl1;

	@FXML
	private TextField txt1;
	@FXML
	private TextField txt2;

	@FXML
	private TextField txt3;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button ekle_btn;

	@FXML
	private Button sli_btn;

	@FXML
	private Button guncelle_btn;

	@FXML
	private Button login_btn;

	Connection baglanti = null;
	PreparedStatement sorgu = null;
	ResultSet getirilen = null;
	String sql;

	@FXML
	void ekle_btn_Click(ActionEvent event) {
		sql = "insert into login(userName, userPassword, userYetki) values(?,?,?)";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, txt1.getText().trim());
			sorgu.setString(2, VeriTabaniUtil.MD5Sifreleme(txt2.getText().trim()));
			sorgu.setString(3, txt3.getText().trim());
			sorgu.executeUpdate();
			lbl1.setText("ekleme  islemi tamamlandi.");

		} catch (Exception e) {
			lbl1.setText(e.getMessage().toString());
		}

	}

	@FXML
	void guncelle_btn_Click(ActionEvent event) {
		sql = "update login set userPassword=? where userName=?";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, txt1.getText().trim());
			sorgu.setString(2, VeriTabaniUtil.MD5Sifreleme(txt2.getText().trim()));
			sorgu.executeUpdate();
			lbl1.setText("guncelleme tamamlandi.");

		} catch (Exception e) {
			lbl1.setText(e.getMessage().toString());
		}

	}

	@FXML
	void login_btn_Click(ActionEvent event) {
		sql = "select * from login where userName=? and userPassword=?";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, txt1.getText().trim());
			sorgu.setString(2, VeriTabaniUtil.MD5Sifreleme(txt2.getText().trim()));
			ResultSet getirilen = sorgu.executeQuery();
			if (!getirilen.next())
				lbl1.setText("Kullancý yok");
			else {

				try {
					Stage stage1 = new Stage();
					AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
					Scene scene = new Scene(pane1);
					stage1.setScene(scene);
					stage1.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("OK");
				System.out.println("TAMAM");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@FXML
	void sli_btn_Click(ActionEvent event) {
		sql = "delete from login where userName=? and userPassword=?";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, txt1.getText().trim());
			sorgu.setString(2, VeriTabaniUtil.MD5Sifreleme(txt2.getText().trim()));
			sorgu.executeUpdate();
			lbl1.setText("silme islemi tamamlandi.");

		} catch (Exception e) {
			lbl1.setText(e.getMessage().toString());
		}

	}

	@FXML
	void initialize() {

	}
}
