package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.DefaultPackage;
import com.EHR.allContent.module.EventLog;



public class EventLogDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null, pst1 = null;
	String query, query1, query2, query3, query4;
	ResultSet rs = null, rs1 = null;
	JobsDao jobsDao = new JobsDao();
	SkillSetDao skillSetDao = new SkillSetDao();


	
	public boolean createEventLog(long userId, EventLog eventLog) throws ClassNotFoundException, IOException, SQLException {
		
		System.out.println(eventLog.toString());
		query = " insert into events values(?,?)";
		query1 ="insert into event_log (" + Constants.EVENT_ID + "," + Constants.CLIENT_ID + "," + Constants.EVENT_NAME
				+ "," + Constants.EVENT_TYPE + "," + Constants.EVENT_DESC + "," + Constants.EVENT_DATE + "," + 
				Constants.EVENT_LOCATION + "," + Constants.EVENT_STATUS + "," + Constants.EVENT_FINAL + 
				") values(?,?,?,?,?,?,?,?,?)";
		query2 = " insert into skill_needed values(?,?,?,?)";
		query3 = "update event_log set " + Constants.EVENT_QUOTE + " = ? where " + Constants.EVENT_ID + " = ?";
		long id;
		boolean status;
		Map<String, Integer> skillset = new HashMap<>();
		
		id = System.currentTimeMillis();
		con = dbConnector.getConnection();
		do {
			status = IdCheckDao.chk(id, "events", Constants.EVENT_ID);
			if (status != true) {
				id++;
			}
		} while (status != true);
		
		pst = con.prepareStatement(query);
		pst.setLong(1, id);
		pst.setString(2, eventLog.getEvent_type());
		int affected = pst.executeUpdate();
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, id);
		pst.setLong(2, userId);
		pst.setString(3, eventLog.getEvent_name());
		
		pst.setString(4, eventLog.getEvent_type());
		pst.setString(5, eventLog.getEvent_desc());
		pst.setDate(6, Date.valueOf(eventLog.getEvent_date().toString()));
		pst.setString(7, eventLog.getEvent_location());
		pst.setString(8, "Upcoming");
		pst.setString(9, "True");
		int affected2 = pst.executeUpdate();
		
		eventLog.setEvent_id(id);

		
		int affected3 = 1;
		int cost = 0;
		skillset = eventLog.getSkill_needed();
		Set<Map.Entry<String, Integer>> values = skillset.entrySet();
		for(Map.Entry<String, Integer> contains : values ) {
			if(contains.getValue() > 0) {
				pst = con.prepareStatement(query2);
	//			System.out.println(contains.getKey().toString());
	//			Object o = contains.getKey().getSkill_id();
	//			System.out.println(o);
	//			String s =(String)o;
				pst.setLong(1, skillSetDao.getSkillIdByName(contains.getKey()));
				pst.setString(3, contains.getKey());
				pst.setInt(4, contains.getValue());
				pst.setLong(2, id);
				
				cost += contains.getValue()*(skillSetDao.getSkillCost(contains.getKey()));
				affected3 = pst.executeUpdate();
				System.out.println("cost: " + cost + "skillcost: " + skillSetDao.getSkillCost(contains.getKey()));
			}
		}
		eventLog.setUser_id(userId);
		if(eventLog.getEvent_quote() == 0) {
			cost = cost + ((cost*10)/100);
			cost = (cost/100)*100;
			pst = con.prepareStatement(query3);
			pst.setInt(1, cost);
			pst.setLong(2, id);
			pst.executeUpdate();
			eventLog.setEvent_quote(cost);
		}
		jobsDao.createJobs(eventLog);
		
		if((affected2 > 0) && (affected > 0) && affected3 > 0) {
			//Mailer.send("humanresourceservices1246@gmail.com", "miniteitb3", "mayurthetecy.12@gmail.com", "yolo", "check");
			return true;
			
		}
		return false;
	}
	
	public void createEventLog(long userId, DefaultPackage defaultPackage) {
		
	}
	
	@SuppressWarnings("deprecation")
	public EventLog getEventLog(long event_id, long userId) throws SQLException, ClassNotFoundException, IOException {
		query = " select * from event_log where " + Constants.EVENT_ID + " = ? and " + Constants.CLIENT_ID + " = ? ";
		query1 = " select * from skill_needed where " + Constants.EVENT_ID + " = ?" ;
		
		EventLog eventLog = new EventLog();
		com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date();
		con = dbConnector.getConnection();
		Map<String, Integer> skillset = new HashMap<>();
//		SkillSet skills = new SkillSet();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, event_id);
		pst.setLong(2, userId);
		rs = pst.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				
				eventLog.setEvent_id(rs.getLong(1));
				eventLog.setUser_id(rs.getLong(2));
				eventLog.setEvent_name(rs.getString(3));
				eventLog.setEvent_type(rs.getString(4));
				eventLog.setEvent_desc(rs.getString(5));
				dt.setDd(rs.getDate(6).getDate());
				dt.setMm((rs.getDate(6).getMonth())+1);
				dt.setYyyy((rs.getDate(6).getYear())+1900);
				eventLog.setEvent_date(dt);
				eventLog.setEvent_location(rs.getString(7));
				eventLog.setEvent_status(rs.getString(9));
				eventLog.setEvent_final(rs.getString(10));
				eventLog.setEvent_quote(rs.getInt(11));
			}
			pst = con.prepareStatement(query1);
			pst.setLong(1, event_id);
			rs1 = pst.executeQuery();
			while(rs1.next()) {

				skillset.put(rs1.getString(3), rs1.getInt(4));
//				System.out.println(skills.toString());
			}
