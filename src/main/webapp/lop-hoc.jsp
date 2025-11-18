<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 11/8/25
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body>
<form action="/lop-hoc/them" method="post">
    <p><label>Ten lop</label>
        <input type="text" name="tenLop"></p>
    <p><label>Gvcn</label>
        <input type="text" name="gvcn"></p>
    <p><label>Trang thai</label>
        <input type="radio" name="trangThai" value="Dang hoc"> Dang hoc
        <input type="radio" name="trangThai" value="Ket thuc"> Ket thuc </p>
    <button type="submit">Add</button>
</form>

<table class="table">
    <thead>
    <tr>
        <td>id</td>
        <td>ten lop</td>
        <td>gvcn</td>
        <td>trang thai</td>
        <td>ngay tao</td>
        <td>Hanh dong</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="lh" items="${list}">
        <tr>
            <td>${lh.id}</td>
            <td>${lh.tenLop}</td>
            <td>${lh.gvcn}</td>
            <td>${lh.trangThai}</td>
            <td>${lh.createdAt}</td>
            <td><a href="/lop-hoc/xoa?id=${lh.id}" class="btn btn-primary">Xoa</a></td>
            <td><a href="/lop-hoc/chi-tiet?id=${lh.id}" class="btn btn-primary">Chi tiet</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
