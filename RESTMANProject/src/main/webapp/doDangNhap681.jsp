<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>
<%
String username = (String) request.getParameter("username");
String password = (String) request.getParameter("password");
User user = new User();
user.setUserName(username);
user.setPassword(password);
UserDAO dao = new UserDAO();
boolean kq = dao.loginCheck(user);
if (kq && user.getRole().equalsIgnoreCase("customer")) {
	session.setAttribute("customer", user);
	response.sendRedirect("customer/gdchinhKH681.jsp");
} else if (kq && user.getRole().equalsIgnoreCase("manager")) {
	session.setAttribute("manager", user);
	response.sendRedirect("manager/gdChinhQuanLi681.jsp");
} else {
	response.sendRedirect("gdDangNhap681.jsp?err=fail");
}
%>