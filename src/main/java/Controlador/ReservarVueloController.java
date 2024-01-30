/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.App;

/**
 * FXML Controller class
 *
 * @author Yumi
 */
public class ReservarVueloController implements Initializable {

   public static String LugarSalida;
   public static String LugarLlegada;
   public static String fecha_partida;
   public static String fecha_Regreso;
   public static int  numeroP;
   
   private ComboBox<String> origen= new ComboBox<>() ;
   private Spinner sp;
   private ComboBox<String> destino= new ComboBox<>();
   @FXML
   private HBox contenedorcantidad;
   @FXML
   private HBox ContenedorOrigen;
   @FXML
   private HBox contenedorDestino;
   @FXML
   private DatePicker DateRetorno;
   @FXML
   private DatePicker DateSalida;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        origen.setOnAction(e->{
            LugarSalida=origen.getSelectionModel().getSelectedItem();  
        });
        destino.setOnAction(a->{
        LugarLlegada=destino.getSelectionModel().getSelectedItem();});
        DateSalida.setOnAction(a ->{
        fecha_partida=DateSalida.getValue().toString();});
        DateRetorno.setOnAction(a ->{
        fecha_Regreso=DateRetorno.getValue().toString();});
        cargaSpiner();
        CargarOrigen();
        CargarDestinos();
        ContenedorOrigen.getChildren().add(origen);
        contenedorDestino.getChildren().add(destino);
        
       
    }   
    void CargarDestinos (){
        try{
            File file=new File("src/main/resources/Textos/destinos.txt");
            FileReader fr=new FileReader(file);
            BufferedReader br= new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                String [] info=linea.split(",");
                destino.getItems().add(info[0]); 
        }
             }catch(Exception e){
                 e.printStackTrace();             
                    }
    }
    void CargarOrigen(){
        origen.getItems().addAll("Guayaquil","Manta","Quito");
        
    }
    void cargaSpiner(){
        ObservableList lis= FXCollections.observableArrayList(1,2,3,4,5);
        sp=new Spinner<Integer>(lis);
        sp.setOnMouseClicked(e->{
         numeroP=(int) sp.getValue();});
        contenedorcantidad.getChildren().add(sp);
        
    }
       @FXML
    void Buscar(ActionEvent event) {
      if(LugarLlegada==null|| LugarSalida==null || fecha_partida==null || fecha_Regreso==null){
          Alert al=new Alert(Alert.AlertType.INFORMATION);
                al.setContentText("Debe escoger fecha");
               al.setTitle("Informacion");
                al.showAndWait();
          
      }else{
          try{
              System.out.println(LugarLlegada);
               System.out.println(LugarSalida);
          Stage ventana= (Stage) origen.getScene().getWindow();
          Scene ns = new Scene(App.loadFXML("/Vistas/ReservarVuelo2"));         
          ventana.setScene(ns);
          }catch(Exception a){
              a.printStackTrace();
          }
              
      }
        

    }
    
}
