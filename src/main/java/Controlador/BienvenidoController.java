/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import static Controlador.InicioSesionController.iniciarcerrar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelo.App;
import modelo.Promocion;

/**
 * FXML Controller class
 *
 * @author Yumi
 */
public class BienvenidoController implements Initializable {
    public static ArrayList<Promocion> promociones=new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        VentanaPedidos();
        CargarLista();
       
        
      
    } 
    @FXML
    void ReservarVuelo(ActionEvent e){
        try{
        Stage st= new Stage();
       
        Scene sc= new Scene(App.loadFXML("/Vistas/ReservarVuelo"));
        st.setScene(sc);
        st.show();
        }catch(Exception a){
            a.printStackTrace();
    }
    }
    @FXML
     void encontrar(ActionEvent e) throws FileNotFoundException{
      Stage stage = new Stage();
       ArrayList<Promocion> locales = new ArrayList<>();
      AnchorPane contenedor = new AnchorPane();
       contenedor.setMaxSize(700, 700);
       contenedor.setMinSize(700, 700);
       
       InputStream inputStreams = new FileInputStream("src/main/resources/imagen/mapa.PNG");
       Image mapa = new Image(inputStreams);
       ImageView imgv = new ImageView(mapa);
       imgv.setFitHeight(450);
       imgv.setFitWidth(600);
       contenedor.setMaxSize(450, 650);
       contenedor.getChildren().addAll(imgv);
       imgv.setLayoutX(15);
       imgv.setLayoutY(15);
       try(BufferedReader bfr = new BufferedReader(new FileReader(new File("src/main/resources/Textos/promociones.txt")))){
           String linea = bfr.readLine();
           while(linea != null){
               String[] lineas = linea.split(",");
               double coordenadax = Double.parseDouble(lineas[0]);
               double coordenaday = Double.parseDouble(lineas[1]);
               Promocion local = new Promocion(coordenadax,coordenaday,lineas[2],lineas[3],Integer.parseInt(lineas[4]));
               locales.add(local);
               promociones.add(local);
               linea = bfr.readLine();
           }
       }catch(FileNotFoundException ex){
           System.out.println("Archivo no encontrado");
       }catch(IOException ex){
           System.out.println("Error al leer el archivo");
       }
       Scene scene = new Scene(contenedor,610,465);
       stage.setScene(scene);
       stage.setTitle("Ubicaciones");
       stage.show();
       iniciarImagenes(locales,contenedor);
   }
      public static void mostrarImagenes(ArrayList<Promocion> locales, AnchorPane contenedor) throws FileNotFoundException{
       for(Promocion local:locales){
           InputStream inputStream = new FileInputStream("src/main/resources/imagen/icono.png");
           Image ubicacion = new Image(inputStream);
           ImageView imgv = new ImageView(ubicacion);
        
           imgv.setOnMouseClicked(event ->{
               Stage informacion = new Stage();
               VBox cinfo = new VBox();
               cinfo.setMaxSize(300,250);
               cinfo.setMinSize(300,250);
               cinfo.setStyle("-fx-background-color:#eeb4ed;");
               HBox cheladeria = new HBox();
               Label Descuentos = new Label("\n\nDescuentos\n");
               Descuentos.setStyle("-fx-font-family:'Arial Black';");
               cheladeria.getChildren().addAll(Descuentos);
               HBox cdatos = new HBox();
               Label datos = new Label("\n"+local.getPais()+"\n\n"+"Descuento: "+local.getDescuento()+"\n\n\n\n\n\n");
               cdatos.getChildren().addAll(datos);
               HBox ctiempo = new HBox();
               Label tiempo = new Label();
               tiempo.setText("Cerrando en 5 segundos..                                ");
               Button cerrar = new Button("Cerrar");
               cerrar.setOnAction(event2 ->{
                   informacion.close();
               });
               ctiempo.getChildren().addAll(tiempo,cerrar);
               cinfo.getChildren().addAll(cheladeria,cdatos,ctiempo);
               Scene escena = new Scene(cinfo);
               informacion.setScene(escena);
               informacion.setTitle("Detalle Ubicacion");
               informacion.show();
               iniciarcerrar(tiempo,informacion);  
           });
           Random rd= new Random();
           int numero = rd.nextInt(10)+1;
           try {
               Thread.sleep(numero*1000);
           } catch (InterruptedException ex) {
               ex.printStackTrace();
           }
           Platform.runLater(new Runnable(){
            public void run(){
              
                contenedor.getChildren().add(imgv);
              
                imgv.setLayoutX(local.getCoordenadaX());
                imgv.setLayoutY(local.getCoordenadaY()*-1);
                System.out.println("ya");
                imgv.setFitHeight(60);
                imgv.setFitWidth(60);
                System.out.println("con exito");
                
            }
            });
   
       }
   }
      public static void iniciarImagenes(ArrayList<Promocion> locales, AnchorPane contenedor){
       Thread dormir = new Thread(new Runnable(){
           public void run(){
               try {
                   mostrarImagenes(locales,contenedor);
               } catch (FileNotFoundException ex) {
                   ex.printStackTrace();
               }
           }
       });
       dormir.start();
   }
      private void VentanaPedidos(){
        Stage st =new Stage();
        VBox rootpedido=new VBox();
        String info = null;
        st.setTitle("Pedidos generados");
        ListView<String> lv= new ListView<>();
        ObservableList<String> listaElementos= FXCollections.observableArrayList();
        try{
            File file= new File("src/main/resources/Textos/Pagos.txt");
            FileReader fw= new FileReader(file);
            BufferedReader br = new BufferedReader(fw);
            while((info=br.readLine())!=null){
                listaElementos.add(info);
            }
            lv.setItems(listaElementos);
            rootpedido.getChildren().add(lv);
         }catch(Exception  I){
             I.printStackTrace();
         }
           Scene sc= new Scene(rootpedido,300,300);
           st.setScene(sc);
           st.show();
           actualizar(listaElementos,lv);
            
    } public static void actualizar(ObservableList<String> listaElementos,ListView<String> lv){
       Thread dormir2 = new Thread(new Runnable(){
           public void run(){
               int a = 1;
               while(a!=0){
               for(int i =5;i!=0;i--){
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException ex) {
                       ex.printStackTrace();
                    }
                    Platform.runLater(new Runnable(){
                        public void run(){  
                        listaElementos.clear();
                        try{
                            String info = null;
                            File file= new File("src/main/resources/Textos/Pagos.txt");
                            FileReader fw= new FileReader(file);
                            BufferedReader br = new BufferedReader(fw);
                            while((info=br.readLine())!=null){
                                listaElementos.add(info);
                            }
                            lv.setItems(listaElementos);
                        }catch(Exception  I){
                            I.printStackTrace();
                        }
                    }
                    }); 
                  }
           }}
       });
       dormir2.start();
   }
    void CargarLista(){
        try(BufferedReader bfr = new BufferedReader(new FileReader(new File("src/main/resources/Textos/promociones.txt")))){
           String linea = bfr.readLine();
           while(linea != null){
               String[] lineas = linea.split(",");
               double coordenadax = Double.parseDouble(lineas[0]);
               double coordenaday = Double.parseDouble(lineas[1]);
               Promocion local = new Promocion(coordenadax,coordenaday,lineas[2],lineas[3],Integer.parseInt(lineas[4]));
               promociones.add(local);
               linea = bfr.readLine();
           }
       }catch(FileNotFoundException ex){
           System.out.println("Archivo no encontrado");
       }catch(IOException ex){
           System.out.println("Error al leer el archivo");
       }
        
    }
      
     
        
        
    }
   



