package Kabina.DTO;

import java.util.List;

import Kabina.Model.Shelf;

public class FloorShelves {
	private long floorNumber;
	private List<Shelf> availableShelves;
	private long available;
	private List<Shelf> bookedShelves;
	private long booked;

	public FloorShelves(long floorNumber, List<Shelf> availableShelves, List<Shelf> bookedShelves) {
		this.floorNumber = floorNumber;
		this.availableShelves = availableShelves;
		this.available = availableShelves.size();
		this.bookedShelves = bookedShelves;
		this.booked = bookedShelves.size();
	}
	
	public long getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(long floorNumber) {
		this.floorNumber = floorNumber;
	}

	public List<Shelf> getAvailableShelves() {
		return availableShelves;
	}
	
	public void setAvailableShelves(List<Shelf> availableShelves) {
		this.availableShelves = availableShelves;
	}
	
	public List<Shelf> getBookedShelves() {
		return bookedShelves;
	}
	
	public void setBookedShelves(List<Shelf> bookedShelves) {
		this.bookedShelves = bookedShelves;
	}

	public long getAvailable() {
		return available;
	}

	public void setAvailable(long available) {
		this.available = available;
	}

	public long getBooked() {
		return booked;
	}

	public void setBooked(long booked) {
		this.booked = booked;
	}
}
