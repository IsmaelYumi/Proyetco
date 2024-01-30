/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yumi
 */
public class Vuelo implements Comparable<Vuelo>{
   private String codigoVuelo;
   private String origen;
   private String destino;
   private  int  duracion;
   private String Hsalida;
   private String HLlegada;
   private String CodigoAvion;
   private double precio;

    public Vuelo(String codigoVuelo, String origen, String destino, int duracion, String Hsalida, String HLlegada, String CodigoAvion, double precio) {
        this.codigoVuelo = codigoVuelo;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.Hsalida = Hsalida;
        this.HLlegada = HLlegada;
        this.CodigoAvion = CodigoAvion;
        this.precio = precio;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getHsalida() {
        return Hsalida;
    }

    public String getHLlegada() {
        return HLlegada;
    }

    public String getCodigoAvion() {
        return CodigoAvion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setHsalida(String Hsalida) {
        this.Hsalida = Hsalida;
    }

    public void setHLlegada(String HLlegada) {
        this.HLlegada = HLlegada;
    }

    public void setCodigoAvion(String CodigoAvion) {
        this.CodigoAvion = CodigoAvion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(Vuelo o) {
       return this.getDuracion()-o.getDuracion();
    }
   
   
   
    
}
