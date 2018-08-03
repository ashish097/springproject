package com.DisneyResort.Disney.DisneyDao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.DisneyResort.Disney.DiningReservation;
import com.DisneyResort.Disney.GuestProfile;
import com.DisneyResort.Disney.ResortReservation;
import com.DisneyResort.Disney.Disneymap.DisneyRowMapper;
import com.DisneyResort.Disney.Disneymap.DisneyRowMapper2;
import com.DisneyResort.Disney.Disneymap.DisneyRowMapper3;
import com.DisneyResort.Disney.Disneymap.DisneyRowMapper5;

@Transactional
@Repository
public class DisneyDAO implements IDisneyDAO {
	
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	private final String SQL_INSERT_GUEST  = "INSERT INTO guest_profile(email, first_name, last_name, address, phone, password, created_date, updated_date) values (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_SELECT_PASS   = "select Password from guest_profile where guest_id=?";
	private final String SQL_INSERT_RESORT = "INSERT INTO resort_reservation(guest_id_fk,room_type,arrival_date,departure_date,no_of_people,status,created_date,updated_Date) "
			+ "values(?,?,?,?,?,?,?,?)";
	private final String SQL_INSERT_DINING = "INSERT INTO dining_reservation(guestid_fk,dining_type,arrival_date,no_of_people,status,created_date,updated_Date) "
			+ "values(?,?,?,?,?,?,?)";
	
	
	
	
	
	
	
	
	
	
	
	
	
	//----------------------REGISTRATION DAO--------------------------//
	@Override
	public GuestProfile adduser(GuestProfile guest) {
		
		Object[] params = { guest.getEmail(), guest.getFirst_name(), guest.getLast_name(), guest.getAddress(),
				guest.getPhone(), guest.getPassword(), guest.getCreated_date(), guest.getUpdated_date() };
		jdbcTemplate.update(SQL_INSERT_GUEST, params);
		
		GuestProfile guest1=jdbcTemplate.queryForObject(
				"select * from guest_profile where guest_id in(select max(guest_id) from guest_profile);",
				new DisneyRowMapper());
		return guest1;
	}
	
	@Override
	public ResortReservation addresort(ResortReservation resort,int id) 
	{
		resort.setGuest_id_fk(id);;
		System.out.println(resort.toString());
		
		Object[] param = {resort.getGuest_id_fk(),resort.getRoom_type(), resort.getArrival_date(),
			resort.getDeparture_date(),resort.getNo_of_people(),resort.getStatus(),resort.getCreated_date(),resort.getUpdated_date()};
		
		jdbcTemplate.update(SQL_INSERT_RESORT,param);
		System.out.println(resort.toString());
		ResortReservation guest1=jdbcTemplate.queryForObject(
				"select * from resort_reservation where guest_id_fk in(select max(guest_id_fk) from resort_reservation);",
				new DisneyRowMapper2());
		return guest1;
       
	}



	@Override
	public DiningReservation adddining(DiningReservation dining, int customerId) 
	{
		dining.setGuestid_fk(customerId);
		System.out.println(dining.toString());
		
		Object[] param = {dining.getGuestid_fk(),dining.getDining_type(), dining.getArrival_date(),
				dining.getNo_of_people(),dining.getStatus(),dining.getCreated_date(),dining.getUpdated_date()};
		
		jdbcTemplate.update(SQL_INSERT_DINING,param);
		System.out.println(dining.toString());
		DiningReservation guest1=jdbcTemplate.queryForObject(
				"select * from dining_reservation where guestid_fk in(select max(guestid_fk) from dining_reservation);",
				new DisneyRowMapper3());
		return guest1;
	}
	
	
	
	
	
	
	
	
	
	
	//----------------------LOGIN_VALID DAO--------------------------//
	@Override
	public boolean userExists(GuestProfile user) {
		String sql = "select count(*) from guest_profile where guest_id = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, user.getGuest_id());
		
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}


	@Override
	public boolean validate(int id, String pass) {
		
		String sql = "select guest_id from guest_profile where guest_id=?";
		Object[] params1= { id };
		Object[] params = { id };
		String password = jdbcTemplate.queryForObject(SQL_SELECT_PASS,params, String.class);
		int custid = jdbcTemplate.queryForObject(sql,params1, Integer.class);
		if(pass.equals(password) && (id == custid))
		{
			return true;
		}
		return false;
		
	}
	
