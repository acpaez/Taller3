/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author c-les
 */
public class Mapa implements Serializable{
     private HashMap<Integer, Persona> datosPersona = new HashMap<>();

    public HashMap<Integer, Persona> getDatosPersona() {
        return datosPersona;
    }

    public void setDatosPersona(HashMap<Integer, Persona> datosPersona) {
        this.datosPersona = datosPersona;
    }

}
