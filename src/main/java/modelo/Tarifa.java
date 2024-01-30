    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yumi
 */
public class Tarifa {
    private String nombre;
    private char tipo;
    private String ListaC;
    private double porcentaje;

    public Tarifa(String nombre, char tipo, String ListaC, double porcentaje) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ListaC = ListaC;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public char getTipo() {
        return tipo;
    }

    public String getListaC() {
        return ListaC;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setListaC(String ListaC) {
        this.ListaC = ListaC;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
