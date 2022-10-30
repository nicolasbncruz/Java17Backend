<%@page import="java.util.Base64"%>
<%@page import="edu.cibertec.dto.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foto de usuario</title>
    </head>
    <body>
        <h1>Foto del Usuario</h1>
        <% if (request.getAttribute("usuario") == null
                    || ((UsuarioDTO) request.getAttribute("usuario")).getFoto() == null) { %>
        <h2>Usuario aún sin foto</h2>
        <% } else {%>
             <img src="<%= "data:image/jpeg;base64," + 
                     Base64.getEncoder().encodeToString(((UsuarioDTO) 
                        request.getAttribute("usuario")).getFoto())%>" />
        <% } %>
        <br />
        <form method="post" action="fotoGrabar.do" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Selecciona foto: </td>
                    <td><input type="file" name="archivo"></td>
                </tr>
                <tr>
                </tr>
                <tr><td colspan="2" align="center">
                        <input type="submit" value="Subir foto en jpg"></td>
                </tr>
            </table>
            <input type="hidden" name="idUsuario" value="<%= ((UsuarioDTO) request.getAttribute("usuario")).getIdUsuario()%>">
        </form>
    </body>
</html>
