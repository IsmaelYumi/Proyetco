/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Yumi
 */
public class reserva implements Pagable, Serializable {
    private String CodigoReserva;
    private String CedulaCliente;
    private String CiudadOrigen;
    private String CiudadDestino;
    private String FechaSalida;
    private String FechaRegreso;
    private int NumeroPasajeros;
    private String numeroVuelo;
    private String numeroVueloRegreso;
    private char TipoTarifaIda;
    private char TipoTarifaRegreso;

    public reserva(String CodigoReserva, String CedulaCliente, String CiudadOrigen, String CiudadDestino, String FechaSalida, String FechaRegreso, int NumeroPasajeros, String numeroVuelo, String numeroVueloRegreso, char TipoTarifaIda, char TipoTarifaRegreso) {
        this.CodigoReserva = CodigoReserva;
        this.CedulaCliente = CedulaCliente;
        this.CiudadOrigen = CiudadOrigen;
        this.CiudadDestino = CiudadDestino;
        this.FechaSalida = FechaSalida;
        this.FechaRegreso = FechaRegreso;
        this.NumeroPasajeros = NumeroPasajeros;
        this.numeroVuelo = numeroVuelo;
        this.numeroVueloRegreso = numeroVueloRegreso;
        this.TipoTarifaIda = TipoTarifaIda;
        this.TipoTarifaRegreso = TipoTarifaRegreso;
    }

    public String getCodigoReserva() {
        return CodigoReserva;
    }

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public String getCiudadOrigen() {
        return CiudadOrigen;
    }

    public String getCiudadDestino() {
        return CiudadDestino;
    }

    public String getFechaSalida() {
        return FechaSalida;
    }

    public String getFechaRegreso() {
        return FechaRegreso;
    }

    public int getNumeroPasajeros() {
        return NumeroPasajeros;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getNumeroVueloRegreso() {
        return numeroVueloRegreso;
    }

    public char getTipoTarifaIda() {
        return TipoTarifaIda;
    }

    public char getTipoTarifaRegreso() {
        return TipoTarifaRegreso;
    }

    public void setCodigoReserva(String CodigoReserva) {
        this.CodigoReserva = CodigoReserva;
    }

    public void setCedulaCliente(String CedulaCliente) {
        this.CedulaCliente = CedulaCliente;
    }

    public void setCiudadOrigen(String CiudadOrigen) {
        this.CiudadOrigen = CiudadOrigen;
    }

    public void setCiudadDestino(String CiudadDestino) {
        this.CiudadDestino = CiudadDestino;
    }

    public void setFechaSalida(String FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public void setFechaRegreso(String FechaRegreso) {
        this.FechaRegreso = FechaRegreso;
    }

    public void setNumeroPasajeros(int NumeroPasajeros) {
        this.NumeroPasajeros = NumeroPasajeros;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public void setNumeroVueloRegreso(String  numeroVueloRegreso) {
        this.numeroVueloRegreso = numeroVueloRegreso;
    }

    public void setTipoTarifaIda(char TipoTarifaIda) {
        this.TipoTarifaIda = TipoTarifaIda;
    }

    public void setTipoTarifaRegreso(char TipoTarifaRegreso) {
        this.TipoTarifaRegreso = TipoTarifaRegreso;
    }

    @Override
    public Pago GenerarTransaccion(String Idpago, String codigoR, double Total, int Descuento, char FormaPago, double totalPagar) {
      Pago pg = new Pago(Idpago,codigoR,Total,Descuento,FormaPago,totalPagar);
      return pg;
    }
   
    
    
    

    
}
