<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form action="${pageContext.request.contextPath}/products?action=create" method="post">
    <p>Tên sản phẩm: <input type="text" name="name" required></p>
    <p>Giá: <input type="number" name="price" step="0.01" min="0" required></p>
    <p>Mô tả: <input type="text" name="description" required></p>
    <p>Nhà sản xuất: <input type="text" name="manufacturer" required></p>
    <button type="submit">Lưu</button>
</form>
<a href="${pageContext.request.contextPath}/products">Quay lại</a>
</body>
</html>