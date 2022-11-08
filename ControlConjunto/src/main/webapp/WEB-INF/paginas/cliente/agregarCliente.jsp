<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Usuario</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
                  method="POST" class="was-validated">
            
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>
                    <div class="form-group">
                        <label for="numero_celular">N�mero Celular</label>
                        <input type="number" class="form-control" name="numero_celular" required>
                    </div>
                    <div class="form-group">
                        <label for="bloque">Bloque</label>
                        <input type="number" class="form-control" name="bloque" required>
                    </div>
                    <div class="form-group">
                        <label for="apartamento">Apartamento</label>
                        <input type="number" class="form-control" name="apartamento" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
                
            </form>
        </div>
    </div>
</div>