package controller;

import java.io.IOException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.foodDAO681;
import model.Food681;
import dao.foodDAO681;
/**
 * Servlet implementation class FoodServlet681
 */
@WebServlet("/FoodServlet681")

public class FoodServlet681 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private foodDAO681 foodDAO = new foodDAO681();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet681() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");
		String photo = request.getParameter("photo");
		System.out.println(name + " " + price + " " + description + " " + photo);
		Food681 food = new Food681();
		food.setName(name);
		food.setPrice(price);
		food.setDescription(description);
		food.setPhoto(photo);
		System.out.println("Link ảnh:" + photo);
		 boolean isSuccess;
		try {
			isSuccess = foodDAO.saveNewFood681(food);
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		}
		if (isSuccess) {
	        request.setAttribute("message", "Lưu thành công");
	    } else {
	        request.setAttribute("message", "Lưu thất bại");
	    }
		request.getRequestDispatcher("/WEB-INF/manager/gdThemThongTinMonAn681.jsp").forward(request, response);
	}
	


}
