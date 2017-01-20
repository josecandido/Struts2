package ejemplo15;

import java.util.ArrayList; 
import java.util.List; 
import com.opensymphony.xwork2.ActionSupport; 
import com.opensymphony.xwork2.ModelDriven; 
import com.opensymphony.xwork2.Preparable; 
import ejemplo15.javabeans.Producto; 
import ejemplo15.modelos.ModeloProductoDAO;

@SuppressWarnings("serial") 
public class ProductoAccion extends ActionSupport implements Preparable, ModelDriven{

    private Producto producto; 
    private List<Producto> listaProductos; 
    private int idProductoActual;

       public void prepare() throws Exception { 
              ModeloProdcutoDAO modeloProductoDAO=new ModeloProductoDAO(); 
              // en creación, crear un nuevo objeto vacío 
              if(idProductoActual==0) 
              { 
                     producto=new Producto(); 
              } 
              // en modificación, devolver la información del objeto 
              else 
              {

      producto=modeloProductoDAO.getProducto(idProductoActual); 
              } 
      }

      public Object getModel() { 
             return producto; 
      }

      public int getIdProductoActual() { 
              return idProductoActual; 
      }

      public void setIdProductoActual(int idProductoActual) { 
             this.idProductoActual = idProductoActual; 
      }

      public Producto getProducto() { 
             return producto; 
      }

      public void setProducto(Producto producto) { 
             this.producto = producto; 
      }

      public List<Producto> getListaProductos() { 
             ModeloProductoDAO ModeloProductoDAO=new ModeloProductoDAO();

listaProductos=(ArrayList<Producto>)ModeloProductoDAO.getListaProductos(); 
             return listaProductos; 
      }

      public void setListaProductos(List<Producto> listaProductos) { 
             this.listaProductos = listaProductos; 
      }

      // devolver la lista de clientes tras la recuperación 
      public String listado() 
      { 
             ModeloProductoDAO ModeloProductoDAO=new ModeloProductoDAO();

listaProductos=(ArrayList<Producto>)ModeloProductoDAO.getListaProductos(); 
             return SUCCESS; 
      }

      // agregar el cliente al modelo 
      public String agregar() 
      { 
             ModeloProductoDAO ModeloProductoDAO=new ModeloProductoDAO(); 
             ModeloProductoDAO.agregarProducto(producto); 
             return SUCCESS; 
      }

      // mostrar el formulario en edición 
      public String editar() 
      { 
             return SUCCESS; 
      }

      // modificar un cliente 
      public String modificar() 
      { 
             ModeloClienteDAO ModeloClienteDAO=new ModeloClienteDAO(); 
             ModeloClienteDAO.modificarCliente(cliente); 
             return SUCCESS; 
      }

      // eliminar un cliente a partir del parámetro recibido llamado idCliente 
      public String eliminar() 
      { 
             ModeloClienteDAO ModeloClienteDAO=new ModeloClienteDAO(); 
             ModeloClienteDAO.eliminarCliente(idClienteActual); 
             return SUCCESS; 
      } 
}