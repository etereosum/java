
package domain;

public class Usuario {
    public int id_usuario;
    public String usuario;
    public String password;
    
    public int getId_usuario(){
        return this.id_usuario;
    }
    
    public void setId_usuario(int id_usuario){
        this.id_usuario = id_usuario;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        return "Usuario(" + "id_usuario="+ id_usuario + ", usuario = " + usuario + 
                ", password=" +password +")";
    }
}
