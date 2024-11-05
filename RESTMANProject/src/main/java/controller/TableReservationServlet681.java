package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO681;
import dao.tableReservationDAO681;
import model.Customer681;
import model.tableReservation681;

/**
 * Servlet implementation class TableReservationServlet681
 */
@WebServlet("/TableReservationServlet681")
public class TableReservationServlet681 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableReservationServlet681() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public class DateConversionExample {
	    public static java.sql.Date convertToSqlDate(String dateStr) {
	        // Định dạng ngày theo kiểu "dd-MM-yyyy"
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        try {
	            // Chuyển chuỗi thành java.util.Date
	            Date utilDate = (Date) sdf.parse(dateStr);

	            // Chuyển java.util.Date thành java.sql.Date
	            return new java.sql.Date(utilDate.getTime());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Thiết lập mã hóa UTF-8 cho request và response
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		//dữ liệu bàn
		String date = request.getParameter("date"); // date là String dạng "yyyy-mm-dd"
		java.sql.Date newDate = java.sql.Date.valueOf(date);
		String timeSlot = request.getParameter("timeSlot");
		int table = Integer.parseInt(request.getParameter("table"));
		
		System.out.println(timeSlot + " " + date);
		//khách hàng
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		// lưu khách hàng
		Customer681 customer = new Customer681(name, address, email, phone);
		int customerID = CustomerDAO681.saveCustomer681(customer); //lưu customer
		System.out.println( name + " " + address + " " + email + " " + phone + " " + customerID);
		tableReservation681 tableReservation = new tableReservation681(timeSlot, newDate, "NO", "online", customerID);
		
		//lưu bàn đặt
		int reservationID = -1;
		boolean isSuccess = false; //biến kiểm tra lưu thành công
		try {
			reservationID = tableReservationDAO681.saveTableReservation681(tableReservation);
			System.out.println(table + " " + reservationID);
			
			if(isSuccess) { //nếu lưu thành công tableReseravation, ta lưu tableReseravationDetail
				tableReservationDAO681.saveTableReservationDetail681(table, reservationID);
				isSuccess = true;
				
			}
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		}
		if (isSuccess) {
	        request.setAttribute("message", "Lưu thành công");
	    } else {
	        request.setAttribute("message", "Lưu thất bại");
	    }
		request.getRequestDispatcher("/WEB-INF/customer/gdDatBan681.jsp").forward(request, response);
	}

}
