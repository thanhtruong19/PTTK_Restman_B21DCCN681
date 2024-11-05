<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Trang chu khach hang</title>

<style>
body {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
}

.container {
	background-color: #fff;
	padding: 20px 40px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	border-radius: 8px;
	width: 100%;
	max-width: 400px;
	text-align: center;
}

h2 {
	color: #333;
}

button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	border: none;
	border-radius: 4px;
	color: #fff;
	font-size: 16px;
	cursor: pointer;
	margin-top: 10px;
}

button:hover {
	background-color: #0056b3;
}
</style>

<script>
    // Hàm để chuyển hướng trang
    function openPage(pageUrl) {
        window.location.href = pageUrl;
    }
</script>
</head>
<body>
	<div class="container">
		<%
User user = (User)session.getAttribute("customer");
if(user ==null){
response.sendRedirect("gdDangNhap681.jsp?err=timeout");
}
%>
		<h2>Trang chủ khách hàng</h2>
		<button onclick="openPage('gdDatBan681.jsp')">Đặt bàn</button>
	</div>
</body>
</html>