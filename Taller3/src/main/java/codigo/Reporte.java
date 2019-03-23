package codigo;


import java.io.Serializable;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c-les
 */
public class Reporte implements Serializable{
    private int codigo;
    private String nombre;
    private boolean estado;
    private String descripcion;
    private double valor;
    private String fecha;

    public Reporte(int codigo, String nombre, boolean estado, String descripcion, double valor, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}
