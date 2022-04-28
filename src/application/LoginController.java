package application;

import java.awt.event.WindowStateListener;
import java.net.URL;
import java.util.ResourceBundle;

import com.iste.mysql.util.VeriTabaniUtil;
import com.sun.media.jfxmediaimpl.platform.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;

public class LoginController {

	public LoginController() {
		baglanti = VeriTabaniUtil.Baglan();

	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Text lbl1;

	@FXML
	private TextField txt1;

	@FXML
	private TextField txt2;

	@FXML
	private Button grs_btn;

	@FXML
	private Button yeniHesap_btn;

	@FXML
	void grs_btn_Click(ActionEvent event) {

		sql = "select * from login where userName=? and userPassword=?";
		try {
			sorgu = baglanti.prepareStatement(sql);
			sorgu.setString(1, txt1.getText().trim());
			sorgu.setString(2, VeriTabaniUtil.MD5Sifreleme(txt2.getText().trim()));
			ResultSet getirilen = sorgu.executeQuery();
			if (!getirilen.next())
				lbl1.setText("Kullancý Adý veya Parola Hatalý");
			else {
				lbl1.setText("Girþi baþarýlý!");
				try {

					Stage stage1 = new Stage();
					AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
					Scene scene = new Scene(pane1);
					scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
					stage1.setScene(scene);
					stage1.show();

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("OK");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}

	}

	@FXML
	void yeniHesap_btn_Click(ActionEvent event) {

		try {
			Stage stage1 = new Stage();
			AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(pane1);
			scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

			stage1.setScene(scene);
			stage1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	Connection baglanti = null;
	PreparedStatement sorgu = null;
	ResultSet getirilen = null;
	String sql;

	@FXML
	void initialize() {

	}
}
