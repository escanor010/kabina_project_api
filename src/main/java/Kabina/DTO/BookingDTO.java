package Kabina.DTO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingDTO {
	private long bookingId;
	private long floor;
	private String positionNumber;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date bookingDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date createdAt;
	
	public BookingDTO(long bookingId, long floor, String positionNumber, java.util.Date createdAt, java.util.Date bookingDate) {
		this.bookingId = bookingId;
		this.floor = floor;
		this.positionNumber = positionNumber;
		this.createdAt = (Date) createdAt;
		this.bookingDate = (Date) bookingDate;
	}

	public long getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	public long getFloor() {
		return floor;
	}
	
	public void setFloor(long floor) {
		this.floor = floor;
	}
	
	public String getPositionNumber() {
		return positionNumber;
	}
	
	public void setPositionNumber(String positionNumber) {
		this.positionNumber = positionNumber;
	}
	
	public Date getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
