package dominio;

/**
 *
 * @author steven
 * Clase encargada de instanciar las variables
 */
public class Cliente {
    
    private int idCliente;
    private String nombre;
    private String apellido;
    private int numero_celular;
    private int bloque;
    private int apartamento;

    public Cliente() {
    }

    /*
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }*/

    public Cliente(int idCliente, String nombre, String apellido, int numero_celular, int bloque, int apartamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_celular = numero_celular;
        this.bloque = bloque;
        this.apartamento = apartamento;
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nombre, String apellido, int numero_celular, int bloque, int apartamento) {
        this.apellido = apellido;
        this.numero_celular = numero_celular;
        this.bloque = bloque;
        this.apartamento = apartamento;
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

    public int getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(int numero_celular) {
        this.numero_celular = numero_celular;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", numero_celular=" + numero_celular + ", bloque=" + bloque + ", apartamento="+ apartamento +'}';
    }
     
    
}
