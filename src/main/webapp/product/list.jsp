<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f8fafc; }
        h1 { color: #1b2a7a; }
        .top { display: flex; justify-content: space-between; align-items: center; gap: 20px; }
        .btn { text-decoration: none; padding: 8px 14px; border-radius: 4px; }
        .create { background: #27ae60; color: white; }
        form { margin: 15px 0; }
        input { padding: 8px; }
        button { padding: 8px 14px; cursor: pointer; }
        table { width: 100%; border-collapse: collapse; background: white; }
        th, td { border-bottom: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background: #1b2a7a; color: white; }
        .actions a { margin-right: 10px; }
    </style>
</head>
<body>
<div class="top">
    <h1>Danh sách sản phẩm</h1>
    <a class="btn create" href="${pageContext.request.contextPath}/products?action=create">Thêm sản phẩm</a>
</div>

<form action="${pageContext.request.contextPath}/products" method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name" value="${keyword}" placeholder="Nhập tên sản phẩm">
    <button type="submit">Tìm kiếm</button>
    <a href="${pageContext.request.contextPath}/products">Tất cả</a>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả</th>
        <th>Nhà sản xuất</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td><a href="${pageContext.request.contextPath}/products?action=view&id=${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td class="actions">
                <a href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}">Sửa</a>
                <a href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>