package Kabina.DTO;

import java.util.List;

import Kabina.Model.Shelf;

public class BusinessUnitShelves {
	private long id;
	private String name;
	private List<Shelf> availableShelves;
	private long available;
	private List<Shelf> bookedShelves;
	private long booked;

	public BusinessUnitShelves(long id, String name, List<Shelf> availableShelves, List<Shelf> bookedShelves) {
		this.id = id;
		this.name = name;
		this.availableShelves = availableShelves;
		this.available = availableShelves.size();
		this.bookedShelves = bookedShelves;
		this.booked = bookedShelves.size();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
