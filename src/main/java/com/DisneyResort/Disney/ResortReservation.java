package com.DisneyResort.Disney;


import java.util.Date;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class ResortReservation {
	
	
	  private int r_reservation_number;
	  
	 
	  private int guest_id_fk; 
	  
	  @NotNull
	  @Size(min=6, max=50, message="room_type should have atleast 6 characters") 
	  private String room_type; 
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date arrival_date; 
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date departure_date;
	  
	  @NotNull
	  private int no_of_people ;
	  
	  @NotNull
	  @Size(min=6, max=10, message="status should have atleast 6 characters")
	  private String status;
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date created_date;
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date updated_date;
	  
	/*private List<DiningReservation> personItems = new ArrayList<DiningReservation>();
      

	public List<DiningReservation> getPersonItems() {
		return personItems;
	}


	public void setPersonItems(List<DiningReservation> personItems) {
		this.personItems = personItems;
	}


	public void addItem(DiningReservation item){
	this.personItems.add(item);
	}*/
	
	
	public int getR_reservation_number() {
		return r_reservation_number;
	}
	public void setR_reservation_number(int r_reservation_number) {
		this.r_reservation_number = r_reservation_number;
	}
	public int getGuest_id_fk() {
		return guest_id_fk;
	}
	public void setGuest_id_fk(int guest_id_fk) {
		this.guest_id_fk = guest_id_fk;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public Date getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}
	public Date getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}
	public int getNo_of_people() {
		return no_of_people;
	}
	public void setNo_of_people(int no_of_people) {
		this.no_of_people = no_of_people;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	@Override
	public String toString() {
		return "ResortReservation [r_reservation_number=" + r_reservation_number + ", guest_id_fk=" + guest_id_fk
				+ ", room_type=" + room_type + ", arrival_date=" + arrival_date + ", departure_date=" + departure_date
				+ ", no_of_people=" + no_of_people + ", status=" + status + ", created_date=" + created_date
				+ ", updated_date=" + updated_date + "]";
	}
	public ResortReservation(int guest_id_fk,String room_type,Date arrival_date,Date departure_date,int no_of_people,String status,
			Date created_date, Date updated_date) 
	{
		super();
		this.guest_id_fk = guest_id_fk;
		this.room_type = room_type;
		this.arrival_date = arrival_date;
		this.departure_date = departure_date;
		this.no_of_people = no_of_people;
		this.status = status;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}
	public ResortReservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		  

}
