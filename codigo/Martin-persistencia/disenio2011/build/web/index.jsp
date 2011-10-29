<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRUEBA</title>
    </head>
    <body>
        <table border="1" width="100%">
          <tr>
             <% session.setAttribute("s_numero_ficha_internacion", "0");%>
            <td align="center"><a href="facturarCliente.jsp">Facturar Cliente</a></td>
            <td align="center"><a href="cobrarCliente.jsp">Cobrar Cliente</a></td>
          </tr>
        </table>
    </body>
</html>
