/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Promocion;

/**
 *
 * @author Yumi
 */
public class PromocionesController {
    public static ArrayList<Promocion> promociones=new ArrayList<>();
    
    
    public static void  CargarPromociones(){
        try(BufferedReader bfr = new BufferedReader(new FileReader(new File("src/main/resources/Textos/promociones.txt")))){
           String linea = bfr.readLine();
           while(linea != null){
               String[] lineas = linea.split(",");
               double coordenadax = Double.parseDouble(lineas[0]);
               double coordenaday = Double.parseDouble(lineas[1]);
               Promocion local = new Promocion(coordenadax,coordenaday,lineas[2],lineas[3],Integer.parseInt(lineas[4]));
               promociones.add(local);
        
    }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
}
}

