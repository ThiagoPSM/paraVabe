package Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import ClaseLogicas.Persona;

/**
 *
 * @author Deian
 */
public class PersonaDatos {
    private ArrayList<Persona> lista = new ArrayList();
    private final String archivo = "personas.csv";
    private final String separador = ";";

    public PersonaDatos() throws IOException {
        leerArchivo();
    }
    
    public void agregarPersona(Persona p){
//        for (Persona pe: lista) {
//            System.out.println(pe.toString());
//        }
        lista.add(p);
//        System.out.println("agrager");
//        for (Persona pe: lista) {
//            System.out.println(pe.toString());
//        }
        escribirArchivo();
    }
    
    public Persona obtenerPersona(int id) throws IOException{
        Persona perso = null;
        for(Persona p: lista){
            if (p.getDni() == id){
                perso = p;
                break;//Corta el bucle cuando encuentra la persona
            }
        }
        if (perso != null)
            return perso;
        throw new IOException("La persona con dni = " + id + " no existe");

//        if(perso != null){
//            return perso;
//        }
//        try{
//            perso.getDni();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return perso;
    }
    
    public ArrayList<Persona> obtenerPersonas(){
        return lista;
    }
    
    public boolean eliminarPersona(int id){
        for(Persona p: lista){
            if (p.getDni() == id){
                lista.remove(p);
                return true;
            }
        }
        return false;
    }
    
    public void editarPersona(Persona persona) throws IOException{
        Persona p = obtenerPersona(persona.getDni());
        p.setNombre(persona.getNombre());
        p.setApellido(persona.getApellido());
        p.setDomicilio(persona.getDomicilio());
        p.setFechaNacimiento(persona.getFechaNacimiento());
        p.setDomicilio(persona.getDomicilio());
        p.setTelFijo(persona.getTelFijo());
        p.setTelCelular(persona.getTelCelular());
        p.setEstadoCivil(persona.getEstadoCivil());
        p.setCorreoElect(persona.getCorreoElect());
        
        escribirArchivo();
        System.out.println("editar");
    }
    
    private void escribirArchivo () {        
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try
        {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
                String linea;
            for(Persona p: lista){
                linea = p.getDni()+ separador;
                linea += p.getNombre() + separador;
                linea += p.getApellido() + separador;
                linea += p.getFechaNacimiento() + separador;
                linea += p.getDomicilio() + separador;
                linea += p.getTelFijo() + separador;
                linea += p.getTelCelular()+ separador;
                linea += p.getEstadoCivil() + separador;
                linea += p.getCorreoElect();

                pw.println(linea);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (nuevo != null)
              nuevo.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }   
    }
    private void leerArchivo () throws IOException {
        BufferedReader br = null;
        Persona perso; 
      
        try {         
            br = new BufferedReader(new FileReader(archivo));
            
            String linea = br.readLine();
            
            while (linea != null) {
                String [] campos = linea.split(separador);
                
                perso = new Persona(); //crea una persona por cada linea del .csv
                
                //Asigna cada valor de la linea a los atributos de la persona
                perso.setDni(Integer.parseInt(campos[0]));
                perso.setNombre(campos[1]);
                perso.setApellido(campos[2]);
//                perso.setFechaNacimiento(new Date(campos[3]));
                perso.setDomicilio(campos[4]);
                perso.setTelFijo(Integer.parseInt(campos[5]));
                perso.setTelCelular(campos[6]);
                perso.setEstadoCivil(campos[7]);
                perso.setCorreoElect(campos[8]);
                
                lista.add(perso); //Agrega la persona creada a la lista
                linea = br.readLine();
            }            
        } catch (Exception e) {
         
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
    
    public void imprimirArchivo(){//Imprime el contenido de la lista, se usa para testeo
    System.out.println("cant" + this.lista.size());
        for (Persona p: lista) {
            System.out.println(p.toString());
        }
    }
}
