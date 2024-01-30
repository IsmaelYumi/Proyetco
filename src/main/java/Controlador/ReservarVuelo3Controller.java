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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Tarifa;
import modelo.App;

/**
 * FXML Controller class
 *
 * @author Yumi
 */
public class ReservarVuelo3Controller implements Initializable {
    ArrayList<Tarifa> tarifas=new ArrayList<>();
    public static Tarifa TarifaViaje1;
    @FXML
    private VBox ContenedorTarifas;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CargaTipoViajes();
        DesplegarViajes();
        // TODO
    }    
    void CargaTipoViajes(){
        try{
          File fl=new File("src/main/resources/Textos/tarifas.txt");
        FileReader fr= new FileReader(fl);
        BufferedReader br=new BufferedReader( fr);
        String linea;
        while((linea=br.readLine())!=null){
            String [] informacion= linea.split(",");
            Tarifa tf= new Tarifa(informacion[0],informacion[1].charAt(0),informacion[2],Double.parseDouble(informacion[3]));
            tarifas.add(tf);     
        }
            }
        catch(Exception a){
            a.printStackTrace();
        }
}
    void DesplegarViajes(){
        for(Tarifa ta: tarifas){
        
           VBox contenedorGeneral= new VBox();
           contenedorGeneral.setAlignment(Pos.CENTER);
           contenedorGeneral.setOnMouseClicked(e->{
               TarifaViaje1=ta;
               try{
               Stage st=(Stage) contenedorGeneral.getScene().getWindow();
               Scene scn=new Scene(App.loadFXML("/Vistas/ReservarVuelo4"));
               st.setScene(scn);
               
               }catch(Exception a){
                   a.printStackTrace();
               }
           });
           contenedorGeneral.setSpacing(20);
           String [] informacionTarifas= ta.getListaC().split("-");
           Label tipoTarifa=new Label(ta.getNombre());
           contenedorGeneral.getChildren().add(tipoTarifa);    
           for (int i=0; i<informacionTarifas.length;i++){
               Label info=new Label(informacionTarifas[i]);
               HBox despliegueInfo= new HBox();
               despliegueInfo.setAlignment(Pos.CENTER);
               despliegueInfo.getChildren().add(info);
              contenedorGeneral.setId("contenedorGeneral");
               contenedorGeneral.getStylesheets().add(getClass().getResource("/Estilos/Estilos1.css").toExternalForm());
               contenedorGeneral.getChildren().add(despliegueInfo); 
           }
           ContenedorTarifas.getChildren().add(contenedorGeneral);
           ContenedorTarifas.setStyle("-fx-background-image:url(\"/imagen/Fondo3.jpg\");\n" +
"    -fx-background-size:cover;");
           
           
        }
        
        
    }
}
