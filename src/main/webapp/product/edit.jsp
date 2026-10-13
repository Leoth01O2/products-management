<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa sản phẩm</title>
</head>
<body>
<h2>Cập nhật sản phẩm</h2>
<form action="${pageContext.request.contextPath}/products?action=edit" method="post">
    <input type="hidden" name="id" value="${product.id}">
    <p>Tên sản phẩm: <input type="text" name="name" value="${product.name}" required></p>
    <p>Giá: <input type="number" name="price" value="${product.price}" step="0.01" min="0" required></p>
    <p>Mô tả: <input type="text" name="description" value="${product.description}" required></p>
    <p>Nhà sản xuất: <input type="text" name="manufacturer" value="${product.manufacturer}" required></p>
    <button type="submit">Cập nhật</button>
</form>
<a href="${pageContext.request.contextPath}/products">Quay lại</a>
</body>
</html>