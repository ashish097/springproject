package com.DisneyResort.Disney.Disneymap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.DisneyResort.Disney.DiningReservation;


public class DisneyRowMapper3 implements RowMapper<DiningReservation> {

	@Override
	public DiningReservation mapRow(ResultSet row, int rowNum) throws SQLException {
		
		DiningReservation g = new DiningReservation();
        
	    g.setR_reservation_no(row.getInt("r_reservation_no"));
		g.setGuestid_fk(row.getInt("guestid_fk"));
		g.setDining_type(row.getString("dining_type"));
		g.setArrival_date(row.getDate("arrival_date"));
		g.setNo_of_people(row.getInt("no_of_people"));
		g.setStatus(row.getString("status"));
		g.setCreated_date(row.getDate("created_date"));
		g.setUpdated_date(row.getDate("updated_date"));
		
		return g;
	}

}
