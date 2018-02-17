package com.EHR.allContent.daoLayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.EHR.allContent.connector.Connector;
import com.EHR.allContent.module.Constants;
import com.EHR.allContent.module.EventLog;
import com.EHR.allContent.module.Jobs;

public class JobsDao {
	
	Connector dbConnector = new Connector();
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	String query, query1, query2;
	ResultSet rs = null, rs1 = null;
	SkillSetDao skillSetDao = new SkillSetDao();
	String work_environment;
	
	public void createJobs(EventLog eventLog) throws ClassNotFoundException, IOException, SQLException {
		
		
		query = "Insert into jobs values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		long id;
		boolean status;
		
		SkillSetDao skillSetDao = new SkillSetDao();
		
		con = dbConnector.getConnection();
		
		Map<String, Integer> skillset = new HashMap<>();
		
		skillset = eventLog.getSkill_needed();
		Set<Map.Entry<String, Integer>> values = skillset.entrySet();
		int no_of_skills = values.size();
		System.out.print(no_of_skills);
		
		
		int x=0,y=0; 
		for(Map.Entry<String, Integer> contains : values ) {
			if(contains.getValue()!=0)
			x++;		
			
		}
		System.out.println("x : "+x);
		if(x == 1 ) {
			work_environment = "Individually";
		}else {
			
			work_environment = "In team";
		}
		for(Map.Entry<String, Integer> contains : values ) {
			x++;
			y=0;
			System.out.println(y);
			for (int i = 0; i < contains.getValue(); i++) {
				y++;
				id = System.currentTimeMillis();
				do {
					status = IdCheckDao.chk(id, "jobs", Constants.JOB_ID);
					if (status != true) {
						id++;
					}
				} while (status != true);
				
				if(work_environment == "Individually" && contains.getValue() != 1) {
					work_environment = "In team";
				}
				
				pst = con.prepareStatement(query);
				pst.setLong(1, id);
				pst.setString(2, contains.getKey());
//				String desc = contains.getKey() + " needed for a " + eventLog.getEvent_type() + 
//						" event on " + eventLog.getEvent_date().toString() + " at " + eventLog.getEvent_location();
				pst.setString(3, eventLog.getEvent_desc());
				pst.setLong(4, skillSetDao.getSkillIdByName(contains.getKey()));
				pst.setString(5, "Live");
				pst.setString(6, "Not Assigned");
				pst.setDate(7, Date.valueOf(eventLog.getEvent_date().toString()));
				pst.setLong(8, eventLog.getUser_id());
				pst.setLong(9, 0l);
				pst.setInt(10, skillSetDao.getSkillCost(contains.getKey()));
				pst.setLong(11, eventLog.getEvent_id());
				pst.setString(12, work_environment);
				pst.executeUpdate();
				
			}
		
		}
		
	}
	
	public Jobs getJob(long jobId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select * from jobs where " + Constants.JOB_ID + " = ?";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, jobId);
		rs = pst.executeQuery();
		while(rs.next()) {
			@SuppressWarnings("deprecation")
			com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date(rs.getDate(7).getDate(), (rs.getDate(7).getMonth())+1, (rs.getDate(7).getYear())+1);
			return new Jobs(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), 
					dt, rs.getLong(8), rs.getLong(9), rs.getInt(10),rs.getLong(11),rs.getString(12));
		}
		return null;
		
	}

