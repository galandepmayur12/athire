package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Address;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.Credentials;
import com.EHR.allContent.module.Name;
import com.EHR.allContent.module.SkillSet;
import com.EHR.allContent.module.User_FreeLancer;
import com.EHR.allContent.resources.Mailer;

public class FreeLancerDao {
	
//	User_FreeLancer user_freelancer = new User_FreeLancer();
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs,rs1,rs2,rs3;
	String query,query1,query2,query3,query4;
	ArrayList<Long> ph = new ArrayList<>();
	SkillSet sSet = new SkillSet();
	ArrayList<SkillSet> skill_list = new ArrayList<>();
	SkillSetDao skillSetDao = new SkillSetDao();
	
	public boolean createFreeLancer(User_FreeLancer user_freelancer) throws ClassNotFoundException, IOException, SQLException {
		
//		query = "insert into freelancer (" + Constants.FREELANCER_ID + "," + Constants.F_NAME + "," + Constants.M_NAME + "," + Constants.L_NAME + "," + Constants.EMAIL_ID
//				+ "," + Constants.DOB + "," + Constants.WORK_ENVIRONMENT + ") values(?,?,?,?,?,?,?)";
		query = "insert into freelancer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		query1 = "insert into phone_no values(?,?,?)";
		query2 = "insert into users values(?,?,?)";
		query3 = " insert into has_skill values(?,?,?,?)";
		
		CredentialDao credentialDao = new CredentialDao();
		
		con = dbConnector.getConnection();
		boolean status = false;
		ph = user_freelancer.getPh_no();
		long id = System.currentTimeMillis();
		
		do {
			
			status = IdCheckDao.chk(id, "freelancer" , Constants.FREELANCER_ID);
			
			if (status != true) {
				id++;
			}
		} while (status != true);
		
		pst = con.prepareStatement(query2);
		pst.setLong(1, id);
		pst.setString(2, user_freelancer.getEmail_id());
		pst.setString(3, "freelancer");
		
		int affected = pst.executeUpdate();
		
		pst = con.prepareStatement(query);
//		System.out.println(user_freelancer.toString());
		pst.setLong(1, id);
		pst.setString(2, user_freelancer.getFreelancer_name().getF_name());
		pst.setString(3, user_freelancer.getFreelancer_name().getM_name());
		pst.setString(4, user_freelancer.getFreelancer_name().getL_name());
		pst.setString(5, user_freelancer.getEmail_id());
		pst.setDate(6, Date.valueOf(user_freelancer.getDob().toString()));
		pst.setString(7, user_freelancer.getAddress().getAdd_line1());
		pst.setString(8, user_freelancer.getAddress().getAdd_line2());
		pst.setString(9, user_freelancer.getAddress().getStreet_name());
		pst.setString(10, user_freelancer.getAddress().getCity());
		pst.setString(11, user_freelancer.getAddress().getState());
		pst.setString(12, user_freelancer.getAddress().getCountry());
		pst.setInt(13, user_freelancer.getAddress().getZipcode());
		pst.setString(14, user_freelancer.getWork_environment());
		
		int affected2 = pst.executeUpdate();
		
		for(long i: ph) {
			pst = con.prepareStatement(query1);
			pst.setLong(1, i);
			pst.setString(2, user_freelancer.getEmail_id());
			pst.setLong(3, id);
//			pst.addBatch();
			pst.executeUpdate();
		}
//		pst.executeBatch();		
		pst = con.prepareStatement(query3);
		for(SkillSet s : user_freelancer.getSkills()) {
//			System.out.println(skillSetDao.getSkillIdByName(s.getSkill_name()) + "skill name: " + s.getSkill_name());
			pst.setLong(1, skillSetDao.getSkillIdByName(s.getSkill_name()));
			pst.setLong(2, id);
			pst.setString(3, s.getSkill_name());
			pst.setString(4, user_freelancer.getEmail_id());
			int sa = pst.executeUpdate();
			System.out.println(sa+"@up");
		}
		
		credentialDao.insertCredential(new Credentials(id, user_freelancer.getEmail_id(), user_freelancer.getPassword()));
		
		if(affected > 0 && affected2 > 0) {
			Mailer.send(Constants.COMPANY_EMAIL, Constants.COMPANY_PASSWORD, user_freelancer.getEmail_id(), "Welcome", "Hi," + user_freelancer.getFreelancer_name().toString() + " We are so glad you decided to try out HRS hope that u enjoy our services");
			return true;
		}
			
		return false;
	}
	
