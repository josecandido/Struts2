package ejemplo15.modelos;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List; 
import ejemplo15.cajaherramientas.GestionBaseDeDatos; 
import ejemplo15.javabeans.Producto;

public class ModeloProductoDAO extends ModeloDAO{

       // Variables 
       Connection conexion=null; 
       ResultSet resultado=null; 
       private static List<Producto> listaProductos;

       // devolver la lista de clientes 
       public List<Producto> getListaProductos() 
       { 
              // Variables 
              PreparedStatement consulta=null; 
              Producto producto=null; 
              String consultaString=null; 
              listaProductos=new ArrayList<Producto>();

              try 
              { 
                     // Apertura de una conexión 
                     conexion=super.getConnection();

                     // consulta de lista de clientes 
                     consultaString="SELECT * FROM blackfriday WHERE 1 ORDER BY id";
                     
       consulta=conexion.prepareStatement(consultaString);

                     // Ejecución de la consulta 
                     resultado=consulta.executeQuery();

                     // Se almacena el resultado en una lista 
                     if(resultado!=null) 
                     { 
                            while(resultado.next()) 
                            { 
                                   // Se efectúa el mapping de los atributos con los campos de la tabla SQL 
                                   producto=mapperProducto(resultado);

                                   // Se añade el objeto a la lista de clientes

       listaProductos.add((Producto)producto); 
                            } 
                     } 
              } 
              catch(Exception e) 
              { 
                     System.out.println("Error en la consulta de la clase ModeloProductoDAO función getListaProductos"); 
              } 
              finally 
              { 
                     try 
                     { 
                            // Cierre de la conexión 
                            if(resultado!=null) 
                            {

       GestionBaseDeDatos.closeResulset(resultado); 
                            } 
                            if(consulta!=null) 
                            {

       GestionBaseDeDatos.closeRequest(consulta); 
                            } 
                            if(conexion!=null) 
                            {

       GestionBaseDeDatos.closeConnection(conexion); 
                            } 
                     } 
                     catch(Exception ex) 
                     { 
                            System.out.println("Error en el cierre de la conexion con la base de datos en la clase ModeloProductoDAO función getListaProductos"); 
                     } 
              }

              // Devolver la lista de clientes 
              return listaProductos; 
       }

       // buscar un cliente en la base 
       public Producto getProducto(int idproducto) 
       { 
              // Variables 
              PreparedStatement consulta=null; 
              Producto producto=null; 
              String consultaString=null;

              try 
              { 
                     // Apertura de una conexión 
                     conexion=super.getConnection();

                     // Creación de la consulta 
                     consultaString = "SELECT * FROM blackfriday WHERE id=?";

                     // Se prepara la consulta

       consulta=conexion.prepareStatement(consultaString); 
                     consulta.setInt(1,idproducto);

                     // Ejecución de la consulta 
                     resultado=consulta.executeQuery();

                     // Se almacena el resultado en el objeto cliente 
                     if(resultado!=null) 
                     { 
                            if(resultado.next()) 
                            { 
                                   // Se realiza el mapping de los atributos con los campos de la tabla SQL 
                                   producto=mapperProducto(resultado); 
                            } 
                     } 
              } 
              catch(Exception e) 
              { 
                     producto=null; 
                     System.out.println("Error en la consulta en la clase ModeloProductoDAO función getProducto"); 
              } 
              finally 
              { 
                     try 
                     { 
                            // Cierre de la conexión 
                            if(resultado!=null) 
                            {

       GestionBaseDeDatos.closeResulset(resultado); 
                            } 
                            if(consulta!=null) 
                            {

       GestionBaseDeDatos.closeRequest(consulta); 
                            } 
                            if(conexion!=null) 
                            {

       GestionBaseDeDatos.closeConnection(conexion); 
                            } 
                     } 
                     catch(Exception ex) 
                     { 
                            System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloProductoDAO función getProducto"); 
                     } 
              }

              // Devolver objeto cliente 
              return producto; 
       }

       // agregar un cliente a la base 
       public int agregarProducto(Producto producto) 
       { 
              // Variables 
              PreparedStatement consulta=null; 
              String consultaString=null; 
              int codigoError=0;

              try 
              { 
                     // Apertura de una conexión 
                     conexion=super.getConnection();

                     // Creación de la consulta 
                     consultaString="INSERT INTO blackfriday (nombre,unidades,precio,fecha) VALUES(?,?,?,?)";

                     // Preparación de la consulta

       consulta=conexion.prepareStatement(consultaString); 
                     consulta.setString(1,producto.getNombre());
                     consulta.setInt(2, producto.getUnidades());
                     consulta.setFloat(3, producto.getPrecio());
                     consulta.setDate(4, producto.getFecha());

                     // Se vacía el cliente por seguridad 
                     producto=null;

                     // Ejecución de la consulta 
                     codigoError=consulta.executeUpdate(); 
              } 
              catch(Exception e) 
              { 
                     codigoError=0; 
                     System.out.println("Error en la consulta de la clase ModeloProductoDAO función agregarProducto"); 
              } 
              finally 
              { 
                     try 
                     { 
                            // Cierre de la conexión 
                            if(resultado!=null) 
                            {

       GestionBaseDeDatos.closeResulset(resultado); 
                            } 
                            if(consulta!=null) 
                            {

       GestionBaseDeDatos.closeRequest(consulta); 
                            } 
                            if(conexion!=null) 
                            {

       GestionBaseDeDatos.closeConnection(conexion); 
                            } 
                     } 
                     catch(Exception ex) 
                     { 
                            System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloProductoDAO función agregarProducto"); 
                     } 
              }

              // Devolver el código de error 
              return codigoError; 
    }


