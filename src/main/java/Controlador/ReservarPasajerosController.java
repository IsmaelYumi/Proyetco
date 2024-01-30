/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.App;

/**
 * FXML Controller class
 *
 * @author Yumi
 */
public class ReservarPasajerosController implements Initializable {

     
 @FXML
    private VBox ContenedorP;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      cargarPasajeros();
        
    } 
    void cargarPasajeros(){
        Button bt=new Button("Ingresar");
        bt.setOnAction(a->{
            try{
             Scene sc = new Scene(App.loadFXML("/Vistas/Pago"));
             Stage st=(Stage) ContenedorP.getScene().getWindow();
             st.setScene(sc);
            }catch(Exception i){
            i.printStackTrace();
            }
        });
        for(int i=1; i<=ReservarVueloController.numeroP;i++){
            Label pasajero= new Label("Persona: "+String.valueOf(i));
            Label Nombre=new Label("Nombre");
            Label Apellido=new Label("Apellido");
            Label Pasaporte= new Label("Pasaporte");
            Label Correo=new Label("Correo");
            HBox ContenedorPasajeros=new HBox();
            VBox SeccionUno= new VBox();
            VBox SeccionDos= new VBox();
            HBox seccionNombre =new HBox();
            HBox seccionApellido =new HBox();
             HBox seccionPasaporte =new HBox();
            HBox seccionCorreo =new HBox();
            /*Propiedades*/
            ContenedorPasajeros.setAlignment(Pos.CENTER);
            SeccionUno.setAlignment(Pos.CENTER);
            SeccionUno.setMaxWidth(250);
            SeccionDos.setAlignment(Pos.CENTER);
            SeccionDos.setMaxWidth(250);
            seccionNombre.setAlignment(Pos.CENTER);
            seccionApellido.setAlignment(Pos.CENTER);
            seccionPasaporte.setAlignment(Pos.CENTER);
            seccionCorreo.setAlignment(Pos.CENTER);
            ContenedorPasajeros.setSpacing(15);
            SeccionUno.setSpacing(15);
            SeccionDos.setSpacing(15);
            SeccionDos.setPadding(new Insets(22,0,0,0));
            seccionNombre.setSpacing(15);
            seccionApellido.setSpacing(15);
            seccionPasaporte.setSpacing(15);
            seccionCorreo.setSpacing(15);
            /*Propiedades*/
            TextField txtnombre=new TextField();
            TextField txtApellido=new TextField();
            TextField txtPasaporte=new TextField();
            TextField txtCorreo=new TextField();
            seccionNombre.getChildren().addAll(Nombre, txtnombre);
            seccionApellido.getChildren().addAll(Apellido, txtApellido);
            seccionPasaporte.getChildren().addAll(Pasaporte, txtPasaporte);
            seccionCorreo.getChildren().addAll(Correo, txtCorreo);
            SeccionUno.getChildren().addAll(pasajero,seccionNombre,seccionApellido);
            SeccionDos.getChildren().addAll(seccionPasaporte,seccionCorreo);
            ContenedorPasajeros.getChildren().addAll(SeccionUno,SeccionDos);
            ContenedorP.getChildren().add(ContenedorPasajeros);
          
      
        } ContenedorP.getChildren().add(bt);
       
        
    }
    
    
}
