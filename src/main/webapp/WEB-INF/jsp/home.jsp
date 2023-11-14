<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>App Venda</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/">App Venda</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/sellers">Vendedores</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/products">Produtos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/cleanings">Produtos de Limpeza</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/pharmaceuticals">Produtos Farmacêutico</a>
	      </li>
	    </ul>
	  </div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Quantidade de vendedores: ${sellerQuantity}</span>
	  	<span class="badge rounded-pill bg-secondary">Quantidade de produtos: ${productQuantity}</span>
	  	<span class="badge rounded-pill bg-success">Quantidade de produtos de limpeza: ${productQuantity}</span>
	  	<span class="badge rounded-pill bg-danger">Quantidade de produtos de Produtos farmacêutico: ${pharmaceuticalQuantity}</span>

  		<c:if test="${not empty list}">
			<h2>App Venda</h2>
			<p>Gestão de vendas de produtos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
					  <th>${title}</th>
					  <th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
						  <td>${item}</td>
						  <td><a href="/${route}/${item.id}/delete">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>