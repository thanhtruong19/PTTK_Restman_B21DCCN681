<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Thông Tin Món Ăn</title>
<link rel="stylesheet" href="addFoodStyles.css">
</head>
<body>
    <div class="container">
        <h2>Thêm Thông Tin Món Ăn</h2>

        <!-- Hiển thị thông báo nếu có -->
        <c:if test="${not empty message}">
            <p style="color: ${message == 'Lưu thành công' ? 'green' : 'red'};">${message}</p>
        </c:if>

        <form action="<%= request.getContextPath() %>/FoodServlet681" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Tên Món Ăn:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="price">Giá:</label>
                <input type="text" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="description">Mô Tả:</label>
                <input type="text" id="description" name="description" required>
            </div>
            <div class="form-group">
    			<label for="photo">Ảnh:</label>
    			<input type="file" id="photo" name="photo" accept="image/*" required onchange="previewImage(event)">
    			<img id="preview" src="" alt="Ảnh xem trước" style="display: visible;">
			</div>
            <div class="form-group">
                <input type="submit" value="Thêm Món Ăn">
            </div>
        </form>
    </div>

    <script>
    function previewImage(event) {
        const file = event.target.files[0];
        const preview = document.getElementById('preview');
        
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                preview.src = e.target.result;
                preview.style.display = 'block';
            };
            reader.readAsDataURL(file);
        } else {
            preview.src = '';
            preview.style.display = 'none';
        }
    }
	</script>

</body>
</html>