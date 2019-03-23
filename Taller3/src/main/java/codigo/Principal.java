package codigo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
/**
 *
 * @author c-les
 */
public class Principal {
    Mapa mapa=new Mapa();
    Scanner sc = new Scanner(System.in);
    private static final String ruta = "documento.txt";
    public void menu (){
        int opcion = 0;
        do {
            System.out.println("Reporte UDEC");
            System.out.println("Que actividad desea realizar: ");
            System.out.println("1. Agregar persona.");
            System.out.println("2. Editar reportes persona.");
            System.out.println("3. Ver personas registradas.");
            System.out.println("4. Terminar");
            System.out.println("Digite la opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    crearPersona();
                    break;
                case 2:
                    System.out.print("Ingrese el documento : ");
                    elegirPersona(sc.nextInt());
                    break;
                case 3:
                    obtenerDatos();
                    break;
                case 4:
                   
                    break;
            }
        } while (opcion != 4);
    }
    public void crearArchivo(Mapa listaDatos){  
       try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
            oos.writeObject(listaDatos);
            oos.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        } 
    }
    public Mapa leerArchivo() {
        Mapa mapaPersonas= new Mapa();
        try{
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(ruta));
            mapaPersonas = (Mapa) ois.readObject();
        }catch(Exception ex){
             System.out.println(ex);
            ex.printStackTrace();
        }
        
        return mapaPersonas;
    }
    public void elegirPersona(int documento){
        mapa = leerArchivo();
        if(mapa.getDatosPersona().containsKey(documento)){
            PrincipalReportes reportes=new PrincipalReportes();
            reportes.menu(documento);
        }
    }
    public void crearPersona(){
        System.out.print("Digite la identificacion : ");
        Integer documento = sc.nextInt();
        System.out.print("Digite el nombre : ");
        String nombre = sc.next();
        System.out.print("Digite la apellido : ");
        String apellido = sc.next();
        mapa = leerArchivo();
        mapa.getDatosPersona().put(documento, new Persona(documento,nombre,apellido));
        crearArchivo(mapa);
    }
  
    public void obtenerDatos(){
        mapa = leerArchivo();
        for (Integer iterador : mapa.getDatosPersona().keySet()) {
            System.out.println("Nombre :" + mapa.getDatosPersona().get(iterador).getNombre()+" "+ mapa.getDatosPersona().get(iterador).getApellido());
            System.out.println("Numero de Identificacion :" + mapa.getDatosPersona().get(iterador).getDocumento());
        }
    }
}
