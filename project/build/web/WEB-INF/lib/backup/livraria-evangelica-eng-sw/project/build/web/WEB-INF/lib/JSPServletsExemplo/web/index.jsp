<%-- 
    Document   : index
    Created on : 05/09/2016, 21:55:46
    Author     : eryc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Página de Login</title>
</head>
    <body>
    <form action="AdicionaPessoa" method="POST">
                ID.: <input type="text" name="id" />
        <br />
                Telefone.: <input type="text" name="tel" />
        <br />
                Email.: <input type="text" name="email" />
        <br />
                CEP.: <input type="text" name="cep" />
        <br />
                Logradouro.: <input type="text" name="logradouro" />
        <br />
                complemento.: <input type="text" name="complemento" />
        <br />
                numero.: <input type="text" name="numero" />
        <br />
                bairro.: <input type="text" name="bairro" />
        <br />
                cidade.: <input type="text" name="cidade" />
        <br />
                estado.: <input type="text" name="estado" />
        <br />
                pais.: <input type="text" name="pais" />
        <br />
                senha.: <input type="password" name="senha" />
        <br />
        <br />
        <input type="submit" value="Enviar"/>
    </form>
</body>
</html>