	public boolean updateFreeLancer(long userId, User_FreeLancer user_freelancer) throws ClassNotFoundException, IOException, SQLException {
		
		System.out.println("data ;" + user_freelancer.toString());
		
		query = "update freelancer set " + Constants.F_NAME + " = ? , " + Constants.M_NAME + " = ? , " +
				Constants.L_NAME + " = ? , " + Constants.DOB + " = ? , " + Constants.ADD_LINE1 + " = ? , " +
				Constants.ADD_LINE2 + " = ? , " + Constants.STREET_NAME + " = ? , " + Constants.CITY + " = ? , " +
				Constants.STATE + " = ? , " + Constants.COUNTRY + " = ? , " + Constants.ZIPCODE + " = ? , " +
				Constants.WORK_ENVIRONMENT + " = ? where " + Constants.FREELANCER_ID + " = ? " ;
		//query = " update has_skill set " + Constants.SKILL_ID;
		query1 = "delete from has_skill where " + Constants.FREELANCER_ID + " = ?";
		query2 = " insert into has_skill values(?,?,?,?)";
		query3 = "insert into phone_no values(?,?,?)";
		query4 = "delete from phone_no where " + Constants.USER_ID + " = ?";
		
		con = dbConnector.getConnection();
		pst = con.prepareStatement(query);
		 
		 pst.setString(1, user_freelancer.getFreelancer_name().getF_name());
		 pst.setString(2, user_freelancer.getFreelancer_name().getM_name());
		 pst.setString(3, user_freelancer.getFreelancer_name().getL_name());
		 pst.setDate(4, Date.valueOf(user_freelancer.getDob().toString()));
		 pst.setString(5, user_freelancer.getAddress().getAdd_line1());
		 pst.setString(6, user_freelancer.getAddress().getAdd_line2());
		 pst.setString(7, user_freelancer.getAddress().getStreet_name());
		 pst.setString(8, user_freelancer.getAddress().getCity());
		 pst.setString(9, user_freelancer.getAddress().getState());
		 pst.setString(10, user_freelancer.getAddress().getCountry());
		 pst.setInt(11, user_freelancer.getAddress().getZipcode());
		 pst.setString(12, user_freelancer.getWork_environment());
		 pst.setLong(13, userId);
			
		 int affected = pst.executeUpdate();
		 
		 pst = con.prepareStatement(query1);
		 pst.setLong(1, userId);
		 pst.executeUpdate();
		 
		 pst = con.prepareStatement(query2);
		 for(SkillSet s : user_freelancer.getSkills()) {
				System.out.println(skillSetDao.getSkillIdByName(s.getSkill_name()) + "skill name: " + s.getSkill_name());
			 	System.out.println("s"+s.toString());
				pst.setLong(1, skillSetDao.getSkillIdByName(s.getSkill_name()));
				pst.setLong(2, userId);
				pst.setString(3, s.getSkill_name());
				pst.setString(4, user_freelancer.getEmail_id());
				int sa = pst.executeUpdate();
				System.out.println(sa+"@up"+s.getSkill_name()+skillSetDao.getSkillIdByName(s.getSkill_name()));
				System.out.println(skillSetDao.getSkillIdByName(s.getSkill_name())+" , "+userId+" , "+s.getSkill_name()+" , "+user_freelancer.getEmail_id());
			}
		 int affected2 = 0;
			pst = con.prepareStatement(query4);
			pst.setLong(1, userId);
			affected2 = pst.executeUpdate();
			
			int affected3 = 0;
			
			for(long i: user_freelancer.getPh_no()) {
				pst = con.prepareStatement(query3);
				pst.setLong(1, i);
				pst.setString(2, user_freelancer.getEmail_id());
				pst.setLong(3, userId);
				System.out.println("ph_no"+i);
				affected3 = pst.executeUpdate();
//				pst.addBatch();
				System.out.println("affected"+affected3);
				if(affected3 == 0)
					affected3 = 0;
			}
			
			if ((affected > 0) && (affected2 > 0) && (affected3 > 0)) {
				return true;
			} else {
				return false;
			}
//		 System.out.println(affected + "affected");
//		 if (affected > 0) {
//			 System.out.println("up");
//			return true;
//		}
//		 return false;
		 
	}
	
