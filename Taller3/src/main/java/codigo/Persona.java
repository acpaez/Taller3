package codigo;


import java.io.Serializable;
import java.util.HashMap;
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
public class Persona implements Serializable{
    private int documento;
    private String nombre, apellido;
    private HashMap<Integer, Reporte> mapaReporte;

    public Persona(int documento, String nombre, String apellido) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        mapaReporte = new HashMap<>();
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public HashMap<Integer, Reporte> getMapaReporte() {
        return mapaReporte;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMapaReporte(HashMap<Integer, Reporte> mapaReporte) {
        this.mapaReporte = mapaReporte;
    }
   
           
}
