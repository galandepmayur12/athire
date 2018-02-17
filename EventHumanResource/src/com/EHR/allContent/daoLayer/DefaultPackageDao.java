package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.DefaultPackage;

public class DefaultPackageDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	String query, query1, query2;
	ResultSet rs = null, rs1 = null;
	SkillSetDao skillSetDao = new SkillSetDao();
	
	public boolean createDefaultPackage(DefaultPackage defaultPackage) throws ClassNotFoundException, IOException, SQLException {
		
		query = "insert into events values(?,?)";
		query1 = "insert into default_package values(?,?,?,?,?)";
		query2 = "insert into skill_needed values(?,?,?,?)";
		
		long id;
		boolean status = false;
		Map<String, Integer> skillset = new HashMap<>();
		
		con = dbConnector.getConnection();
		
		id = System.currentTimeMillis();
		
		status = IdCheckDao.chk(id, "events", Constants.EVENT_ID);
		
		do {
			if(status == false) {
				id++;
			}
			
		}while(status != true);
		
		pst = con.prepareStatement(query);
		pst.setLong(1, id);
		pst.setString(2, defaultPackage.getPackage_type());
		int affected = pst.executeUpdate();
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, id);
		pst.setString(2, defaultPackage.getEvent_name());
		pst.setString(3, defaultPackage.getPackage_type());
		pst.setString(4, defaultPackage.getEvent_desc());
		pst.setInt(5, defaultPackage.getPackage_quote());
		int affected1 = pst.executeUpdate();
		
		int affected2 = 0;
		skillset = defaultPackage.getSkill_needed();
		Set<Map.Entry<String, Integer>> values = skillset.entrySet();
		for(Map.Entry<String, Integer> contains : values ) {
			
			pst = con.prepareStatement(query2);
			pst.setLong(1, skillSetDao.getSkillIdByName(contains.getKey()));
			pst.setLong(2, id);
			pst.setString(3, contains.getKey());
			pst.setInt(4, contains.getValue());
			affected2 = pst.executeUpdate();
		}
		
		if((affected > 0) && (affected1 > 0) && affected2 > 0) {
			return true;
		}
		return false;
		
	}
	
	public DefaultPackage getDefaultPackage(long packageId) throws ClassNotFoundException, IOException, SQLException {
		
		query = " select * from default_package where " + Constants.PACKAGEID + " = ?  ";
		query1 = " select * from skill_needed where " + Constants.EVENT_ID + " = ? ";
		
		Map<String, Integer> skillset = new HashMap<>();

		
		DefaultPackage defaultpackage = new DefaultPackage();
		
		con = dbConnector.getConnection();
		pst = con.prepareStatement(query);
		pst.setLong(1, packageId);
		rs = pst.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				
				 defaultpackage.setPackageid(rs.getLong(1));
				 defaultpackage.setEvent_name(rs.getString(2));
				 defaultpackage.setPackage_type(rs.getString(3));
				 defaultpackage.setEvent_desc(rs.getString(4));
				 defaultpackage.setPackage_quote(rs.getInt(5));
			}
			
			pst = con.prepareStatement(query1);
			pst.setLong(1, packageId);
			rs1 = pst.executeQuery();
			while(rs1.next()) {

				skillset.put(rs1.getString(3), rs1.getInt(4));
			}
			
			defaultpackage.setSkill_needed(skillset);
			return defaultpackage;
		}
		
		
		
		return null; 
	}
	
	public ArrayList<DefaultPackage> getAllPackages() throws ClassNotFoundException, IOException, SQLException{
		query = " select * from default_package where " + Constants.PACKAGE_QUOTE + " > 0  ";
		query1 = " select * from skill_needed where " + Constants.EVENT_ID + " = ? ";
		
		
		DefaultPackage defaultpackage = new DefaultPackage();
		ArrayList<DefaultPackage> defaultPackages = new ArrayList<>();
		
		con = dbConnector.getConnection();
		pst = con.prepareStatement(query);
		rs = pst.executeQuery();
		
		//Map<String, Integer> skillset = new HashMap<>();
			while(rs.next()) {
				Map<String, Integer> skillset = new HashMap<>();
				 defaultpackage.setPackageid(rs.getLong(1));
				 defaultpackage.setEvent_name(rs.getString(2));
				 defaultpackage.setPackage_type(rs.getString(3));
				 defaultpackage.setEvent_desc(rs.getString(4));
				 defaultpackage.setPackage_quote(rs.getInt(5));
				 pst = con.prepareStatement(query1);
					pst.setLong(1, defaultpackage.getPackageid());
					rs1 = pst.executeQuery();
					while(rs1.next()) {

						skillset.put(rs1.getString(3), rs1.getInt(4));
					}
//					System.out.println(defaultpackage.toString());
					defaultpackage.setSkill_needed(skillset);
//					System.out.println(defaultpackage.toString());
//					defaultPackages.add(defaultpackage);
//					System.out.println(defaultpackage.toString());
					defaultPackages.add(new DefaultPackage(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), skillset, rs.getInt(5)));
//					System.out.println(defaultPackages.toString());
			}
			
//			pst = con.prepareStatement(query1);
//			pst.setLong(1, defaultpackage.getPackageid());
//			rs1 = pst.executeQuery();
//			while(rs1.next()) {
//
//				skillset.put(rs1.getString(3), rs1.getIthant(4));
//			}
//			
//			defaultpackage.setSkill_needed(skillset);
//			defaultPackages.add(defaultpackage);
		
		return defaultPackages; 
		
	}
	
	public boolean deleteDefaultPackage(long packageId) throws ClassNotFoundException, IOException, SQLException {
		
		query = " delete from events where " + Constants.EVENT_ID + " = ? " ;
		query1 = " delete from default_package where " + Constants.PACKAGEID + " = ? ";
		
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
	
	public void updateDefaultPackage(long packageId, DefaultPackage defaultPackage) throws SQLException, ClassNotFoundException, IOException {
		
		query = "update default_package set " + Constants.EVENT_NAME + " = ?, " + Constants.PACKAGE_TYPE
				+ " = ?, " + Constants.EVENT_DESC + " = ? where " + Constants.PACKAGEID + " = ? ";
		query1 = "update skill_needed set " + Constants.SKILL_ID + " = ?, " + Constants.SKILL_NAME + " = ?, "
				+ Constants.REQUIRE_NO + " = ? where " + Constants.EVENT_ID + " = ? and " + Constants.SKILL_ID + " = ?";
		
		Map<String, Integer> skillset = new HashMap<>();
		
		con =dbConnector.getConnection();
	
		pst = con.prepareStatement(query);
		pst.setString(1, defaultPackage.getEvent_name());
		pst.setString(2, defaultPackage.getPackage_type());
		pst.setString(3, defaultPackage.getEvent_desc());
		pst.setLong(4, packageId);
//		int nrows = 
		pst.executeUpdate();
		
		skillset = defaultPackage.getSkill_needed();
		Set<Map.Entry<String, Integer>> values = skillset.entrySet();
		for(Map.Entry<String, Integer> contains : values ) {
			
			pst = con.prepareStatement(query1);
			pst.setLong(1, skillSetDao.getSkillIdByName(contains.getKey()));
			pst.setString(2, contains.getKey());
			pst.setInt(3, contains.getValue());
			pst.setLong(4, packageId);
			pst.setLong(5, skillSetDao.getSkillIdByName(contains.getKey()));
			pst.executeUpdate();
		}
		
	}
		
}
