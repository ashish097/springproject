package com.DisneyResort.Disney;

import java.util.Date;

/*import javax.persistence.GeneratedValue;
import javax.persistence.Id;*/
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


public class DiningReservation {
	
	  
	  private int r_reservation_no;
	  
	  
	  private int guestid_fk;
	  
	  @NotNull
	  @Size(min=6, max=50, message="dining_type should have atleast 6 characters")
	  @NotBlank(message = "dining_type can't empty!")
	  private String dining_type;
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date arrival_date;
	  
	  @NotNull
	  private int no_of_people;
	  
	  @NotNull
	  @Size(min=6, max=10, message="status should have atleast 6 characters")
	  private String status;
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date created_date;
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date updated_date;
	  
	  
	public int getR_reservation_no() {
		return r_reservation_no;
	}
	public void setR_reservation_no(int r_reservation_no) {
		this.r_reservation_no = r_reservation_no;
	}
	public int getGuestid_fk() {
		return guestid_fk;
	}
	public void setGuestid_fk(int guestid_fk) {
		this.guestid_fk = guestid_fk;
	}
	public String getDining_type() {
		return dining_type;
	}
	public void setDining_type(String dining_type) {
		this.dining_type = dining_type;
	}
	public Date getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
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
	public DiningReservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiningReservation(int guestid_fk,
			String dining_type,
			Date arrival_date,int no_of_people,
			String status,
			Date created_date,Date updated_date) {
		super();
		this.guestid_fk = guestid_fk;
		this.dining_type = dining_type;
		this.arrival_date = arrival_date;
		this.no_of_people = no_of_people;
		this.status = status;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}
	  
	  
	
}
