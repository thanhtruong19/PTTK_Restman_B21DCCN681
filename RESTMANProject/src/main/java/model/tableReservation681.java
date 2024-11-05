package model;

import java.sql.Date;

public class tableReservation681 {
    private String timeSlot;
    private Date reservationDate;
    private String isCheckedIn;
    private String bookingType;
    private int customerID;

    // Constructor không tham số
    public tableReservation681() {
    }

	public tableReservation681(String timeSlot, Date reservationDate, String isCheckedIn, String bookingType,
			int customerID) {
		this.timeSlot = timeSlot;
		this.reservationDate = reservationDate;
		this.isCheckedIn = isCheckedIn;
		this.bookingType = bookingType;
		this.customerID = customerID;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	

	public String getIsCheckedIn() {
		return isCheckedIn;
	}

	public void setIsCheckedIn(String isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	
    // Constructor có tham số
    
}
