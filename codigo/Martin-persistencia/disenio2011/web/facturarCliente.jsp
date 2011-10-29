<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Facturar Cliente</title>
<link rel="stylesheet" type="text/css" href="Styles/Tile/Style_doctype.css" />
<script language="JavaScript" type="text/javascript">
function buscar(){
    var nrof=document.getElementById('ficha_internacions_numero_ficha_internacion').value;
    if(nrof == ''){ alert('Debe Ingresar Numero de Ficha');}
    else{ if(isNaN(nrof)){ alert('El valor ingresado no es numerico');}
        else{ window.location="redirect.jsp?s_numero_ficha_internacion="+nrof;}
    }
}
function limpiar(){
    window.location="facturarCliente.jsp";
}
</script>
</head>
<body>
<%@include  file="head.html" %>
<table border="1" width="100%">
  <tr>
    <td bgcolor="#dfae79">
      <div align="center"><font size="3"><b>Facturar Cliente</b></font></div>
 </td>
  </tr>
</table>
<%
String buscador="",resultado="";
int nroFicha=Integer.parseInt((String)session.getAttribute("s_numero_ficha_internacion"));
if(nroFicha == 0){
    buscador="<br><form id='ficha_internacion' method='post' action='javascript:buscar();'>"+
                            "<table border='0' cellspacing='0' cellpadding='0'>"+
                            "<tr><td valign='top'><table class='Header' border='0' cellspacing='0' cellpadding='0'><tr>"+
                            "<td class='HeaderLeft'><img border='0' alt='' src='Styles/Tile/Images/Spacer.gif'></td>"+
                            "<td class='th'><strong>Buscar Ficha Internacion </strong></td>"+
                            "<td class='HeaderRight'><img border='0' alt='' src='Styles/Tile/Images/Spacer.gif'></td>"+
                            "</tr></table>"+
                            "<table class='Record' cellspacing='0' cellpadding='0'>"+
                            "<tr class='Controls'>"+
                            "<td class='th'><label for='ficha_internacions_numero_ficha_internacion'>Nro Ficha Internacion</label></td>"+
                            "<td><input id='ficha_internacions_numero_ficha_internacion' maxlength='10' size='10' autocomplete='off'></td>"+
                            "<td>"+
                            "<input id='ficha_internacionButton_DoSearch' class='Button' alt='Buscar' value='Buscar' type='submit'></td>"+
                            "</tr><tr class='Bottom'><td colspan='3' align='right'></td></tr></table></td></tr></table></form>";
}else{
    boolean contenido=false;
    String row="";
    if(contenido){
            row="<tr class='NoRecords'><td colspan='5'><strong>No hay registros</strong></td></tr></table></td></tr></table>";
    }else{
            row="<tr class='Row'><td style='TEXT-ALIGN: center'>"+nroFicha+"&nbsp;</td>"+
                        "<td style='TEXT-ALIGN: center'>{fecha}&nbsp;</td>"+
                        "<td style='TEXT-ALIGN: center'>{numero_paciente}&nbsp;</td>"+
                        "<td style='TEXT-ALIGN: center'>{nombre_paciente}&nbsp;</td>"+
                        "<td style='TEXT-ALIGN: center'>{dni}&nbsp;</td></tr>";
            session.setAttribute("s_numero_ficha_internacion", "0");
    }
    resultado="<br><table width='100%' border='0' cellspacing='0' cellpadding='0'>"+
                                "<tr><td valign='top'>"+
                                "<table class='Header' border='0' cellspacing='0' cellpadding='0'>"+
                                "<tr><td class='HeaderLeft'><img border='0' alt='' src='Styles/Tile/Images/Spacer.gif'></td>"+
                                "<td class='th'><strong>Lista de Ficha Internacion</strong></td>"+
                                "<td class='HeaderRight'><img border='0' alt='' src='Styles/Tile/Images/Spacer.gif'></td></tr>"+
                                "<tr class='Caption'><td  colspan='5'><center><a href='redirect.jsp?s_numero_ficha_internacion=0' id='limpiar'><b>LIMPIAR</b></a></center></td></tr>"+
                                "</table>"+
                                "<table class='Grid' cellspacing='0' cellpadding='0'>"+
                                "<tr class='Caption'>"+
                                "<th style='TEXT-ALIGN: center' scope='col'>Numero</th>"+
                                "<th style='TEXT-ALIGN: center' scope='col'>Fecha Internacion</th>"+
                                "<th style='TEXT-ALIGN: center' scope='col'>Numero Paciente</th>"+
                                "<th style='TEXT-ALIGN: center' scope='col'>Nombre Paciente</th>"+
                                "<th style='TEXT-ALIGN: center' scope='col'>DNI</th></tr>"+row+
                                "<tr class='Bottom'><td colspan='5' align='right'></td></tr>";
}

%>
<%= buscador%>
<%= resultado%>
</body>
</html>