<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Listado de productos</title>
<style type="text/css">@import url(css/estilos.css);</style>
</head>
<body>
<!-- Mensaje de error -->
<s:if test="errors.size()>0">
<div id="mensaje_error">
	<label>Se han producido los errores siguientes: </label>
	<ul><s:fielderror/></ul>
</div>
</s:if>

<div id="carta">									
	<h3>Agregar un nuevo producto</h3>
	<s:form method="post" action="Agregar_Producto">
		<s:textfield name="producto.nombre" id="producto.nombre" label="Nombre" labelposition="top" cssClass="input"/>
		<s:textfield name="producto.unidades" id="producto.nombre" label="Unidades" labelposition="top" cssClass="input"/>
		<s:textfield name="producto.precio" id="producto.precio" label="Precio" labelposition="top" cssClass="input"/>
		<s:textfield name="producto.fecha" id="producto.fecha" label="Fecha" labelposition="top" cssClass="input"/>
		<s:submit value="Agregar un producto"/>
	</s:form><br>
	
	<h3>Listado de productos</h3>
	<table border="0" id="tabla" cellpadding="0" cellspacing="0">
	<tr><td><b>Nombre</b></td><td><b>Unidades</b></td><td><b>Precio</b></td><td><b>Fecha</b></td><td colspan="2" align="center"><b>Gesti&oacute;n</b></td></tr>
	<s:iterator value="listaProductos" status="linea">
	<s:if test="#linea.odd"><tr class="linea1"></s:if>
	<s:if test="#linea.even"><tr class="linea2"></s:if>
    	<td><s:property value="nombre"/></td>
    	<td><s:property value="unidades"/></td>
    	<td><s:property value="precio"/></td>
    	<td><s:property value="fecha"/></td>
    	<td align="center"><a href="Editar_Producto.action?idProductoActual=${id}"/><img src="imagenes/editarcliente.png" alt="Editar" title="Editar" border="0"/></a></td>
    	<td align="center"><a href="Eliminar_Producto.action?idProductoActual=${id}"/><img src="imagenes/eliminarcliente.png" alt="Eliminar" title="Eliminar" border="0"/></a></td>
  	</tr>
	</s:iterator>
	</table>	<br>
	<a href="./index.jsp" type="button" class="btn btn-default">Atras</a>
</div>
</body>
</html>
