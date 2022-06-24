package model;

public class Hotel {

	
	String roomNo, bed, roomType;
	double price;
	
	public Hotel(String roomNo) {
		this.roomNo = roomNo;
	}
	public Hotel(String roomNo, String bed, String roomType, double price) {
		super();
		this.roomNo = roomNo;
		this.bed = bed;
		this.roomType = roomType;
		this.price = price;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
