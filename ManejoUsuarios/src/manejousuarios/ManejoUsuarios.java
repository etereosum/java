package manejousuarios;
import datos.Conexion;
import datos.UsuariosJDBC;
import java.util.List;
import domain.Usuario;

public class ManejoUsuarios {


    public static void main(String[] args) {
        UsuariosJDBC usuarioJDBC = new UsuariosJDBC(); 
        //usuarioJDBC.insert("Johnatan", "123");
        //usuarioJDBC.update(1, "Clinton", "secret");
        //usuarioJDBC.delete(2);
        List<Usuario> usuarios = usuarioJDBC.select();
        
        for(Usuario usuario: usuarios){
            System.out.print(usuario);
            System.out.println("");
        }
        
    }
    
}
