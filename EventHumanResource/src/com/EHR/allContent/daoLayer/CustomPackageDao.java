package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.CustomPackage;
import com.EHR.allContent.module.SkillSet;

public class CustomPackageDao {
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	String query, query1, query2;
	ResultSet rs = null, rs1 = null;
	
	public boolean createCustomPackage(CustomPackage customPackage) throws ClassNotFoundException, IOException, SQLException {
		
		query = " insert into events values(?,?)";
		query1 = " insert into custom_package values(?,?,?,?,?,?,?)";
		query2 = " insert into skill_needed values(?,?,?,?)";
		
		long id;
		boolean status = false;
		
		Map<SkillSet, Integer> skillset = new HashMap<>();
		
		con = dbConnector.getConnection();
		
		id = System.currentTimeMillis();
		
		do {
			status = IdCheckDao.chk(id, "events", Constants.EVENT_ID);
			if(status == false)
				id++;
		}while(status != true);
		
		pst = con.prepareStatement(query);
		pst.setLong(1, id);
		pst.setString(2, customPackage.getEvent_type());
		pst.executeUpdate();
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, id);
		pst.setString(2, customPackage.getEvent_name());
		pst.setString(3, customPackage.getEvent_type());
		pst.setString(4, customPackage.getEvent_desc());
		pst.setDate(5, Date.valueOf(customPackage.getEvent_date().toString()));
		pst.setString(6, customPackage.getEvent_location());
		pst.setInt(7, customPackage.getEvent_quote());
		int affected1 = pst.executeUpdate();
		
		
		int affected2 = 1;
		skillset = customPackage.getSkill_needed();
		Set<Map.Entry<SkillSet, Integer>> values = skillset.entrySet();
		for(Map.Entry<SkillSet, Integer> contains : values ) {
			
			pst = con.prepareStatement(query2);
			pst.setLong(1, contains.getKey().getSkill_id());
			pst.setString(3, contains.getKey().getSkill_name());
			pst.setInt(4, contains.getValue());
			pst.setLong(2, id);
			affected2 = pst.executeUpdate();
			if(affected2 == 0)
				affected2 = 0;
		}
		
		if(affected1 > 0 && affected2 > 0)
			return true;
		return false;
		
	}
	
	@SuppressWarnings("deprecation")
	public CustomPackage getCustomPackage(long packageId) throws ClassNotFoundException, IOException, SQLException {
		
		query = " select * from custom_package where " + Constants.CUSTOMID + " = ?";
		query1 = " select * from skill_needed where " + Constants.EVENT_ID + " = ?" ;
		
		CustomPackage customPackage = new CustomPackage();
		com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date();
		con = dbConnector.getConnection();
		Map<SkillSet, Integer> skillset = new HashMap<>();
		SkillSet skills = new SkillSet();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, packageId);
		rs = pst.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				
				customPackage.setCustomid(rs.getLong(1));
				customPackage.setEvent_name(rs.getString(2));
				customPackage.setEvent_type(rs.getString(3));
				customPackage.setEvent_desc(rs.getString(4));
				dt.setDd(rs.getDate(5).getDate());
				dt.setMm((rs.getDate(5).getMonth())+1);
				dt.setYyyy((rs.getDate(5).getYear())+1900);
				customPackage.setEvent_date(dt);
				customPackage.setEvent_location(rs.getString(6));
			}
			pst = con.prepareStatement(query1);
			pst.setLong(1, packageId);
			rs1 = pst.executeQuery();
			while(rs1.next()) {

				skillset.put(new SkillSet(rs1.getLong(1), rs1.getString(3), 0), rs1.getInt(4));
				System.out.println(skills.toString());
			}
			Set<Map.Entry<SkillSet, Integer>> values = skillset.entrySet();
			for(Map.Entry<SkillSet, Integer> contains : values ) {
				System.out.println(contains.getKey().toString() + " | " + contains.getValue());
			}
			
			
			customPackage.setSkill_needed(skillset);
			return customPackage;
		}
		
		
		
		return null;
		
	}
	
public boolean deleteCustomPackage(long packageId) throws ClassNotFoundException, IOException, SQLException {
		
		query = " delete from events where " + Constants.EVENT_ID + " = ? " ;
		query1 = " delete from custom_package where " + Constants.CUSTOMID + " = ? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, packageId);
		int nrows = pst.executeUpdate();
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, packageId);
		int nrows1 = pst.executeUpdate();
		
		if(nrows > 0 && nrows1 >0) {
			return true;
		}
	
		return false;
	}


public boolean updateCustomPackage(long packageId, CustomPackage customPackage) throws SQLException, ClassNotFoundException, IOException {
	
	query = "update custom_package set " + Constants.EVENT_NAME + " = ?, " + Constants.EVENT_TYPE
			+ " = ?, " + Constants.EVENT_DESC + " = ?, " + Constants.EVENT_DATE + " = ?," 
			+ Constants.EVENT_LOCATION + " = ? where " + Constants.CUSTOMID + " = ? ";
	query1 = "update skill_needed set " + Constants.SKILL_ID + " = ?, " + Constants.SKILL_NAME + " = ?, "
			+ Constants.REQUIRE_NO + " = ? where " + Constants.EVENT_ID + " = ? and " + Constants.SKILL_ID + " = ?";
	
	Map<SkillSet, Integer> skillset = new HashMap<>();
	
	con =dbConnector.getConnection();
	
	pst = con.prepareStatement(query);
	pst.setString(1, customPackage.getEvent_name());
	pst.setString(2, customPackage.getEvent_type());
	pst.setString(3, customPackage.getEvent_desc());
	pst.setDate(4, Date.valueOf(customPackage.getEvent_date().toString()));
	pst.setString(5, customPackage.getEvent_location());
	pst.setLong(6, packageId);
	int nrows =	pst.executeUpdate();
	
	int nrows1 = 1;
	skillset = customPackage.getSkill_needed();
	Set<Map.Entry<SkillSet, Integer>> values = skillset.entrySet();
	for(Map.Entry<SkillSet, Integer> contains : values ) {
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, contains.getKey().getSkill_id());
		pst.setString(2, contains.getKey().getSkill_name());
		pst.setInt(3, contains.getValue());
		pst.setLong(4, packageId);
		pst.setLong(5, contains.getKey().getSkill_id());
//		System.out.println(query1);
		nrows = pst.executeUpdate();
		if(nrows1 == 0)
			nrows1 = 0;
	}
		if(nrows > 0 && nrows1 > 0)
			return true;
		else 
			return false;
	
}
	
}
