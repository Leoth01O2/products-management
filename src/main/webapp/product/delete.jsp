<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xóa sản phẩm</title>
</head>
<body>
<h2>Xác nhận xóa sản phẩm</h2>
<p>Tên: ${product.name}</p>
<p>Giá: ${product.price}</p>
<form action="${pageContext.request.contextPath}/products?action=delete" method="post">
    <input type="hidden" name="id" value="${product.id}">
    <button type="submit">Xóa</button>
    <a href="${pageContext.request.contextPath}/products">Hủy</a>
</form>
</body>
</html>