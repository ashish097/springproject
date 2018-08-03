package com.DisneyResort.Disney;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;





public class GuestProfile {
	 
	 
	  private int guest_id;
	  
	  
	  @NotNull
	  @Size(min=6, max=50, message="email should have atleast 6 characters")
	  private String email;	  
	  
	  @NotNull
	  @Size(min=6, max=50, message="FirstName should have atleast 6 characters")
	  private String first_name;	  
	  
	  @NotNull
	  @Size(min=6, max=50, message="LastName should have atleast 6 characters")
	  private String last_name;	  
	  
	  @NotNull
	  @Size(min=10, max=255, message="Address should have atleast 10 characters")
	  private String address; 
	  
	  @NotNull
	  @Size(min=9, max=15, message="Phone should have atleast 9 characters")
	  private String phone;
	  
	  @NotNull
	  @Size(min=6, max=20, message="Pass should have atleast 6 characters")
	  private String password;
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date  created_date;
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-mm-dd")
	  private Date updated_date;
	    
	  
	    //Resort
	    private List<ResortReservation> personItems = new ArrayList<ResortReservation>();

		public void setPersonItems(List<ResortReservation> personItems) {
			this.personItems = personItems;
		}


		public void addItem(ResortReservation item){
		this.personItems.add(item);
		}
		
		public List<ResortReservation> getPersonItems() {
			return personItems;
		}


		public List<DiningReservation> getPersonItems1() {
			return personItems1;
		}

		//Dining
		private List<DiningReservation> personItems1 = new ArrayList<DiningReservation>();

		public void setPersonItems1(List<DiningReservation> personItems) {
			this.personItems1 = personItems;
		}


		public void addItem1(DiningReservation item){
		this.personItems1.add(item);
		}


		public int getGuest_id() {
			return guest_id;
		}


		public void setGuest_id(int guest_id) {
			this.guest_id = guest_id;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getFirst_name() {
			return first_name;
		}


		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}


		public String getLast_name() {
			return last_name;
		}


		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
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
        
		
		public GuestProfile() {
			super();
			// TODO Auto-generated constructor stub
		}


		public GuestProfile(String email,String first_name,String last_name,
				String address,String phone,String password,
				Date created_date, Date updated_date) {
			super();
		
			this.email = email;
			this.first_name = first_name;
			this.last_name = last_name;
			this.address = address;
			this.phone = phone;
			this.password = password;
			this.created_date = created_date;
			this.updated_date = updated_date;
		}	
        
}
