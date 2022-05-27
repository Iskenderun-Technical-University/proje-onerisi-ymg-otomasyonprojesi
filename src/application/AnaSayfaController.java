package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.ui.Application;
import com.sun.media.jfxmediaimpl.platform.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnaSayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cari;

    @FXML
    private Button btn_StokList;

    @FXML
    private Button btn_FATURA;

    @FXML
    private Button btn_kullanici;

    @FXML
    private Button detaylýStok_btn;

    @FXML
    private Button BTN_CÝKÝS;

    @FXML
    void BTN_CÝKÝS_oNCLÝCK(ActionEvent event) {
		System.exit(0);    	

    }

    @FXML
    void btn_FATURA_oNCLÝCK(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("FaturaKes.fxml"));
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void btn_StokList_Onclik(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Stok.fxml"));
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void btn_cari_Click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("CariHesaplar.fxml"));
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void btn_kullanici_Click(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void detaylýStok_btn_Onclick(ActionEvent event) {
    	try {
    		Stage stage1 = new Stage();
			AnchorPane pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource("DetayliStokArama.fxml"));
			Scene scene = new Scene(pane1);
			stage1.setScene(scene);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() {
       
    }
}
