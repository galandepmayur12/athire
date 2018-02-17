package com.EHR.allContent.resources;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.EHR.allContent.daoLayer.UserDao;

@Path("/validate")
@Produces(MediaType.TEXT_HTML)
public class ValidateResource {
	
	UserDao userDao = new UserDao();
	private static final String EMAIL_PATTERN  = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	/*
	  	^					#	start of the line
  		[_A-Za-z0-9-\\+]+	# 	must start with string in the bracket [ ], must contains one or more (+)
  		(					#   start of group #1
    	\\.[_A-Za-z0-9-]+	#   follow by a dot "." and string in the bracket [ ], must contains one or more (+)
  		)*					#   end of group #1, this group is optional (*)
    	@					#   must contains a "@" symbol
     	[A-Za-z0-9-]+    	#   follow by string in the bracket [ ], must contains one or more (+)
      	(					#   start of group #2 - first level TLD checking
       	\\.[A-Za-z0-9]+ 	#   follow by a dot "." and string in the bracket [ ], must contains one or more (+)
      	)*					#   end of group #2, this group is optional (*)
      	(					#   start of group #3 - second level TLD checking
       	\\.[A-Za-z]{2,}  	#   follow by a dot "." and string in the bracket [ ], with minimum length of 2
      	)					#   end of group #3
		$					#	end of the line
	 */
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/*
	    (				# 	Start of group
  		(?=.*\d)		#   must contains one digit from 0-9
  		(?=.*[a-z])		#   must contains one lowercase characters
  		(?=.*[A-Z])		#   must contains one uppercase characters
  		(?=.*[@#$%])	#   must contains one special symbols in the list "@#$%"
        .				#   match anything with previous condition checking
        {6,20}			#   length at least 6 characters and maximum of 20
		)				# 	End of group
	 */
	private static final String ZIPCODE_PATTERN = "^[0-9]*$";
	/*
	 This accepts valid dd/mm/yyyy, requiring leading zeros
	 */
//	private static final String DATE_PATTERN = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	private static final String DATE_PATTERN_DD = "^(3[01]|[12][0-9]|0[1-9])";
	private static final String DATE_PATTERN_MM = "(1[0-2]|0[1-9])";
	private static final String DATE_PATTERN_YYYY = "[0-9]{4}";
	
	private static final String MOB_PATTERN_PH = "^(?:(?:\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$";
	
	
	@GET
	public String fieldValidityCheck(@BeanParam ValidityBean validityBean ) throws ClassNotFoundException, IOException, SQLException {
		
		
		if (validityBean.getEmail_id() != null) {
			if (!userDao.emailCheck(validityBean.getEmail_id()))
				return "Email already exists!!";
			else if (!(validityBean.getEmail_id().matches(EMAIL_PATTERN)))
				return "Invalid Email!!";
			else
				return "";
		}else if(validityBean.getEmail_id1() != null) {
			if (userDao.emailCheck(validityBean.getEmail_id1()))
				return "Email doesn't exists!!";
			else
				return "";
		}else if(validityBean.getPassword() != null) {
			if (validityBean.getPassword().length() < 6)
				return "Too Short!! Min. 6 Characters required";
			else if (!validityBean.getPassword().matches(PASSWORD_PATTERN))
				return "Weak Password!! Password must Atleast Contain one upper and lower case(A-Z,a-z), one digit(0-9) and one special character(\"@#$%\")";
			else
				return "";
		}else if (validityBean.getZipcode() != null) {
			if (!validityBean.getZipcode().matches(ZIPCODE_PATTERN)) {
				return "zipcode only consist of numeric values 0 to 9!!";
			}
			else if (validityBean.getZipcode().length() != 6) {
				return "Invalid!!";
			}
			else
				return "";
		}else if(validityBean.getDd() != null) {
			if(!validityBean.getDd().matches(DATE_PATTERN_DD))
				return "Invalid DD format";
			else 
				return "";
		}else if (validityBean.getMm() != null) {
			if(!validityBean.getMm().matches(DATE_PATTERN_MM)) {
				return "Invalid MM format";
			}
			else 
				return "";
		} else if(validityBean.getMob() != null) {
			if((validityBean.getMob().length() < 10) || !(validityBean.getMob().matches(MOB_PATTERN_PH)))
				return "Invalid";
			else 
				return "";
		} else {
			if(!validityBean.getYyyy().matches(DATE_PATTERN_YYYY)) {
				return "Invalid YYYY format";
			}
			else 
				return "";
			
			//return null;
		}
		//return null;
		
		
//		else {
//			if (!validityBean.getDate().matches(DATE_PATTERN)) {
//				return "Invalid date!!";
//			}else {
//				return "valid";
//			}
//		}
		
	}
	
//	@GET
//	public String passwordCheck(@QueryParam("password") String password) {
//		if(password.length()<8)
//			return "Too Short!!";
//		else if(password.matches(PASSWORD_PATTERN))
//			return "Weak Password!!";
//		else
//			return "Good Password!!";
//	}
	
}
