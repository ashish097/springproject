package com.DisneyResort.Disney.Disneymap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.DisneyResort.Disney.GuestProfile;

public class DisneyRowMapper implements RowMapper<GuestProfile> {

	private GuestProfile g;
	@Override
	public GuestProfile mapRow(ResultSet row, int rowNum) throws SQLException {
		 g = new GuestProfile();

		g.setGuest_id(row.getInt("guest_id"));
		g.setEmail(row.getString("email"));
		g.setFirst_name(row.getString("first_name"));
		g.setLast_name(row.getString("last_name"));
		g.setPhone(row.getString("phone"));
		g.setPassword(row.getString("password"));
		g.setAddress(row.getString("address"));
		g.setCreated_date(row.getDate("created_date"));
		g.setUpdated_date(row.getDate("created_date"));
		return g;
	}
	public GuestProfile getG() {
		return g;
	}
    
}
