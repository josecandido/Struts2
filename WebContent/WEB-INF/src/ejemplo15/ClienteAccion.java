package ejemplo15;

import java.util.ArrayList; 
import java.util.List; 
import com.opensymphony.xwork2.ActionSupport; 
import com.opensymphony.xwork2.ModelDriven; 
import com.opensymphony.xwork2.Preparable; 
import ejemplo15.javabeans.Cliente; 
import ejemplo15.modelos.ModeloClienteDAO;

@SuppressWarnings("serial") 
public class ClienteAccion extends ActionSupport implements Preparable, ModelDriven{

    private Cliente cliente; 
    private List<Cliente> listaClientes; 
    private int idClienteActual;

       public void prepare() throws Exception { 
              ModeloClienteDAO modeloClienteDAO=new ModeloClienteDAO(); 
              // en creación, crear un nuevo objeto vacío 
              if(idClienteActual==0) 
              { 
                     cliente=new Cliente(); 
              } 
              // en modificación, devolver la información del objeto 
              else 
              {

      cliente=modeloClienteDAO.getCliente(idClienteActual); 
              } 
      }

      public Object getModel() { 
             return cliente; 
      }

      public int getIdClienteActual() { 
              return idClienteActual; 
      }

      public void setIdClienteActual(int idClienteActual) { 
             this.idClienteActual = idClienteActual; 
      }

      public Cliente getCliente() { 
             return cliente; 
      }

      public void setCliente(Cliente cliente) { 
             this.cliente = cliente; 
      }

      public List<Cliente> getListaClientes() { 
             ModeloClienteDAO ModeloClienteDAO=new ModeloClienteDAO();

listaClientes=(ArrayList<Cliente>)ModeloClienteDAO.getListaClientes(); 
             return listaClientes; 
      }

      public void setListaClientes(List<Cliente> listaClientes) { 
             this.listaClientes = listaClientes; 
      }

      // devolver la lista de clientes tras la recuperación 
      public String listado() 
      { 
             ModeloClienteDAO ModeloClienteDAO=new ModeloClienteDAO();

listaClientes=(ArrayList<Cliente>)ModeloClienteDAO.getListaClientes(); 
             return SUCCESS; 
      }

      // agregar el cliente al modelo 
      public String agregar() 
      { 
             ModeloClienteDAO ModeloClienteDAO=new ModeloClienteDAO(); 
             ModeloClienteDAO.agregarCliente(cliente); 
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