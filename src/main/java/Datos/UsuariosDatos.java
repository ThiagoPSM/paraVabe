/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import ClaseLogicas.Usuario;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Thiago
 */
public class UsuariosDatos {
    
    public boolean Registrar(JTextField u, JPasswordField c, JPasswordField cr )
    {
        String contra = String.valueOf(c.getPassword());
        String repContra = String.valueOf(cr.getPassword());
        boolean bandera = false;
        
        if(controlarExistenciaRegistro(u))
        {
           if(contra.equals(repContra))
           {
            File f = new File("./Usuarios.csv");
            Usuario user= new Usuario(u.getText(), contra , "");
            bandera=true;
            try(FileWriter fw = new FileWriter(f,true))
            {
               fw.write(user.toCSV());
               JOptionPane.showMessageDialog(null, "se ah registrado con exito");
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
           }else
         {
            JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
         }    
        }
        return bandera;
    }
    
    
    public boolean controlarExistenciaRegistro(JTextField user)
    {
        boolean bandera= true;
        Usuario usuario;
        String[] datos;
        try(Scanner sc = new Scanner(new File("./Usuarios.csv")))
        {
            while(sc.hasNextLine())
            {
                datos=sc.nextLine().split(",");
                usuario = new Usuario(datos[0],datos[1], "");
                if(user.getText().equals(usuario.getNombreUusuario()))
                {
                    JOptionPane.showMessageDialog(null, "el usuario ingreado ya existe");
                    bandera=false;
                    break;
                }
            }
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bandera;
    }
    
    public boolean controlInicioSesion(JTextField u, JPasswordField c)
    {
        Usuario user;
        String[] datos;
        boolean bandera = false;
        try(Scanner sc = new Scanner(new File("./Usuarios.csv")))
        {
            String contra = String.valueOf(c.getPassword());
           while(sc.hasNextLine())
           {
               datos = sc.nextLine().split(",");
               user = new Usuario(datos[0],datos[1],"");
               if(user.getNombreUusuario().equals(u.getText()) && user.getContraseñaUsuario().equals(contra) )
               {
                   JOptionPane.showMessageDialog(null, "Se ah encontrado el usuario");
                   bandera = true;
                   break;
               }
           }   
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        if(bandera==false)
        {
            JOptionPane.showMessageDialog(null, "usuario o contraseña incorrectas");
        }
           return bandera;    
    }
    
    
    
    
}