       // eliminar un cliente en la base 
       public int eliminarProducto(int idProducto) 
       { 
              // Variables 
              PreparedStatement consulta=null; 
              String consultaString=null; 
              int codigoError=0;

              try 
              { 
                     // Apertura de una conexión 
                     conexion=super.getConnection();

                     // Eliminar el cliente 
                     consultaString="DELETE FROM blackfriday WHERE id=?";

       consulta=conexion.prepareStatement(consultaString); 
                     consulta.setInt(1,idProducto);

                     // Ejecución de la consulta 
                     codigoError=consulta.executeUpdate(); 
              } 
              catch(Exception e) 
              { 
                     codigoError=0; 
                     System.out.println("Error en la consulta de la clase ModeloProductoDAO función eliminarProducto"); 
              } 
              finally 
              { 
                     try 
                     { 
                            // Cierre de la conexión 
                            if(resultado!=null) 
                            {

       GestionBaseDeDatos.closeResulset(resultado); 
                            } 
                            if(consulta!=null) 
                            {

       GestionBaseDeDatos.closeRequest(consulta); 
                            } 
                            if(conexion!=null) 
                            {

       GestionBaseDeDatos.closeConnection(conexion); 
                            } 
                     } 
                     catch(Exception ex) 
                     { 
                            System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloProductoDAO función eliminarProducto"); 
                      } 
              }

              // Devolver el código de error 
              return codigoError; 
       }


       // modificar un cliente en la base 
       public int modificarProducto(Producto producto) 
       { 
    	   
              // Variables 
              PreparedStatement consulta=null; 
              String consultaString=null; 
              int codigoError=0;

              try 
              { 
                     // Apertura de una conexión 
                     conexion=super.getConnection();

                     // Creación de la consulta 
                     consultaString="UPDATE blackfriday set nombre=?,unidades=?,precio=?,fecha=? WHERE id=?";

       consulta=conexion.prepareStatement(consultaString); 
                     consulta.setString(1,producto.getNombre()); 
                     consulta.setInt(2, producto.getUnidades()); 
                     consulta.setFloat(3, producto.getPrecio()); 
                     consulta.setDate(4, producto.getFecha());
                     consulta.setInt(5, producto.getId());

                     // Se vacía el cliente por seguridad 
                     producto=null;

                     // Ejecución de la consulta 
                     codigoError=consulta.executeUpdate(); 
              } 
              catch(Exception e) 
              { 
                     System.out.println("Error en la consulta de la clase ModeloProductoDAO función modificarProducto"); 
              } 
              finally 
              { 
                     try 
                     { 
                            // Cierre de la conexión 
                            if(resultado!=null) 
                            {

       GestionBaseDeDatos.closeResulset(resultado); 
                            } 
                            if(consulta!=null) 
                            {

       GestionBaseDeDatos.closeRequest(consulta); 
                            } 
                            if(conexion!=null) 
                            {

       GestionBaseDeDatos.closeConnection(conexion); 
                            } 
                     } 
                     catch(Exception ex) 
                     { 
                            System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloProductoDAO función modificarProducto"); 
                      } 
              }

              // Devolver el código de error   
              return 0; 
            
       }


    // Realizar el mapping relacional hacia objeto 
    public Producto mapperProducto(ResultSet resultado) 
    { 
       // Variables 
       Producto producto=new Producto();

       try 
       { 
              if (resultado.getString("id")==null) 
              { 
                     producto.setId(0); 
              } 
              else 
              {

       producto.setId(resultado.getInt("id")); }

              if (resultado.getString("nombre")==null) 
              { 
                    producto.setNombre(""); 
              } 
              else 
              {

      producto.setNombre(resultado.getString("nombre")); 
              }

              if (resultado.getInt("unidades")==0) 
              { 
                     producto.setUnidades(0); 
              } 
              else 
              {

       producto.setUnidades(resultado.getInt("unidades")); 
              } 
              if (resultado.getString("precio")==null) 
              { 
                     producto.setPrecio(0); 
              } 
              else 
              {

       producto.setPrecio(resultado.getFloat("precio")); 
              } 

    if (resultado.getDate("fecha")==null) 
    { 
           producto.setFecha(null); 
    } 
    else 
    {

producto.setFecha(resultado.getDate("fecha")); 
    } 
} 
        catch (Exception e) 
        { 
              //Si se produce un error durante el mapping de atributos 
              producto=null; 
              System.out.println("Error en el mapping de atributos de un cliente de la clase ModeloProductoDAO, función mapperProducto"); 
        }

        // Devolver objeto cliente 
        return producto; 
    }

}