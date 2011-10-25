<%-- 
    Document   : index
    Created on : 21/10/2011, 22:39:21
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page  import="persistencia.FachadaPersistenciaInterna" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRUEBA</title>
    </head>
    <body>
        <%
                                FachadaPersistenciaInterna FPI = new FachadaPersistenciaInterna();
                                Object o1=FPI;
                                Object o2=(Object)o1;
                                Object o3=o2;
                                String s="prueba: "+o3.getClass().getSimpleName();
                    %>
        <h1><%= s%></h1>
    </body>
</html>
