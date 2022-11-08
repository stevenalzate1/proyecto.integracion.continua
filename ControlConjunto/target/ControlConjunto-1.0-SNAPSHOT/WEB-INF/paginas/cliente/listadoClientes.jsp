<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-sm-5 col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="text-center">Listado de usuarios</h4>
                    </div>
                    <div id="scroll-tabla" style="overflow: scroll; height: 300px; width: 1108px;">
                        <table class="table table-hover table-light">
                            <thead class="thead-light text-center">
                                <tr>
                                    <th>N°</th>
                                    <th>Nombres y Apellidos</th>
                                    <th>Genero</th>
                                    <th>Correo</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody class="text-center">
                                <!-- Iteramos cada elemento de la lista de clientes -->
                                <c:forEach var="cliente" items="${clientes}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${cliente.nombre} ${cliente.apellido}</td>
                                        <td>${cliente.genero}</td>
                                        <td>${cliente.correo}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
                                               class="btn btn-secondary">
                                                <i class="fas fa-edit"></i>
                                            </a>
                                            <a href="${pageContext.request.contextPath}/ServletControlador?accion=visualizar&idCliente=${cliente.idCliente}"
                                               class="btn btn-primary">
                                                <i class="fas fa-eye"></i> 
                                            </a>
                                            <a onclick="return confirmDel()" href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}"
                                               class="btn btn-danger">
                                                <i class="fas fa-trash"></i>
                                                <script>
                                                    function confirmDel() {
                                                        var agree = confirm("¿Realmente desea eliminarlo? ");
                                                        if (agree)
                                                            return true;
                                                        return false;
                                                    }
                                                </script>
                                            </a>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>

<!-- Agregar cliente MODAL -->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>