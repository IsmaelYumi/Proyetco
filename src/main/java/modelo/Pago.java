/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yumi
 */
public class Pago {
    String idpago;
    String codigoReserva;
    double TotalRserva;
    int Descuento;
    char FormaPago;
    double Total;
    double TotalPagar;

    public Pago(String idpago, String codigoReserva,double TotalRserva, int Descuento, char FormaPago, double TotalPagar) {
        this.Total=TotalRserva;
        this.idpago = idpago;
        this.codigoReserva = codigoReserva;
        this.TotalRserva = TotalRserva;
        this.Descuento = Descuento;
        this.FormaPago = FormaPago;
        this.TotalPagar = TotalPagar;
    }

    public String getIdpago() {
        return idpago;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public double getTotalRserva() {
        return TotalRserva;
    }

    public int getDescuento() {
        return Descuento;
    }

    public char getFormaPago() {
        return FormaPago;
    }

    public double getTotal() {
        return Total;
    }

    public double getTotalPagar() {
        return TotalPagar;
    }
    
    
}
