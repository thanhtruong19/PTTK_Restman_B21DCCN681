<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Đặt Bàn Trực Tuyến</title>
<link rel="stylesheet" href="styles.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Đặt Bàn Trực Tuyến</h2>

		<%-- Hiển thị thông báo nếu có --%>

		<form action="<%= request.getContextPath() %>/TableReservationServlet681" method="post" class="booking-form">
			
			<label for="date">Chọn ngày:</label>
			<input type="date" id="date" name="date" min="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" required>

			<label for="timeSlot">Chọn khung giờ:</label>
			<select id="timeSlot" name="timeSlot" required>
				<option value="10:30-12:30">Buổi trưa (10h30-12h30)</option>
				<option value="13:00-15:00">Buổi chiều (13h-15h)</option>
				<option value="15:30-17:30">Buổi chiều (15h30-17h30)</option>
				<option value="18:00-20:00">Buổi tối (18h-20h)</option>
				<option value="20:30-22:30">Buổi tối (20h30-22h30)</option>
			</select>

			<label for="table">Chọn bàn:</label>
			<select id="table" name="table">
				<option value="">Chưa có bàn trống</option>
			</select>

			<label for="name">Tên:</label>
			<input type="text" id="name" name="name" required>

			<label for="address">Địa chỉ:</label>
			<input type="text" id="address" name="address" required>

			<label for="email">Email:</label>
			<input type="email" id="email" name="email" required>

			<label for="phone">Số điện thoại:</label>
			<input type="tel" id="phone" name="phone" required>
			
			<label for="note">Ghi chú:</label>
			<input type="tel" id="note" name="note" required>

			<button type="submit" class="confirm-button">Xác nhận</button>
			
			<% String message = (String) request.getAttribute("message"); %>
			<% if (message != null) { %>
		    <div class="alert-message">
		        <%= message %>
		    </div>
			<% } %>
		</form>
	</div>
	
	
	<script>
	    $(document).ready(function() {
	        $('#date, #timeSlot').on('change', function() {
	            var date = $('#date').val();
	            var timeSlot = $('#timeSlot').val();
	            
	            if (date && timeSlot) {
	                $.ajax({
	                    url: '<%= request.getContextPath() %>/TableServlet681',
	                    type: 'POST',
	                    data: {
	                        date: date,
	                        timeSlot: timeSlot
	                    },
	                    success: function(response) {
	                        $('#table').html(response);
	                    }
	                });
	            }
	        });
	    });
	</script>
</body>
</html>
