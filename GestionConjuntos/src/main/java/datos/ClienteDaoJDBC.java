package datos;

import dominio.Cliente;

import java.sql.*;
import java.util.*;

/**
 *
 * @author steven
 */
public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_propiedad, nombre, apellido, numero_celular, bloque, apartamento "
            + " FROM cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT id_propiedad, nombre, apellido, numero_celular, bloque, apartamento "
            + " FROM cliente WHERE id_propiedad = ?";

    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, numero_celular, bloque, apartamento) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, numero_celular=?, bloque=?, apartamento=? "
            + " WHERE id_propiedad=?";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_propiedad = ?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_propiedad");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int numero_celular = rs.getInt("numero_celular");
                int bloque = rs.getInt("bloque");
                int apartamento = rs.getInt("apartamento");

                cliente = new Cliente(idCliente, nombre, apellido, numero_celular, bloque, apartamento);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.absolute(1);//Nos posicionamos en el registro devuelto

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int numero_celular = rs.getInt("numero_celular");
            int bloque = rs.getInt("bloque");
            int apartamento = rs.getInt("apartamento");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setNumero_celular(numero_celular);
            cliente.setBloque(bloque);
            cliente.setApartamento(apartamento);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setInt(3, cliente.getNumero_celular());
            stmt.setInt(4, cliente.getBloque());
            stmt.setInt(5, cliente.getApartamento());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setInt(3, cliente.getNumero_celular());
            stmt.setInt(4, cliente.getBloque());
            stmt.setInt(5, cliente.getApartamento());
            stmt.setInt(6, cliente.getIdCliente());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
