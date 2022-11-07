package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author steven
 */
@WebServlet(name = "ServletControlador", urlPatterns = ("/ServletControlador"))
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                case "visualizar":
                    this.visualizarDatos(request, response);
                    break;
                case "login":
                    this.login(request, response);
                    break;
                case "exit":
                    this.exit(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        //sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }

    /*private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }*/

    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //El onjeto encontrar ejecuta el query para el objeto cliente
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }

    private void visualizarDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //El objeto encontrar ejecuta el query para el objeto cliente
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspVisualizar = "/WEB-INF/paginas/cliente/visualizarDatos.jsp";
        request.getRequestDispatcher(jspVisualizar).forward(request, response);
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos el idCliente
        //int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //El onjeto encontrar ejecuta el query para el objeto cliente
        //Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        //request.setAttribute("cliente", cliente);
        String jspVisualizar = "/WEB-INF/paginas/cliente/visualizarDatos.jsp";
        request.getRequestDispatcher(jspVisualizar).forward(request, response);
    }
    
    private void exit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recuperamos el idCliente
        //int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //El onjeto encontrar ejecuta el query para el objeto cliente
        //Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        //request.setAttribute("cliente", cliente);
        String jspVisualizar = "login.jsp";
        request.getRequestDispatcher(jspVisualizar).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int numero_celular = Integer.parseInt(request.getParameter("numero_celular"));
        int bloque = Integer.parseInt(request.getParameter("bloque"));
        int apartamento = Integer.parseInt(request.getParameter("apartamento"));
        /*double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }*/

        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(nombre, apellido, numero_celular, bloque, apartamento);

        //Insertamos en la base de datos
        int registrosModificadss = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificadss);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int numero_celular = Integer.parseInt(request.getParameter("numero_celular"));
        int bloque = Integer.parseInt(request.getParameter("bloque"));
        int apartamento = Integer.parseInt(request.getParameter("apartamento"));
        /*double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }*/

        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente, nombre, apellido, numero_celular, bloque, apartamento);

        //Modificar el objeto en la base de datos
        int registrosModificads = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosModificads = " + registrosModificads);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente);

        //Eliminamos el objeto en la base de datos
        int registrosModificads = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificads = " + registrosModificads);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
