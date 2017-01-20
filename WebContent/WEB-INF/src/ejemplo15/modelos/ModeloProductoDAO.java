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
                     consultaString="SELECT * FROM productos WHERE 1 ORDER BY idproducto";

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
                     System.out.println("Error en la consulta de la clase ModeloClienteDAO función getListaClientes"); 
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
                            System.out.println("Error en el cierre de la conexion con la base de datos en la clase ModeloClienteDAO función getListaClientes"); 
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
                     consultaString = "SELECT * FROM productos WHERE idproducto=?";

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
                     System.out.println("Error en la consulta en la clase ModeloClienteDAO función getCliente"); 
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
                            System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloClienteDAO función getCliente"); 
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
                     consultaString="INSERT INTO productos (nombre,unidades,precio) VALUES(?,?,?)";

                     // Preparación de la consulta

       consulta=conexion.prepareStatement(consultaString); 
                     consulta.setString(1,producto.getNombre());
                     consulta.setInt(2, producto.getUnidades());
                     consulta.setInt(3, producto.getPrecio());

                     // Se vacía el cliente por seguridad 
                     producto=null;

                     // Ejecución de la consulta 
                     codigoError=consulta.executeUpdate(); 
              } 
              catch(Exception e) 
              { 
                     codigoError=0; 
                     System.out.println("Error en la consulta de la clase ModeloClienteDAO función agregarCliente"); 
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
                            System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloClienteDAO función agregarCliente"); 
                     } 
              }

              // Devolver el código de error 
              return codigoError; 
    }


       // eliminar un cliente en la base 
       public int eliminarCliente(int idCliente) 
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
                     consultaString="DELETE FROM cliente eWHERE idCliente=?";

       consulta=conexion.prepareStatement(consultaString); 
                     consulta.setInt(1,idCliente);

                     // Ejecución de la consulta 
                     codigoError=consulta.executeUpdate(); 
              } 
              catch(Exception e) 
              { 
                     codigoError=0; 
                     System.out.println("Error en la consulta de la clase ModeloClienteDAO función eliminarCliente"); 
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
                            System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloClienteDAO función eliminarCliente"); 
                      } 
              }

              // Devolver el código de error 
              return codigoError; 
       }


       // modificar un cliente en la base 
       public int modificarCliente(Producto producto) 
       { 
    	   /*
              // Variables 
              PreparedStatement consulta=null; 
              String consultaString=null; 
              int codigoError=0;

              try 
              { 
                     // Apertura de una conexión 
                     conexion=super.getConnection();

                     // Creación de la consulta 
                     consultaString="UPDATE cliente set identificador=?,contrasena=? WHERE idCliente=?";

       consulta=conexion.prepareStatement(consultaString); 
                     consulta.setString(1,cliente.getIdentificador()); 
                     consulta.setString(2, cliente.getContrasena()); 
                     consulta.setInt(3, cliente.getIdCliente());

                     // Se vacía el cliente por seguridad 
                     cliente=null;

                     // Ejecución de la consulta 
                     codigoError=consulta.executeUpdate(); 
              } 
              catch(Exception e) 
              { 
                     System.out.println("Error en la consulta de la clase ModeloClienteDAO función modificarCliente"); 
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
                            System.out.println("Error en el cierre de la conexión con la base de datos en la clase ModeloClienteDAO función modificarCliente"); 
                      } 
              }

              // Devolver el código de error   */
              return 0; 
            
       }


    // Realizar el mapping relacional hacia objeto 
    public Producto mapperProducto(ResultSet resultado) 
    { 
       // Variables 
       Producto producto=new Producto();

       try 
       { 
              if (resultado.getString("idProducto")==null) 
              { 
                     producto.setIdProducto(0); 
              } 
              else 
              {

       producto.setIdProducto(resultado.getInt("idproducto")); }

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
                     producto.setUnidades(100); 
              } 
              else 
              {

       producto.setUnidades(resultado.getInt("unidades")); 
              } 
              if (resultado.getString("precio")==null) 
              { 
                     producto.setPrecio(100); 
              } 
              else 
              {

       producto.setPrecio(resultado.getInt("precio")); 
              } 
       } 
        catch (Exception e) 
        { 
              //Si se produce un error durante el mapping de atributos 
              producto=null; 
              System.out.println("Error en el mapping de atributos de un cliente de la clase ModeloClienteDAO, función mapperCliente"); 
        }

        // Devolver objeto cliente 
        return producto; 
    }

}