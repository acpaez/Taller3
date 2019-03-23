/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author c-les
 */
public class PrincipalReportes {
    Scanner sc = new Scanner(System.in);
    Mapa mapa = new Mapa();
    public void menu(int documento){
        int opcion = 0;
        do {
            System.out.println("Editar Repostes UDEC");
            System.out.println("Que actividad desea realizar: ");
            System.out.println("1. agregar Reporte.");
            System.out.println("2. Eliminar Reporte.");
            System.out.println("3. Ver Reportes.");
            System.out.println("4. Terminar");
            System.out.println("Digite la opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregarReporte(documento);
                    break;
                case 2:
                    System.out.print("Ingrese codigo para eliminar: ");
                    eliminarReporte(documento, sc.nextInt());
                    break;
                case 3:
                    obtenerReportes(documento);
                    break;
                case 4:
                   
                    break;
            }
        } while (opcion != 4);
    }
    public void agregarReporte(int documento){
        Principal principal= new Principal();
        mapa = principal.leerArchivo();
        System.out.print("Ingrese el codigo: ");
        int cod = sc.nextInt();

        System.out.print("Ingrese el nombre: ");
        String nombre = sc.next();

        System.out.print("Ingrese el estado t/f: ");
        String estado = sc.next();
        boolean est=false;
        if(estado.equals("t")){
            est=true;
        }else{
            est=false;
        }

        System.out.print("Ingrese la descripcion: ");
        String descripcion = sc.next();

        System.out.print("Ingrese el valor: ");
        double valor = sc.nextDouble();        
        System.out.print("Introduzca la fecha del reporte con formato dd/mm/yyyy: ");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sc.next();
        String date = fecha;
        try {
            Date testDate = null;
            testDate = df.parse(date);
        } catch (Exception e) {
            System.out.println("formato invalido de fecha");
        }
        mapa.getDatosPersona().get(documento).getMapaReporte().put(cod, new Reporte(cod,nombre,est,descripcion,valor, fecha));    
        principal.crearArchivo(mapa);
    }
     public void eliminarReporte(int identificacion, int cod) {
        Principal principal= new Principal();
        mapa = principal.leerArchivo();
        if (mapa.getDatosPersona().get(identificacion).getMapaReporte().containsKey(cod)) {
            System.out.println("Record encontrado");
            mapa.getDatosPersona().get(identificacion).getMapaReporte().remove(cod);
            System.out.println("Record eliminado");
            principal.crearArchivo(mapa);
        } else {
            System.out.println("Record no encontrado");
        }

    }
     public void obtenerReportes(int identificacion) {
        Principal principal= new Principal();
        mapa = principal.leerArchivo();
        for (Integer iterador : mapa.getDatosPersona().get(identificacion).getMapaReporte().keySet()) {
            Reporte reporte = mapa.getDatosPersona().get(identificacion).getMapaReporte().get(iterador);
            if (reporte.getNombre().isEmpty() || reporte.getDescripcion().isEmpty()) {
                System.out.println("No hay record disponible");
            }else{
                System.out.println("Codigo: " + reporte.getCodigo());
                System.out.println("Nombre: " + reporte.getNombre());
                System.out.println("Estado: " + reporte.isEstado());
                System.out.println("Descripcion: " + reporte.getDescripcion());
                System.out.println("Valor: " + reporte.getValor());
                System.out.println("Fecha Reporte: " + reporte.getFecha());
            }
        }
    }
}
