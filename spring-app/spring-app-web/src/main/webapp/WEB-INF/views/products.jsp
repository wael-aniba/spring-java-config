<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<title>PRODUCT MANAGEMENT</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
</head>

<body>

	<div class="siteTilte">PRODUCT MANAGEMENT</div>

	<div>
		<sf:form id="productForm" modelAttribute="product" action="addProduct"
			method="post">
			<table>
				<tr>
					<td>REF</td>
					<td><sf:input path="reference" /></td>
					<td><sf:errors path="reference" cssClass="error" /></td>
				</tr>
				<tr>
					<td>DESIGNATION</td>
					<td><sf:input path="designation" /></td>
					<td><sf:errors path="designation" cssClass="error" /></td>
				</tr>
				<tr>
					<td>PRICE</td>
					<td><sf:input path="price" /></td>
					<td><sf:errors path="price" cssClass="error" /></td>
				</tr>
				<tr>
					<td>QUANTITY</td>
					<td><sf:input path="quantity" /></td>
					<td><sf:errors path="quantity" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Save"></td>
				</tr>
			</table>
		</sf:form>
	</div>

	<div>
		<table class="table">
			<tr>
				<th>Reference</th>
				<th>Designation</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${products}" var="prod">
				<tr>
					<td>${prod.reference}</td>
					<td>${prod.designation}</td>
					<td>${prod.price}</td>
					<td>${prod.quantity}</td>
					<td>
						<c:url var="deleteUrl" value="/deleteProduct"/>    
						<form id="deleteForm" action="${deleteUrl}" method="POST">
						      <input id="prod" name="prod" type="hidden" value="${prod.reference}"/>
						      <input type="submit" value="delete" onClick="return confirm('sure?')"/>
						</form>
					</td>
					<td>
						<c:url var="selectForUpdate" value="/selectForUpdate"/>    
						<form id="selectForUpdate" action="${selectForUpdate}" method="POST">
						      <input id="selectedProd" name="selectedProdRef" type="hidden" value="${prod.reference}"/>
						      <input type="submit" value="select" />
						</form>						
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>