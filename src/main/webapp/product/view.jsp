<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết sản phẩm</title>
</head>
<body>
<h2>Chi tiết sản phẩm</h2>
<p>ID: ${product.id}</p>
<p>Tên: ${product.name}</p>
<p>Giá: ${product.price}</p>
<p>Mô tả: ${product.description}</p>
<p>Nhà sản xuất: ${product.manufacturer}</p>
<a href="${pageContext.request.contextPath}/products">Quay lại</a>
</body>
</html>