	@Override
	public boolean ispresent(Integer id) {
		String sql = "select count(*) from guest_profile where guest_id = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, id);
		
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}

	
	
	
	
	
	
	
	
	

	//----------------------VIEW DAO--------------------------//
	@Override
	public GuestProfile getuserbyID(Integer id) {
		String sql = "SELECT  *  FROM guest_profile INNER JOIN  resort_reservation ON resort_reservation.guest_id_fk=? and guest_profile.guest_id=? INNER JOIN "
				+ "dining_reservation ON dining_reservation.guestid_fk=? and guest_profile.guest_id=? ";
				
				
				/*"SELECT * FROM resort_reservation  "
				+ "INNER JOIN dining_reservation ON resort_reservation.guest_id_fk=? and dining_reservation.guestid_fk=?";
						*/
		Object[] param = {id,id,id,id};			
		
		//DisneyRowMapper4 mapper = new DisneyRowMapper4();
		DisneyRowMapper5 mapper = new DisneyRowMapper5();
		jdbcTemplate.query(sql, mapper,param);
		GuestProfile p = mapper.getG();
		return p;
	}
    
	
	
	
	
	
	
	
	
	
	
	//------------------------UPDATE DAO-----------------------------//
		@Override
		public GuestProfile updateuser(GuestProfile guest, int id) {
			guest.setGuest_id(id);;
			String sql = "UPDATE guest_profile set email=?,first_name=?,last_name=?,"
					+ "address=?,phone=?,password=? WHERE guest_id=?";
			
			Object[] param = {guest.getEmail(),guest.getFirst_name(),guest.getLast_name(),guest.getAddress(),guest.getPhone()
					,guest.getPassword(),guest.getGuest_id()};
			jdbcTemplate.update(sql,param);
			
			return updateuser(id);
			
		}

		@Override
		public ResortReservation updateresort(ResortReservation user, int id) {
	        user.setGuest_id_fk(id);
	        String sql = "UPDATE resort_reservation set room_type=?,arrival_date=?,"
	        		+ "departure_date=?,no_of_people=?,status=? WHERE guest_id_fk=?";
			
	        Object[] param = {user.getRoom_type(),user.getArrival_date(),user.getDeparture_date(),user.getNo_of_people(),
	        		user.getStatus(),user.getGuest_id_fk()};
	        jdbcTemplate.update(sql,param);
	        
	        return getResort(id);
		}


		@Override
		public DiningReservation upadtedining(DiningReservation user, int id) {
			user.setGuestid_fk(id);
			String sql= "UPDATE dining_reservation set dining_type=?,arrival_date=?,no_of_people=?,status=?"
					+ "WHERE guestid_fk=?";
			
			Object[] param = {user.getDining_type(),user.getArrival_date(),user.getNo_of_people(),user.getStatus(),
					user.getGuestid_fk()};
			
            jdbcTemplate.update(sql,param);
            return getDining(id);
					
		}
		
		
		
		
		
		
		
		
		
		//------------------------TEST DAO-----------------------------//

		@Override
		public Collection<GuestProfile> findall() {
			String sql="select * from guest_profile";
			DisneyRowMapper mapper = new DisneyRowMapper();
			Collection<GuestProfile> collection= jdbcTemplate.query(sql, mapper);
			return collection;
		}

		@Override
		public GuestProfile findbyId(int id) {
			String sql="select * from guest_profile where guest_id=?";
			Object[] params = {id};
			DisneyRowMapper mapper = new DisneyRowMapper();
			jdbcTemplate.query(sql, mapper, params);
			GuestProfile guest = mapper.getG();
			return guest;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//----------------------HELPER------// 
		public GuestProfile updateuser(int id) {
			Object[] param = {id};
			GuestProfile resort = jdbcTemplate.queryForObject(
					"select * from guest_profile where guest_id=?",
					new DisneyRowMapper(), param);
			return resort;
		}
			
		public ResortReservation getResort(int id) {
			Object[] param = {id};
			ResortReservation resort = jdbcTemplate.queryForObject(
					"select * from resort_reservation where guest_id_fk=?",
					new DisneyRowMapper2(),param);
			return resort;
		} 
		public DiningReservation getDining(int id) {
			Object[] param = {id};
			DiningReservation resort = jdbcTemplate.queryForObject(
					"select * from dining_reservation where guestid_fk=?",
					new DisneyRowMapper3(),param);
			return resort;
		}
			 

		
}
