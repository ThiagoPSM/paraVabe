package ClaseLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nombreUusuario;
    private String contraseñaUsuario;
    private String rol;
    
    public String toCSV(){
        return this.nombreUusuario+","+this.contraseñaUsuario+","+this.rol+"\n";              
    }
}
