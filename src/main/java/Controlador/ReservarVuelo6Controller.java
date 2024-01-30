/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.App;

/**
 * FXML Controller class
 *
 * @author Yumi
 */
public class ReservarVuelo6Controller implements Initializable {

   @FXML
   private VBox contenedorprimervuelo;
   @FXML
   private VBox contenedorsegundorvuelo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CargarPrimerVuelo();
        CargarSegundoVuelo();
        
    }    
    void CargarPrimerVuelo(){
        HBox contenedorHorizontal =new HBox();
        Label duracion= new Label("Duracion: "+ReservarVuelo2Controller.vueloseleccionado.getDuracion());
        HBox contenedorBoton =new HBox();
        Button boton=new Button("Detalles");
        boton.setOnAction(e->{
        Stage st =new Stage();
        VBox root=new VBox();
        Label Vuelo= new Label("Vuelo:"+ ReservarVuelo2Controller.vueloseleccionado.getCodigoVuelo());
        Label CodigoAvion= new Label(ReservarVuelo2Controller.vueloseleccionado.getCodigoAvion());
        Label tarifa = new Label(String.valueOf(ReservarVuelo3Controller.TarifaViaje1.getTipo()));
        root.getChildren().addAll(Vuelo,CodigoAvion,tarifa);
        Scene popup= new Scene(root);
        st.setScene(popup);
        st.show();
        
        
        });
            Label separador=new Label("-------------------");
            Label HoraInicio=new Label(ReservarVuelo2Controller.vueloseleccionado.getHsalida());
            Label HoraLlegada=new Label(ReservarVuelo2Controller.vueloseleccionado.getHLlegada());
            Label Precio=new Label(String.valueOf(ReservarVuelo2Controller.vueloseleccionado.getPrecio()));
             contenedorHorizontal.setSpacing(20);
             contenedorHorizontal.getChildren().addAll(HoraInicio,separador,HoraLlegada);
             contenedorBoton.setAlignment(Pos.CENTER_LEFT);
             contenedorBoton.setPadding(new Insets(0,0,0,10));
             contenedorBoton.getChildren().add(boton);
           contenedorprimervuelo.getChildren().addAll(duracion,contenedorHorizontal,Precio,contenedorBoton);
             
             
        
    }
    void CargarSegundoVuelo(){
        HBox contenedorHorizontal =new HBox();
        Label duracion= new Label("Duracion: "+ReservarVuelo4Controller.vueloseleccionado2.getDuracion());
        HBox contenedorBoton =new HBox();
        Button boton=new Button("Detalles");
        boton.setOnAction(e->{
        Stage st =new Stage();
        VBox root=new VBox();
        Label Vuelo= new Label("Vuelo:"+ ReservarVuelo4Controller.vueloseleccionado2.getCodigoVuelo());
        Label CodigoAvion= new Label(ReservarVuelo4Controller.vueloseleccionado2.getCodigoAvion());
        Label tarifa = new Label(String.valueOf(ReservarVuelo5Controller.TarifaViaje2.getTipo()));
        root.getChildren().addAll(Vuelo,CodigoAvion,tarifa);
        Scene popup= new Scene(root);
        st.setScene(popup);
        st.show();
        
        
        });
        
            Label separador=new Label("-------------------");
            Label HoraInicio=new Label(ReservarVuelo4Controller.vueloseleccionado2.getHsalida());
            Label HoraLlegada=new Label(ReservarVuelo4Controller.vueloseleccionado2.getHLlegada());
            Label Precio=new Label(String.valueOf(ReservarVuelo4Controller.vueloseleccionado2.getPrecio()));
             contenedorHorizontal.setSpacing(20);
             contenedorHorizontal.getChildren().addAll(HoraInicio,separador,HoraLlegada);
             contenedorBoton.setAlignment(Pos.CENTER_LEFT);
             contenedorBoton.setPadding(new Insets(0,0,0,10));
             contenedorBoton.getChildren().add(boton);
             contenedorsegundorvuelo.getChildren().addAll(duracion,contenedorHorizontal,Precio,contenedorBoton);
            
        
    }
    @FXML
    void Confirmar(ActionEvent event) {
        try{
     Stage ventana= (Stage) contenedorsegundorvuelo.getScene().getWindow();
     Scene escena=new  Scene(App.loadFXML("/Vistas/ReservarPasajeros"));
     ventana.setScene(escena);
        }catch(Exception a){
            a.printStackTrace();
        }

    }

    
}