//	public ArrayList<Jobs> getJobList(long skill_id) throws ClassNotFoundException, IOException, SQLException {
//		
//		query = "select * from jobs where " + Constants.JOB_SKILL + " = ?";
//		ArrayList<Jobs> job_list = new ArrayList<>();
//		
//		con = dbConnector.getConnection();
//		
//		pst = con.prepareStatement(query);
//		pst.setLong(1, skill_id);
//		rs = pst.executeQuery();
//		while(rs.next()) {
//			@SuppressWarnings("deprecation")
//			com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date(rs.getDate(7).getDate(), (rs.getDate(7).getMonth())+1, (rs.getDate(7).getYear())+1);
//			job_list.add(new Jobs(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), 
//					dt, rs.getLong(8), rs.getLong(9), rs.getInt(10), rs.getLong(11)));
//			
//		}
//		
//		return job_list;
//	}
	
	public ArrayList<Jobs> getJobList(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		ArrayList<Long> skill_id = new ArrayList<>(); 
		ArrayList<Jobs> job_list = new ArrayList<>();
		Set<Long> job_id = new HashSet<>();
		Set<Date> dates = new HashSet<>();
		
		FreeLancerDao freeLancerDao = new FreeLancerDao();
		ApplyDao applyDao = new ApplyDao();
		
		String preference;
		skill_id = freeLancerDao.getAllSkillIdFreeLancer(userId);
		job_id = applyDao.allApplicationJobId(userId);
		
				System.out.println(skill_id.toString());
		query1 = "select slot from freelancer_schedule where " + Constants.FREELANCER_ID + " = ?";
		
		String freelancer_work_environment = freeLancerDao.getWorkEnvironment(userId);
		System.out.println(freelancer_work_environment);
		if (freelancer_work_environment.equals("Individually")) {
			preference = "Individually";
		} else if(freelancer_work_environment.equals("In team")) {
			preference = "In team";
		} else {
			preference = "%";
		}
		
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query1);
		pst.setLong(1, userId);
		rs1 = pst.executeQuery();
		while(rs1.next()) {
			dates.add(rs1.getDate(1));
		}
		
		System.out.println(dates.toString());
		for (long skillId : skill_id) {
			query = "select * from jobs where " + Constants.JOB_SKILL + " = ? and " + Constants.ASSIGN_STATUS + " =\'Not Assigned\' and " + Constants.WORK_ENVIRONMENT + " Like '" + preference + "'";
			//job_list = new ArrayList<>();
			
			
			pst = con.prepareStatement(query);
			pst.setLong(1, skillId);
			
			//pst.setString(2, preference);
			rs = pst.executeQuery();
			while (rs.next()) {
				@SuppressWarnings("deprecation")
				com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date(rs.getDate(7).getDate(),
						(rs.getDate(7).getMonth()) + 1, (rs.getDate(7).getYear()) + 1900);
						System.out.println("avai jobs:" + rs.getDate(7).toString());
				//System.out.println(dates.add(rs.getDate(7)));
				if (dates.add(rs.getDate(7)) && job_id.add(rs.getLong(1))) {
					//System.out.println(dates.add(rs.getDate(7)));
					job_list.add(new Jobs(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4),
							rs.getString(5), rs.getString(6), dt, rs.getLong(8), rs.getLong(9), rs.getInt(10),
							rs.getLong(11),rs.getString(12)));
//					System.out.println(job_list.toString());
				}

			} 
		}
//		System.out.println(job_list.toString());
		return job_list;
	}
	
	public ArrayList<Jobs> getUserJobs(long userId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "select * from jobs where " + Constants.FREELANCER_ID + " = ? order by " + Constants.DATE;
		ArrayList<Jobs> job_list = new ArrayList<>();
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, userId);
		rs = pst.executeQuery();
		while(rs.next()) {
			@SuppressWarnings("deprecation")
			com.EHR.allContent.module.Date dt = new com.EHR.allContent.module.Date(rs.getDate(7).getDate(), (rs.getDate(7).getMonth())+1, (rs.getDate(7).getYear())+1900);
			job_list.add(new Jobs(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6), 
					dt, rs.getLong(8), rs.getLong(9), rs.getInt(10), rs.getLong(11), rs.getString(12)));
//			System.out.println("yig" + job_list.toString());
		}
		
		return job_list;
	}
	
	public boolean deleteJobs(long job_id) throws ClassNotFoundException, IOException, SQLException {
		
		query = " delete from jobs where " + Constants.JOB_ID + " = ?  ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, job_id);
		int n_rows = pst.executeUpdate();
		
		if(n_rows > 0)
			return true;
		return false;
	}
	
	public void updateJobs(Jobs jobs, long jobId) throws ClassNotFoundException, IOException, SQLException {
		
		query = "update jobs set " + Constants.JOB_TITLE + " = ?," + Constants.JOB_DESC + " = ?," + Constants.STATUS
				 + " = ?, " + Constants.ASSIGN_STATUS + " = ?," + Constants.DATE + " = ? where " + Constants.JOB_ID + " =? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setString(1, jobs.getJob_title());
		pst.setString(2, jobs.getJob_desc());
		pst.setString(3, jobs.getStatus());
		pst.setString(4, jobs.getAssign_status());
		pst.setDate(5, Date.valueOf(jobs.getDate().toString()));
		pst.setLong(6, jobId);
		pst.executeUpdate();
	}
	
	public long getAllotedUserId(long jobId) throws ClassNotFoundException, IOException, SQLException {
		query = "select " + Constants.FREELANCER_ID + " from jobs where " + Constants.JOB_ID + " =? ";
		
		con = dbConnector.getConnection();
		
		pst = con.prepareStatement(query);
		pst.setLong(1, jobId);
		rs = pst.executeQuery();
		while(rs.next()) {
			return rs.getLong(1);
		}
		return -1l;
		
	}
}