	public boolean deleteFreeLancer(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		
		query = " Delete from freelancer where " + Constants.FREELANCER_ID + " = ? ";
		query1 = " Delete from users where "+ Constants.USER_ID + " = ? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		int nrows = pst.executeUpdate();
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, userId);
		int nrows1 = pst.executeUpdate();
		
		if(nrows > 0 && nrows1 > 0)
			return true;
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public User_FreeLancer getFreeLancer(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		User_FreeLancer user_freelancer = new User_FreeLancer();
		Name nm = new Name();
		Address add = new Address();
		com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date();
		query = " Select * from freelancer where " + Constants.FREELANCER_ID + " = " + userId ;
		query1 = " Select * from phone_no where " + Constants.USER_ID + " = " + userId ;
		query2 = " select * from has_skill where " +Constants.FREELANCER_ID + " = " + userId ;
		query3 = "select * from credential where " + Constants.USER_ID + " = " + userId;
		
		con = dbConnector.getConnection();
		st = con.createStatement();
		
		rs = st.executeQuery(query);
		
		if(rs != null) {
			
			while(rs.next()) {
				
				user_freelancer.setFreeLancer_id(rs.getLong(1));
				nm.setF_name(rs.getString(2));
				nm.setM_name(rs.getString(3));
				nm.setL_name(rs.getString(4));
				user_freelancer.setFreelancer_name(nm);
				user_freelancer.setEmail_id(rs.getString(5));
				dt.setDd(rs.getDate(6).getDate());
				dt.setMm((rs.getDate(6).getMonth())+1);
				dt.setYyyy((rs.getDate(6).getYear())+1900);
				user_freelancer.setDob(dt);  
				add.setAdd_line1(rs.getString(7));
				add.setAdd_line2(rs.getString(8));
				add.setStreet_name(rs.getString(9));
				add.setCity(rs.getString(10));
				add.setState(rs.getString(11));
				add.setCountry(rs.getString(12));
				add.setZipcode(rs.getInt(13));
				user_freelancer.setAddress(add);
				user_freelancer.setWork_environment(rs.getString(14));
				
			}
			
			rs1 = st.executeQuery(query1);
			while(rs1.next()) {
				ph.add(rs1.getLong(1));	
				
			}
			
			rs2 = st.executeQuery(query2);
			while(rs2.next()) {
//				sSet.setSkil_id(rs2.getLong(1));
//				sSet.setSkill_name(rs2.getString(3));
//				System.out.println("hello" + sSet.toString());
				skill_list.add(new SkillSet(rs2.getLong(1), rs2.getString(3), 0));
			}
			
			rs3 = st.executeQuery(query3);
			while(rs3.next()) {
				user_freelancer.setPassword(rs3.getString(3));
			}
			
			user_freelancer.setPh_no(ph);
			user_freelancer.setSkills(skill_list);
//			System.out.println(skill_list.toString());
			return user_freelancer;
		}
		
		return null;
		
	}
	
	public String getWorkEnvironment(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select " + Constants.WORK_ENVIRONMENT + " from freelancer where " + Constants.FREELANCER_ID + " = ? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		while(rs.next()) {
			return rs.getString(1);
		}
		
		return null;
		
		
	}
	
	public ArrayList<Long> getAllSkillIdFreeLancer(long userId) throws ClassNotFoundException, IOException, SQLException{
		
		ArrayList<Long> skillList = new ArrayList<>();
		
		query = "select " + Constants.SKILL_ID + " from has_skill where " + Constants.FREELANCER_ID + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		while(rs.next()) {
			skillList.add(rs.getLong(1));
		}
		
		return skillList;
		
	}
	
	public String getName(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select " + Constants.F_NAME + "," + Constants.L_NAME + " from freelancer where " + Constants.FREELANCER_ID + " = ? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		while(rs.next()) {
			return rs.getString(1) + " " + rs.getString(2);
		}
		
		return null;
		
		
	}
	
	public long getContact(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		query = " Select * from phone_no where " + Constants.USER_ID + " = ? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		while(rs.next()) {
			return rs.getLong(1);
		}
		
		return 0l;
		
		
	}
	
	public boolean updatePassword(long userId, String newPassword) throws ClassNotFoundException, IOException, SQLException {
		
		query = "update credential set" + Constants.PASSWORD + " = ? where " + Constants.USER_ID + " = ?";
		
		con = dbConnector.getConnection();
		pst = con.prepareStatement(query);
		pst.setString(1, newPassword);
		pst.setLong(2, userId);
		int affected = pst.executeUpdate();
		
		if(affected > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
