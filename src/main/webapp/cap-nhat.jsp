<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 11/18/25
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/lop-hoc/cap-nhat?id=${lopHoc.id}" method="post">
    <p><label>Ten lop</label>
        <input type="text" name="tenLop" value="${lopHoc.tenLop}"></p>
    <p><label>Gvcn</label>
        <input type="text" name="gvcn" value="${lopHoc.gvcn}"></p>
    <p><label>Trang thai</label>
        <input type="radio" name="trangThai" value="Dang hoc" ${lopHoc.trangThai == "Dang hoc" ? "checked": ""}> Dang
        hoc
        <input type="radio" name="trangThai" value="Ket thuc"  ${lopHoc.trangThai == "Ket thuc" ? "checked": ""}> Ket thuc </p>
    <button type="submit">Cap nhat</button>
</form>
</body>
</html>
