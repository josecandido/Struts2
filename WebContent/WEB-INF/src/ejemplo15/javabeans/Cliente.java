package ejemplo15.javabeans;


@SuppressWarnings("serial")
public class Cliente {
	
    private int idCliente;
	private String identificador;
    private String contrasena;

	public Cliente(){
    	
    }
    
	public Cliente(int idCliente,String identificador, String contrasena){
    	this.idCliente=idCliente;
    	this.identificador=identificador;
    	this.contrasena=contrasena;
    }
	
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
}


