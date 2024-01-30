/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yumi
 */
public class Promocion {
    double CoordenadaX;
    double CoordenadaY;
    String pais;
    String codigo;
    int descuento;

    public Promocion(double CoordenadaX, double CoordenadaY, String codigo, String pais, int descuento) {
        this.CoordenadaX = CoordenadaX;
        this.CoordenadaY = CoordenadaY;
        this.pais = pais;
        this.codigo = codigo;
        this.descuento = descuento;
    }

    public double getCoordenadaX() {
        return CoordenadaX;
    }

    public double getCoordenadaY() {
        return CoordenadaY;
    }

    public String getPais() {
        return pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setCoordenadaX(double CoordenadaX) {
        this.CoordenadaX = CoordenadaX;
    }

    public void setCoordenadaY(double CoordenadaY) {
        this.CoordenadaY = CoordenadaY;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    
    
    
}
