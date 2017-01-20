package ejemplo15.cajaherramientas;

import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.Statement;

public class GestionBaseDeDatos 
{ 
       // Permite cerrar un resultset 
       public static void closeResulset(ResultSet resultado) 
       { 
              if(resultado!=null) 
              { 
                     try 
                     { 
                            resultado.close(); 
                     }

                     catch(Exception e) 
                     { 
                            System.out.println("Error en el cierre de la conexión de un resultset"); 
                     } 
              } 
       }

       // Cierre de una consulta 
       public static void closeRequest(Statement consulta) 
       { 
              if(consulta!=null) 
              { 
                      try 
                      { 
                            consulta.close(); 
                      } 
                      catch(Exception e) 
                      { 
                            System.out.println("Error en el cierre de una consulta"); 
                      } 
               } 
       }

       // Cierre de una conexión 
       public static void closeConnection(Connection connection) 
       { 
               if(connection!=null) 
               { 
                      try 
                      { 
                             connection.close(); 
                      }

                     catch(Exception e) 
                     { 
                             System.out.println("Error en el cierre de una conexión"); 
                      } 
                } 
        } 
}