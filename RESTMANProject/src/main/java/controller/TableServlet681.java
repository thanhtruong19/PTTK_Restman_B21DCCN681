package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tableDAO681;

/**
 * Servlet implementation class TableServlet681
 */
@WebServlet("/TableServlet681")
public class TableServlet681 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TableServlet681() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
		String date = request.getParameter("date"); // date là String dạng "yyyy-mm-dd"
		String timeSlot = request.getParameter("timeSlot");

		java.sql.Date newDate = java.sql.Date.valueOf(date);

        
		ArrayList<Integer> tableNumbers = tableDAO681.getEmptyTable681(newDate, timeSlot);

		// Tạo HTML cho danh sách bàn trống
		StringBuilder emptyTables = new StringBuilder();
		if (tableNumbers != null && !tableNumbers.isEmpty()) {
			for (Integer tableNumber : tableNumbers) {
				emptyTables.append("<option value=\"").append(tableNumber).append("\">Bàn ").append(tableNumber)
						.append("</option>");
			}
		} else {
			emptyTables.append("<option value=\"\">Không có bàn trống</option>");
		}
		
		response.setContentType("text/html");
        response.getWriter().write(emptyTables.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
