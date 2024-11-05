<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Trang chu khach hang</title>
<script>
    // Hàm để chuyển hướng trang
    function openPage(pageUrl) {
        window.location.href = pageUrl;
    }
</script>
</head>
<body>
<%
User user = (User)session.getAttribute("customer");
if(user ==null){
response.sendRedirect("gdDangNhap681.jsp?err=timeout");
}
%>
<h2> Trang chủ khách hàng</h2>
<button onclick="openPage('gdDatBan681.jsp')">Đặt bàn</button>
</body>
</html>