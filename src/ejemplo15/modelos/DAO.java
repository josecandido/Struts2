package ejemplo15.modelos;

import java.sql.Connection;

public interface DAO {

       // Definici�n del m�todo a declarar en las clases de los usuarios 
       public Connection getConnection(); 
}