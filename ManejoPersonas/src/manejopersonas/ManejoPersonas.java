package manejopersonas;

import datos.PersonasJDBC;
import domain.Persona;
import java.util.List;


public class ManejoPersonas {


    public static void main(String[] args) {
        PersonasJDBC personasJDBC = new PersonasJDBC();
        //prueba del metodo insert
        //personasJDBC.insert("Martha", "Salazar");
        
        //personasJDBC.update(1,"Cesar","Gonzalez");
        
        //personasJDBC.delete(2);
        
        List<Persona> personas = personasJDBC.select();
        
        for(Persona persona: personas){
            System.out.print(persona);
            System.out.println();
        }
            
    }
    
}
