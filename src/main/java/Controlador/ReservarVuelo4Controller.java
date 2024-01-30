/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.ReservarVuelo2Controller.vueloseleccionado;
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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.App;
import modelo.Vuelo;

/**
 *
 * 
 */
public class ReservarVuelo4Controller implements Initializable {
     @FXML
     private HBox ContenedorSeleccion;
     public static Vuelo vueloseleccionado2;   
     public ComboBox<String> cb=new ComboBox<>();
      @FXML
    private VBox Fondo;

    @FXML
    private VBox ContenedorVuelos;
    private ArrayList<Vuelo> VuelosDisponibles = new ArrayList<>(); 
     ObservableList<Vuelo> lista= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb.getItems().addAll("Duracion");
       
           cb.setOnAction(a->{
       if (cb.getSelectionModel().getSelectedItem().equals("Duracion")){
       FXCollections.sort(lista);
       DesplegarVuelos();
            }
            
                });
            ContenedorSeleccion.getChildren().add(cb);
        CargarVuelos();
        DesplegarVuelos();
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
            if(vuelo.getOrigen().equals(ReservarVueloController.LugarLlegada)&&vuelo.getDestino().equals(ReservarVueloController.LugarSalida)){
            lista.add(vuelo);   
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
                vueloseleccionado2=v;
               Stage actual=(Stage) contenedorHorizontal.getScene().getWindow();
               Scene scn=new Scene(App.loadFXML("/Vistas/ReservarVuelo5"));
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
           
    } 
    
}   
}