//			Set<Map.Entry<SkillSet, Integer>> values = skillset.entrySet();
//			for(Map.Entry<SkillSet, Integer> contains : values ) {
//				System.out.println(contains.getKey().toString() + " | " + contains.getValue());
//			}
//			
			
			eventLog.setSkill_needed(skillset);
			return eventLog;
		}
		
		
		
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public EventLog getSingleEventLog(long event_id) throws SQLException, ClassNotFoundException, IOException {
		query = " select * from event_log where " + Constants.EVENT_ID + " = ? ";
		query1 = " select * from skill_needed where " + Constants.EVENT_ID + " = ?" ;
		
		EventLog eventLog = new EventLog();
		com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date();
		con = dbConnector.getConnection();
		Map<String, Integer> skillset = new HashMap<>();
//		SkillSet skills = new SkillSet();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, event_id);
		rs = pst.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				
				eventLog.setEvent_id(rs.getLong(1));
				eventLog.setUser_id(rs.getLong(2));
				eventLog.setEvent_name(rs.getString(3));
				eventLog.setEvent_type(rs.getString(4));
				eventLog.setEvent_desc(rs.getString(5));
				dt.setDd(rs.getDate(6).getDate());
				dt.setMm((rs.getDate(6).getMonth())+1);
				dt.setYyyy((rs.getDate(6).getYear())+1900);
				eventLog.setEvent_date(dt);
				eventLog.setEvent_location(rs.getString(7));
				eventLog.setEvent_status(rs.getString(9));
				eventLog.setEvent_final(rs.getString(10));
				eventLog.setEvent_quote(rs.getInt(11));
			}
			pst = con.prepareStatement(query1);
			pst.setLong(1, event_id);
			rs1 = pst.executeQuery();
			while(rs1.next()) {

				skillset.put(rs1.getString(3), rs1.getInt(4));
//				System.out.println(skills.toString());
			}
//			Set<Map.Entry<SkillSet, Integer>> values = skillset.entrySet();
//			for(Map.Entry<SkillSet, Integer> contains : values ) {
//				System.out.println(contains.getKey().toString() + " | " + contains.getValue());
//			}
//			
			
			eventLog.setSkill_needed(skillset);
			return eventLog;
		}
		
		
		
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public Set<EventLog> getUserEvents(long	userId) throws ClassNotFoundException, IOException, SQLException{
		
		query = "select * from event_log where " + Constants.CLIENT_ID + " = ? ORDER BY " + Constants.EVENT_ID + " ASC";
		query1 = " select * from skill_needed where " + Constants.EVENT_ID + " = ?" ;
		
		Set<EventLog> eventLogs = new HashSet<>();
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			
			Map<String, Integer> skillset = new HashMap<>();
			pst1 = con.prepareStatement(query1);
			pst1.setLong(1, rs.getLong(1));
			rs1 = pst1.executeQuery();
			while(rs1.next()) {
				
				skillset.put(rs1.getString(3), rs1.getInt(4));
//				System.out.println(skills.toString());
				
			}
			
			eventLogs.add(new EventLog(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5), 
					new com.EHR.allContent.module.Date(rs.getDate(6).getDate(), (rs.getDate(6).getMonth())+1, (rs.getDate(6).getYear())+1900), 
					rs.getString(7), rs.getString(9), rs.getString(10), skillset, rs.getInt(11)));
