<%
String parametro = request.getParameter("s_numero_ficha_internacion");
session.setAttribute("s_numero_ficha_internacion", parametro);
response.sendRedirect("facturarCliente.jsp");
%>