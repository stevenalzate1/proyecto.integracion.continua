<header id="main-header" class="py-3 bg-info text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-8" >
                <h1>
                    <i class="fas fa-cog"></i> Control de Usuarios
                </h1>
            </div>
            <!-- Botones de navegacion 
            <section id="actions" class="py-4 mb-4 bg-light">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <a href="#" class="btn btn-outline-dark btn-block" 
                                data-toggle="modal" data-target="#agregarClienteModal">
                                 <i class="fas fa-plus"></i> Agregar Usuario
                             </a>
                        </div>
                        <div class="col-md-3">
                            <a href="${pageContext.request.contextPath}/ServletControlador?accion=exit"
                               class="btn btn-danger btn-block">
                                <i class="fa-solid fa-right-from-bracket"></i> Exit
                            </a>
                        </div>
                    </div>
                </div>
            </section>
            --> 
            <div class="col-md-2 float-right mt-2">
                <a href="#" class="btn btn btn-success btn-block" 
                   data-toggle="modal" data-target="#agregarClienteModal">
                    <i class="fas fa-plus"></i> Agregar Usuario
                </a>
            </div>
            <div class="col-md-2 float-right mt-2">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=exit"
                    class="btn btn-danger btn-block">
                    <i class="fa-solid fa-arrow-right-from-bracket"></i> Cerrar Sesión
                </a>
            </div>
        </div>
    </div>
</header>