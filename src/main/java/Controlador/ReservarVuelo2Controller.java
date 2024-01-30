/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Vuelo;
import modelo.App;
/**
 * FXML Controller class
 *
 * 
 */
public class ReservarVuelo2Controller implements Initializable {
    public static Vuelo vueloseleccionado;
    private ComboBox<String > Ordenar= new ComboBox<>();
    ArrayList<Vuelo> VuelosDisponibles= new ArrayList<>();
    ObservableList<Vuelo> lista= FXCollections.observableArrayList();
   @FXML
    private VBox ContenedorVuelos;
    @FXML
    private HBox ContenedorSeleccion; 
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CargarCombobox();
        CargarVuelos();
       DesplegarVuelos();
   
    } 
    void CargarCombobox(){
        Ordenar.getItems().addAll("Duracion");
        Ordenar.setOnAction(a->{
       if (Ordenar.getSelectionModel().getSelectedItem().equals("Duracion")){
       FXCollections.sort(lista);
       DesplegarVuelos();
       }
                });
        ContenedorSeleccion.getChildren().add(Ordenar);   
    }
    void CargarVuelos(){
        try{
        File fl=new File("src/main/resources/Textos/Vuelos.txt");
        FileReader fr= new FileReader(fl);
        BufferedReader br=new BufferedReader( fr);
        String linea;
        while((linea=br.readLine())!=null){
            String [] informacion= linea.split(",");
            Vuelo vuelo= new Vuelo(informacion[0],informacion[1],informacion[2],Integer.parseInt(informacion[3]),informacion[4],informacion[5],informacion[6],Double.parseDouble(informacion[7]));
           if(vuelo.getOrigen().equals(ReservarVueloController.LugarSalida)&&(vuelo.getDestino().equals(ReservarVueloController.LugarLlegada))){
                lista.add(vuelo);
                System.out.println(vuelo.getDestino());
           }
            
        }
        }catch(Exception e){
            e.printStackTrace();    
    }
    
    
}void DesplegarVuelos(){
    ContenedorVuelos.getChildren().clear();
  
    for(Vuelo v: lista){
         VBox contenedorInformacion= new VBox();
            HBox contenedorHorizontal=new HBox();
            contenedorInformacion.setOnMouseClicked(e->{
                try{
                vueloseleccionado=v;
               Stage actual=(Stage) contenedorHorizontal.getScene().getWindow();
               Scene scn=new Scene(App.loadFXML("/Vistas/ReservarVuelo3"));
               actual.setScene(scn);
                }catch(Exception a){
                    a.printStackTrace();
                }
          });
            Label duracion= new Label("Duracion: "+v.getDuracion());
            Label separador=new Label("-------------------");
            Label HoraInicio=new Label(v.getHsalida());
            Label HoraLlegada=new Label(v.getHLlegada());
            Label Precio=new Label(String.valueOf(v.getPrecio()));
          /*Estilizando y cambiando propiedades*/
          contenedorHorizontal.setSpacing(20);
          contenedorInformacion.setSpacing(10);
          contenedorInformacion.setAlignment(Pos.CENTER);
          contenedorHorizontal.setAlignment(Pos.CENTER);
          contenedorInformacion.setId("ContenedorInformacion");
          contenedorInformacion.getStylesheets().add(getClass().getResource("/Estilos/Estilos1.css").toExternalForm());
          contenedorHorizontal.getChildren().addAll(HoraInicio,separador,HoraLlegada);
          contenedorInformacion.getChildren().addAll(duracion,contenedorHorizontal,Precio);
          
          ContenedorVuelos.getChildren().add(contenedorInformacion);
           ContenedorVuelos.setStyle("-fx-background-image:url(\"/imagen/Fondo3.jpg\");\n" +
"    -fx-background-size:cover;");
ContenedorVuelos.getStylesheets.add("src/main/resources/Estilos/Estilo1.css");
    }
    
            
    
}
        }