//			System.out.println(eventLogs.toString());
		}
		
		return eventLogs;
	}
	
	public boolean deleteEventLog(long event_id) throws ClassNotFoundException, IOException, SQLException {
		
		query = " delete from events where " + Constants.EVENT_ID + " = ? " ;
		query1 = " delete from event_log where " + Constants.EVENT_ID + " = ? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, event_id);
		int nrows = pst.executeUpdate();
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, event_id);
		int nrows1 = pst.executeUpdate();
		
		if(nrows > 0 && nrows1 >0) {
			return true;
		}
	
		return false;
	}

	public boolean updateEventLog(long event_id, EventLog eventLog) throws ClassNotFoundException, IOException, SQLException {
	
	query = " update event_log set " + Constants.EVENT_NAME + " = ? ," + Constants.EVENT_TYPE + " = ? ," +
			Constants.EVENT_DESC + " = ? ," + Constants.EVENT_DATE + " = ? ," + Constants.EVENT_LOCATION + 
			" = ? where " + Constants.EVENT_ID + " = ?";
//	query1 = "update skill_needed set " + Constants.SKILL_ID + " = ?, " + Constants.SKILL_NAME + " = ?, "
//			+ Constants.REQUIRE_NO + " = ? where " + Constants.EVENT_ID + " = ? and " + Constants.SKILL_ID + " = ?";
	query1 = "delete from skill_needed where " + Constants.EVENT_ID + " = ?";
	query2 = " insert into skill_needed values(?,?,?,?)";
	query3 = "update event_log set " + Constants.EVENT_QUOTE + " = ? where " + Constants.EVENT_ID + " = ?";
	query4 = "delete from jobs where " + Constants.EVENT_ID + " = ? and " + Constants.ASSIGN_STATUS + " = \'Not Assigned\'";
	
	Map<String, Integer> skillset = new HashMap<>();
	
	con = dbConnector.getConnection();
	
	pst = con.prepareStatement(query);
	pst.setString(1, eventLog.getEvent_name());
	pst.setString(2, eventLog.getEvent_type());
	pst.setString(3, eventLog.getEvent_desc());
	pst.setDate(4, Date.valueOf(eventLog.getEvent_date().toString()));
	pst.setString(5, eventLog.getEvent_location());
	pst.setLong(6, event_id);
	int affected = pst.executeUpdate();
	
	
	int affected2 = 1;
	skillset = eventLog.getSkill_needed();
	int cost = 0;
	skillset = eventLog.getSkill_needed();
	Set<Map.Entry<String, Integer>> values = skillset.entrySet();
	for(Map.Entry<String, Integer> contains : values ) {
		
		pst = con.prepareStatement(query2);
//		System.out.println(contains.getKey().toString());
//		Object o = contains.getKey().getSkill_id();
//		System.out.println(o);
//		String s =(String)o;
		pst.setLong(1, skillSetDao.getSkillIdByName(contains.getKey()));
		pst.setString(3, contains.getKey());
		pst.setInt(4, contains.getValue());
		pst.setLong(2, eventLog.getEvent_id());
		
		cost += contains.getValue()*(skillSetDao.getSkillCost(contains.getKey()));
		affected2 = pst.executeUpdate();
	}
	
	cost = cost + ((cost*10)/100);
	cost = (cost/1000)*1000;
	System.out.println("cost:" + cost);
	pst = con.prepareStatement(query3);
	pst.setInt(1, cost);
	pst.setLong(2, eventLog.getEvent_id());
	pst.executeUpdate();
//	Set<Map.Entry<String, Integer>> values = skillset.entrySet();
//	for(Map.Entry<String, Integer> contains : values ) {
//		
//		pst = con.prepareStatement(query1);
//		pst.setLong(1, contains.getKey().getSkill_id());
//		pst.setString(2, contains.getKey().getSkill_name());
//		pst.setInt(3, contains.getValue());
//		pst.setLong(4, event_id);
//		pst.setLong(5, contains.getKey().getSkill_id());
////		System.out.println(query1);
//		affected2 = pst.executeUpdate();
//	
//		}
		if(affected > 0 && affected2 > 0) {
			return true;
		}
		return false;
	}

}
