package ejemplo15.javabeans;

@SuppressWarnings("serial")
public class Producto {

	   private int idProducto;
	   private String nombre;
	    private int unidades;
	    private int precio;
	
	    public Producto(){
	    	
	    }
	    
		public Producto(int idProducto,String nombre, int unidades, int precio){
	    	this.idProducto=idProducto;
	    	this.nombre=nombre;
	    	this.unidades=unidades;
	    	this.precio=precio;
	    }

		public int getIdProducto() {
			return idProducto;
		}

		public void setIdProducto(int idProducto) {
			this.idProducto = idProducto;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getUnidades() {
			return unidades;
		}

		public void setUnidades(int unidades) {
			this.unidades = unidades;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}
	
		
}
