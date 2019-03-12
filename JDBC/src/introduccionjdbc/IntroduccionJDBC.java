
package introduccionjdbc;
import java.sql.DriverManager;
import java.sql.*;

public class IntroduccionJDBC {


    public static void main(String[] args) {
        //Cadena de conexión de mysql, el parametro use SSL es opcional
        String url = "jdbc:mysql://localhost:3306/sgp?useSSL=false";
          
        try{
            //Cargar el driver de mysql
            Class.forName("com.mysql.jdbc.Driver");
            
            //Creamos el objeto de conexion
            Connection conexion = (Connection) DriverManager.getConnection(url,"root", "root");
            
            //Creamos un objeto de tipo Statement (sentencias)
            Statement instruccion = conexion.createStatement();
            
            //Creamos el query
            String sql = "select id_persona, nombre, apellido from persona";
           
            ResultSet result = instruccion.executeQuery(sql);
            
            while(result.next()) {
                System.out.print("Id: "+result.getInt(1));
                System.out.print(" Nombre: "+result.getString(2));
                System.out.println(" Apellido: "+result.getString(3));
            }
            //Cerrar cada uno de los objetos utilizados
            result.close();
            instruccion.close();
            conexion.close();
            
        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
}
