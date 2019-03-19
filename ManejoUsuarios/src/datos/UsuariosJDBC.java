package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;


public class UsuariosJDBC {
    private final String SQL_INSERT  = "INSERT INTO usuario(usuario, password) value(?, ?)";
    private final String SQL_UPDATE  = "UPDATE usuario SET usuario=?, password=? where id_usuario=?";
    private final String SQL_DELETE  = "DELETE FROM usuario WHERE id_usuario=?";
    private final String SQL_SELECT  = "SELECT id_usuario, usuario, password FROM usuario ORDER BY usuario";
    
    public int insert(String usuario, String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, usuario);
            stmt.setString(index++, password);
            System.out.println("Ejecutando query: "+SQL_INSERT);
            rows = stmt.executeUpdate();
            
        } catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int update(int id_usuario,String usuario, String password){
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

            
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            System.out.println("Ejecutando Query: "+SQL_UPDATE);
            stmt.setString(index++, usuario);
            stmt.setString(index++, password);
            stmt.setInt(index, id_usuario);
                
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados : "+ rows);
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        } finally{
            Conexion.close(conn);
            Conexion.close(stmt);  
        }
        return rows;
    }
    
    public int delete(int id_usuario){
        Connection conn = null;
        PreparedStatement stmt= null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query : " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_usuario);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
            
        } catch(SQLException sqle){
            sqle.printStackTrace();
        } finally{
            Conexion.close(conn);
            Conexion.close(stmt);  
        }
        return rows;
        
    }
    
    public List<Usuario> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int id_usuario = rs.getInt(1);
                String user = rs.getString(2);
                String password = rs.getString(3);
                
                usuario = new Usuario();
                usuario.setId_usuario(id_usuario);
                usuario.setUsuario(user);
                usuario.setPassword(password);
                
                usuarios.add(usuario);
                
            }
            
            
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        
        return usuarios;
    }
}
