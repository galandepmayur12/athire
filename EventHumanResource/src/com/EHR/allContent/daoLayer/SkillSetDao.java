package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.SkillSet;

public class SkillSetDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String query, query1;
	
	public void createSkillSet(SkillSet skillSet) throws ClassNotFoundException, IOException, SQLException {
		
		query = "insert into skill_set values(?,?,?)";
		long id;
		boolean status;
		
		con = dbConnector.getConnection();
		
		id = System.currentTimeMillis();
		
		
		do {
			status = IdCheckDao.chk(id, "skill_set", Constants.SKILL_ID);
			if(status == false) {
				id++;
			}
		}while(status != true);
		
		pst = con.prepareStatement(query);
		pst.setLong(1, id);
		pst.setString(2, skillSet.getSkill_name());
		pst.setInt(3, skillSet.getSkill_cost());
		pst.executeUpdate();
		
	}
	
	public long getSkillIdByName(String skillName) throws ClassNotFoundException, IOException, SQLException {
		query = "select " + Constants.SKILL_ID + " from skill_set where " + Constants.SKILL_NAME + " = ?";  
				
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setString(1, skillName);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			return rs.getLong(1);
		}
		
		return -1l;
				
	}
	
	public String getSkillNameById(long skillId) throws ClassNotFoundException, IOException, SQLException {
		query = "select " + Constants.SKILL_NAME + " from skill_set where " + Constants.SKILL_ID + " = ?";  
				
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, skillId);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			return rs.getString(1);
		}
		
		return null;
				
	}
	
	public SkillSet getSkillSet(long skillId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select * from skill_set where " + Constants.SKILL_ID + " = ? ";
		SkillSet skillSet = new SkillSet();
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, skillId);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			skillSet.setSkil_id(rs.getLong(1));
			skillSet.setSkill_name(rs.getString(2));
			skillSet.setSkill_cost(rs.getInt(3));
		}
		
		return skillSet;
	}
	
	public int getSkillCost(String skillName) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select " + Constants.SKILL_COST + " from skill_set where " + Constants.SKILL_NAME + " =? ";
		
		con = dbConnector.getConnection();
		pst = con.prepareStatement(query);
		pst.setString(1, skillName);
		rs = pst.executeQuery();
		while(rs.next()) {
			return rs.getInt(1);
		}
		
		return 1;
		
		
	}
	
	public boolean deleteSkillSet(long skillId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "delete from skill_set where " + Constants.SKILL_ID + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, skillId);
		int nrows = pst.executeUpdate();
		
		if(nrows > 0)
			return true;
		else
			return false;
		
	}
	
	public void updateSkillSet(long skillId, String skillName, int skillCost) throws ClassNotFoundException, IOException, SQLException {
		
		query = "update skill_set set " + Constants.SKILL_NAME + " = ?, " + Constants.SKILL_COST + " = ? where " + Constants.SKILL_ID
				 + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setString(1, skillName);
		pst.setInt(2, skillCost);
		pst.setLong(3, skillId);
		pst.executeUpdate();
		
	}
}
