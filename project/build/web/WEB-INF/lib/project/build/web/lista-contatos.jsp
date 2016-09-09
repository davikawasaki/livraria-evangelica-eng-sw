<%-- 
    Document   : lista-contatos
    Created on : 08/09/2016, 21:29:29
    Author     : lucasfranco
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="dao" class="DAOclasses.FornecedorDAO"/>
        
        <table>
            <c:forEach var="fornecedor" items="${dao.lista}">
                <tr>
                    <td>${fornecedor.nomeRepresentante}</td>
                    <td>${fornecedor.tipoServico}</td>
                    <td>${fornecedor.tipoServico}</td>
                    
                </tr>
            </c:forEach>
        </table>
    
    
    </body>
</html>
