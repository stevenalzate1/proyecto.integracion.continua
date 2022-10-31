package datos;

import dominio.Cliente;

import java.sql.*;
import java.util.*;

/**
 *
 * @author steven
 */
public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, genero, correo "
            + " FROM cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, genero, correo "
            + " FROM cliente WHERE id_cliente = ?";

    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, genero, correo) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, genero=?, correo=? "
            + " WHERE id_cliente=?";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

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
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String genero = rs.getString("genero");
                String correo = rs.getString("correo");

                cliente = new Cliente(idCliente, nombre, apellido, genero, correo);
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
            String genero = rs.getString("genero");
            String correo = rs.getString("correo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setGenero(genero);
            cliente.setCorreo(correo);

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
            stmt.setString(3, cliente.getGenero());
            stmt.setString(4, cliente.getCorreo());

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
            stmt.setString(3, cliente.getGenero());
            stmt.setString(4, cliente.getCorreo());
            stmt.setInt(5, cliente.getIdCliente());

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
