<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=windows-1252">
<title>Facturar Cliente</title>
<link rel="stylesheet" type="text/css" href="Styles/Tile/Style_doctype.css" />
<script language="JavaScript" type="text/javascript">
function buscar(){
   window.location="facturarCliente.jsp?s_numero_ficha_internacion="+document.getElementById('ficha_internacions_numero_ficha_internacion').value;
}
</script>
<script language="JavaScript" src="ClientI18N.php?file=Functions.js&amp;locale={res:CCS_LocaleID}" type="text/javascript" charset="utf-8"></script>
<script language="JavaScript" type="text/javascript">

</script>
</head>
<body>
<p><%@include  file="head.html" %></p>
<table border="1" width="100%">
  <tr>
    <td bgcolor="#dfae79">
      <div align="center"><font size="3"><b>Facturar Cliente</b></font></div>
 </td>
  </tr>
</table>
<%
String numero = request.getParameter("s_numero_ficha_internacion");
String buscador="";
if(numero.toString().isEmpty()){
    buscador="<br><form id='ficha_internacion' method='post' action='javascript:buscar();'>"+
"<table border='0' cellspacing='0' cellpadding='0'>"+
"<tr><td valign='top'><table class='Header' border='0' cellspacing='0' cellpadding='0'><tr>"+
"<td class='HeaderLeft'><img border='0' alt='' src='Styles/Tile/Images/Spacer.gif'></td>"+
"<td class='th'><strong>Buscar Ficha Internacion </strong></td>"+
"<td class='HeaderRight'><img border='0' alt='' src='Styles/Tile/Images/Spacer.gif'></td>"+
"</tr></table>"+
"<table class='Record' cellspacing='0' cellpadding='0'>"+
"<tr class='Controls'>"+
"<td class='th'><label for='ficha_internacions_numero_ficha_internacion'>N° Ficha Internacion</label></td>"+
"<td><input id='ficha_internacions_numero_ficha_internacion' maxlength='10' size='10'></td>"+
"<td>"+
"<input id='ficha_internacionButton_DoSearch' class='Button' alt='Buscar' value='Buscar' type='submit'></td>"+
"</tr><tr class='Bottom'><td colspan='3' align='right'></td></tr></table></td></tr></table></form>";
}
%>
<%= buscador%>
<br><table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
      <table class="Header" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="HeaderLeft"><img border="0" alt="" src="Styles/Tile/Images/Spacer.gif"></td>
          <td class="th"><strong>Lista de Ficha Internacion</strong></td>
          <td class="HeaderRight"><img border="0" alt="" src="Styles/Tile/Images/Spacer.gif"></td>
        </tr>
        <tr class="Caption"><td  colspan="5"><center><a href="facturarCliente.jsp?s_numero_ficha_internacion=" id="limpiar"><b>LIMPIAR</b></a></center></td></tr>
      </table>
        
      <table class="Grid" cellspacing="0" cellpadding="0">
        <tr class="Caption">
          <th style="TEXT-ALIGN: center" scope="col">Numero</th>
          <th style="TEXT-ALIGN: center" scope="col">Fecha Internacion</th>
          <th style="TEXT-ALIGN: center" scope="col">Numero Paciente</th>
          <th style="TEXT-ALIGN: center" scope="col">Nombre Paciente</th>
          <th style="TEXT-ALIGN: center" scope="col">DNI</th>
        </tr>

        <tr class="Row">
          <td style="TEXT-ALIGN: center"><a href="facturarCliente.jsp?s_numero_ficha_internacion=" id="ficha_internacion_pacientnumero_ficha_internacion_{ficha_internacion_pacient:rowNumber}">{numero_ficha_internacion}</a>&nbsp;</td>
          <td style="TEXT-ALIGN: center">{fecha}&nbsp;</td>
          <td style="TEXT-ALIGN: center">{numero_paciente}&nbsp;</td>
          <td style="TEXT-ALIGN: center">{nombre_paciente}&nbsp;</td>
          <td style="TEXT-ALIGN: center">{dni}&nbsp;</td>
        </tr>

        <tr class="NoRecords">
          <td colspan="5"><strong>No hay registros</strong></td>
        </tr>
      </table>
 </td>
</tr>
</table>

</body>
</html>