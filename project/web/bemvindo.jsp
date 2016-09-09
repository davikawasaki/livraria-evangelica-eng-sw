<%--
  Created by IntelliJ IDEA.
  User: davikawasaki
  Date: 05/09/16
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Primeira página em JSP</title>
</head>
<body>
    <%-- comentário em JSP aqui: nossa primeira página JSP --%>
    <%
        String mensagem = "";
    %>
    <%
        out.println(mensagem);
    %>
    <br/>
    <%
        String desenvolvido = "Desenvolvido para Livraria - Engenharia de Software!";
    %>
    <%= desenvolvido %>
    <br/>
    <%
        System.out.println("Tudo foi executado!");
    %>
</body>
</html>
