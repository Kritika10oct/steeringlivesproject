package com.steering.assignment.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.steering.assignment.Utility.Constants;
import com.steering.assignment.model.Employee;
import com.steering.assignment.response.Response;

public class EmployeeValidation {
	
	 public static boolean isValidPhoneNo(String phoneNo)
	    {
	        if(phoneNo== null)
	        {
	            return false;
	        }
			Pattern p = Pattern.compile("^\\d{10}$");
	        Matcher m = p.matcher(phoneNo);
	        return (m.matches());
	    }
	   // public static Boolean isvValidId(){

		//}
	
	 public static Boolean isValid(Employee newEmployee ) {
	        return isValidPhoneNo(newEmployee.getPhoneNo());
			// We can write validation for other field here.
	    }


}
