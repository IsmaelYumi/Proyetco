/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.App;
import modelo.Promocion;
import modelo.CodigoInvalidoException;
import modelo.DatosIncompletosExcpetion;

/**
 * FXML Controller class
 *
 * @author Yumi
 * 
 * 
 * 
 */
public class PagoController implements Initializable {
    TextField txtnumero=new TextField();
    TextField txtFechaExpiracion=new TextField();
    PasswordField txtCVV=new PasswordField();
    public static int Descuento;
    public static char tipo;
    public static Stage actual;
     @FXML
    private TextField txtcodigo;
    @FXML
    private VBox rootTarjeta;
    @FXML
    private RadioButton rb1;
    @FXML
    private Label PagoTotal;
    @FXML
    private Label Codigo;
    @FXML
    private Label ResumenPedido;
    @FXML
    private RadioButton rb2;
    public static double subtotal1=ReservarVuelo2Controller.vueloseleccionado.getPrecio()+(ReservarVuelo2Controller.vueloseleccionado.getPrecio()*ReservarVuelo3Controller.TarifaViaje1.getPorcentaje())/100;
    public static double subtotal2=ReservarVuelo4Controller.vueloseleccionado2.getPrecio()+(ReservarVuelo4Controller.vueloseleccionado2.getPrecio()*ReservarVuelo5Controller.TarifaViaje2.getPorcentaje())/100;
    public  static double Total=subtotal1+subtotal2;
    ToggleGroup grupoOpciones = new ToggleGroup();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Codigo.setText("Codigo no valido");
        ResumenPedido.setText("Subtotal= "+String.valueOf(subtotal1+subtotal2));
        rb1.setToggleGroup(grupoOpciones);
        rb2.setToggleGroup(grupoOpciones);
         PagoTotal.setText(String.valueOf(Total)); 
         grupoOpciones.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
        public void changed(ObservableValue<? extends Toggle> ov,Toggle old_toggle,Toggle new_toggle){
            if(grupoOpciones.getSelectedToggle()==rb1){
                tipo='E';
                 rootTarjeta.getChildren().clear();
                Label mensaje=new Label("Estimado cliente , tiene 24 horas para acercarse a retirar su pedido");
                rootTarjeta.getChildren().add(mensaje);
                 PagoTotal.setText(String.valueOf(Total)); 
            }else{
                 if(grupoOpciones.getSelectedToggle()==rb2){
                      tipo='T';
                     rootTarjeta.getChildren().clear();
                     Label numero= new Label("Numero de tarjeta");
                     Label fechaExpiracion= new Label("Fecha de expiracion");
                     Label CVV= new Label("CVV");
                     HBox contenedornumero= new HBox();
                     HBox contenedorFecha= new HBox();
                     HBox contenedorCVV= new HBox();
                     contenedornumero.setAlignment(Pos.CENTER);
                     contenedorFecha.setAlignment(Pos.CENTER);
                     contenedorCVV.setAlignment(Pos.CENTER);
                     contenedornumero.getChildren().addAll(numero,txtnumero);
                     contenedorFecha.getChildren().addAll(fechaExpiracion,txtFechaExpiracion);
                     contenedorCVV.getChildren().addAll(CVV,txtCVV);
                     rootTarjeta.getChildren().addAll(contenedornumero,contenedorFecha,contenedorCVV);
                 }  
            }
        }
});
}
  @FXML
    void ComprobarCodigo(ActionEvent event) {
       
           for (Promocion p: BienvenidoController.promociones){
               
           if(txtcodigo.getText().equals(p.getCodigo())&&ReservarVueloController.LugarLlegada.equals(p.getPais())){
                System.out.println("entra 2");
           Codigo.setText("Descuento: "+String.valueOf(p.getDescuento())); 
           Total=Total-p.getDescuento();
           Descuento=p.getDescuento();
           PagoTotal.setText(String.valueOf(Total));
            
        }else{
              
           }
       
    
           
    }
        
    
       
          
               
           
        }
      @FXML
    void Pagar(ActionEvent event) throws IOException {
        if(rb2.isSelected()==true){
            if(txtnumero.getText()==""||txtCVV.getText()==""|| txtcodigo.getText()==""){
                try{
                    throw new  DatosIncompletosExcpetion("Completa los datos");
            }catch( DatosIncompletosExcpetion a){
                Alert alerta = new Alert(AlertType.INFORMATION);
                 alerta.setTitle("Información");
                 alerta.setHeaderText(null);
                 alerta.setContentText("Completa los datos");
                 alerta.showAndWait();
            }
                
                
            }else{
                 actual= (Stage) ResumenPedido.getScene().getWindow();
                Scene sc= new Scene(App.loadFXML("/Vistas/Finalizacion"));
                actual.setScene(sc);
                InicioSesionController.iniciarcerrar(FinalizacionController.labelCerrar, actual);
                
            }
        }else{
            if(rb1.isSelected()==true){
                Stage actual= (Stage) ResumenPedido.getScene().getWindow();
                Scene sc= new Scene(App.loadFXML("/Vistas/Finalizacion"));
                actual.setScene(sc);
                InicioSesionController.iniciarcerrar(FinalizacionController.labelCerrar, actual);
                
                
            }
            
        }
        

    }
      @FXML
    void Cancelar(ActionEvent event) {
        Stage actual= (Stage) ResumenPedido.getScene().getWindow();
        Stage cancelacion=new Stage();
        VBox root=new VBox();
        Button confirmar =new Button();
         Button cancelar =new Button();
        HBox botones=new HBox();
        Label label= new Label("Seguro quieres cancelar¿?");
        root.setAlignment(Pos.CENTER);
        botones.setAlignment(Pos.CENTER);
        confirmar.setOnAction(e->{
        cancelacion.close();
            actual.close();
        });
        cancelar.setOnAction(A->{
        cancelacion.close();});
        botones.getChildren().addAll(confirmar,cancelar);
        root.getChildren().addAll(label,botones);
        Scene sc=new Scene(root,400,560);
        cancelacion.setScene(sc);
        cancelacion.show();

    }
    
    
    
    
}
