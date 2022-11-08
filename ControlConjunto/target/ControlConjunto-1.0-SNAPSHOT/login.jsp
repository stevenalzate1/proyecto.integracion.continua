<%-- 
    Document   : login
    Created on : 27/03/2022, 11:59:22 AM
    Author     : steve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/4739ff28c9.js" crossorigin="anonymous"></script>

        <title>Iniciar Sesion</title>
    </head>
    <header id="main-header" class="py-3 bg-info text-white">
        <div class="container">
            <div class="row">
                <div class="col-md-8" >
                    <h1>
                        <i class="fas fa-cog"></i> Iniciar Sesion
                    </h1>
                </div>
            </div>
        </div>
    </header>
    <body>
        <div class="container">
            <h4></h4>
            <p>Ingresar usuario y contraseña</p>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=login">
                <table border="0">
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Usuario</td>
                            <td><input type="text" name="user" value=""/></td>
                        </tr>
                        <tr>
                            <td>Contraseña</td>
                            <td><input type="password" name="password" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Ingresar"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        
        
                <!-- Pie de pagina -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
 
    </body>
</html>
