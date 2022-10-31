package dominio;

/**
 *
 * @author steven
 */
public class Cliente {
    
    private int idCliente;
    private String nombre;
    private String apellido;
    private String genero;
    private String correo;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nombre, String apellido, String genero, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.correo = correo;
    }

    public Cliente(int idCliente, String nombre, String apellido, String genero, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + ", correo=" + correo + '}';
    }
     
    
}
