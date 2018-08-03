package com.DisneyResort.Disney.Disneymap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.DisneyResort.Disney.DiningReservation;
import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.ResortReservation;


public class DisneyRowMapper5 implements RowMapper<GuestProfile> {

	private GuestProfile g;

	public GuestProfile mapRow(ResultSet row, int rowNum)
			throws SQLException {
		if (g == null) {
			this.g = new GuestProfile ();
			
			g.setGuest_id(row.getInt("guest_id"));
			g.setEmail(row.getString("email"));
			g.setFirst_name(row.getString("first_name"));
			g.setLast_name(row.getString("last_name"));
			g.setPhone(row.getString("phone"));
			g.setAddress(row.getString("address"));
			g.setPassword(row.getString("password"));
			g.setCreated_date(row.getDate("created_date"));
			g.setUpdated_date(row.getDate("updated_date"));
		}
		ResortReservation resort = new ResortReservation();
		
		resort.setR_reservation_number(row.getInt("r_reservation_number"));
		resort.setGuest_id_fk(row.getInt("guest_id_fk"));
		resort.setRoom_type(row.getString("room_type"));
		resort.setArrival_date(row.getDate("arrival_date"));
		resort.setDeparture_date(row.getDate("departure_date"));
		resort.setNo_of_people(row.getInt("no_of_people"));
		resort.setStatus(row.getString("status"));
		resort.setCreated_date(row.getDate("created_date"));
		resort.setUpdated_date(row.getDate("updated_date"));
		
		DiningReservation din = new DiningReservation();
		
		din.setR_reservation_no(row.getInt("r_reservation_no"));
		din.setGuestid_fk(row.getInt("guestid_fk"));
		din.setDining_type(row.getString("dining_type"));
		din.setArrival_date(row.getDate("arrival_date"));
		din.setNo_of_people(row.getInt("no_of_people"));
		din.setStatus(row.getString("status"));
		din.setCreated_date(row.getDate("created_date"));
		din.setUpdated_date(row.getDate("updated_date"));
		
		this.g.addItem(resort);
		this.g.addItem1(din);
		return null;
	}

	public final GuestProfile getG() {
		return g;
	}

	/*public final ResortReservation getResort() {
		return resort;
	}*/	
	
}
