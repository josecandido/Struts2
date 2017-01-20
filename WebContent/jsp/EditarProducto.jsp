<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Editar un producto</title>
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
	<h3>Editar un producto</h3>
	<s:form method="post" action="Modifier_Producto">
		<s:hidden key="producto.id"/>
		<s:textfield name="producto.nombre" id="producto.nombre" label="Nombre" labelposition="top" cssClass="input"/>
		<s:textfield name="producto.unidades" id="producto.unidades" label="Unidades" labelposition="top" cssClass="input"/>
		<s:textfield name="producto.precio" id="producto.precio" label="Precio" labelposition="top" cssClass="input"/>
		<s:textfield name="producto.fecha" id="producto.fecha" label="Fecha" labelposition="top" cssClass="input"/>
		<s:submit value="Modificar un producto"/>
	</s:form>		
	<a href="Listado_Producto" type="button" class="btn btn-default">Atras</a>
</div>
</body>
</html>
