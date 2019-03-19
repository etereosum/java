
package datos;
import java.sql.*;

public class Conexion {
    //valores de conexion a mysql
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //ruta del servidor mysql
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/sgp?useSSL=false";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASS = "root";
    public static Driver driver = null;
    
    //Para que no haya problemas al obtener la conexion de
    //manera concurrente, se usa la palabra synchronized
    
    public static synchronized Connection getConnection()
            throws SQLException {
        if (driver == null) {
            
            try {
                //Se registra el driver
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);

                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception e) {
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
        public static void close(ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        } catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement stmt){
        try{
            if(stmt != null ){
                stmt.close();
            }
        } catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
    //cierre de la conexion
    public static void close(Connection conn){
        try{
            if(conn != null ){
                conn.close();
            }
        } catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }  
    
}
