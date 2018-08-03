package com.DisneyResort.Disney.Disneymap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.DisneyResort.Disney.ResortReservation;

public class DisneyRowMapper2 implements RowMapper<ResortReservation> {

	@Override
	public ResortReservation mapRow(ResultSet row, int rowNum) throws SQLException {
		ResortReservation g = new ResortReservation();
        
	    g.setR_reservation_number(row.getInt("r_reservation_number"));
		g.setGuest_id_fk(row.getInt("guest_id_fk"));
		g.setRoom_type(row.getString("room_type"));
		g.setArrival_date(row.getDate("arrival_date"));
		g.setDeparture_date(row.getDate("departure_date"));
		g.setNo_of_people(row.getInt("no_of_people"));
		g.setStatus(row.getString("status"));
		g.setCreated_date(row.getDate("created_date"));
		g.setUpdated_date(row.getDate("updated_date"));
		
		return g;
	}

}
