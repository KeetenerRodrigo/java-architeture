<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>AppVenda</title>
	</head>
	<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">AppVenda</a></li>
				<li class="nav-item"><a class="nav-link" href="/seller/list">Vendedor</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/list">Produto</a></li>
				<li class="nav-item"><a class="nav-link" href="/cleaning/list">Produtos de limpeza</a></li>
				<li class="nav-item"><a class="nav-link" href="/pharmaceutical/list">Produtos Farmaceuticos</a></li>
			</ul>
			<div style="margin-left: 2px;" >
				<span class="badge rounded-pill bg-primary">Vendedor: ${sellerQuantity}</span> 
				<span class="badge rounded-pill bg-secondary">Produto: ${productQuantity}</span> 
				<span class="badge rounded-pill bg-success">Produtos Farmacêuticos: ${pharmaceuticalQuantity}</span> 
				<span class="badge rounded-pill bg-danger">Produtos de limpeza: ${cleaningQuantity}</span>
			</div>
			<c:if test="${not empty list}">
				<form class="d-flex" action="/${route}/search">
					<input class="form-control me-2" type="text" name="searchField"placeholder="Digite...">
					<button class="btn btn-primary" type="submit">Pesquisar</button>
				</form>
			</c:if>
		</div>
	</nav>

	<div class="container mt-3">

		<c:if test="${not empty list}">
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${title}</th>
						<th></th>
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
		<hr>
		<hr>
		<c:if test="${empty list}">
			<form action="/information/insert" method="post">
				<div class="row">
					<div class="col">
						<input type="text" class="form-control"
							placeholder="Entre com o campo" name="field">
					</div>
					<div class="col">
						<input type="text" class="form-control"
							placeholder="Entre com a descrição"  name="description">
					</div>
					<div class="col">
						<button class="btn btn-primary" type="submit">Cadastrar</button>
					</div>
				</div>
			</form>
			<hr>
			<hr>

			<c:if test="${not empty informations}">
				<table class="table">
					<thead class="table-dark">
						<tr>
							<th>Informações:</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${informations}">
							<tr>
								<td>${item}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</c:if>

		<c:if test="${not empty object}">
			<div class="alert alert-success">
				<strong>Sucesso!</strong> ${object}
			</div>
		</c:if>
	</div>

	</body>
</html>