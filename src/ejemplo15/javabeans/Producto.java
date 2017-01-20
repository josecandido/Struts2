package ejemplo15.javabeans;

import java.sql.Date;

@SuppressWarnings("serial")
public class Producto {

	   private int id;
	   private String nombre;
	    private int unidades;
	    private float precio;
	    private Date fecha;
	
	    public Producto(){
	    	
	    }
	    
		public Producto(int id, String nombre, int unidades, float precio, Date fecha){
	    	this.id=id;
	    	this.nombre=nombre;
	    	this.unidades=unidades;
	    	this.precio=precio;
	    	this.fecha=fecha;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public float getPrecio() {
			return precio;
		}

		public void setPrecio(float precio) {
			this.precio = precio;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
}