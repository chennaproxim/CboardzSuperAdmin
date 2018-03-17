package com.cboadz.app.cboardzsuperadmin.Utils;

/**
 * Created by PROXIM on 6-01-2018.
 */
public class AppConstants {

    //SuperAdmin API
    public static String ADMIN_LOGIN_URL = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/login";
    public static String COMPANYALLLIST = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/companylist";
    public static String CREATECOMPANY = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/company";
    public static String COMPANYPROFILE = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/companyview";
    public static String COMPANYEDIT = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/companyedit";
    public static String NOTICESLIST = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/notices";
    public static String VIEWNOTICE = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/viewnotice";
    public static String NOTICEREPLY = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/addnoticeconversation";
    public static String ADDNOTICE = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/addnotice";


    //Company API'// STOPSHIP: 3/5/2018
    public static String EMPLIST = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/employeeslist";
    public static String CREATEEMPLOYEE = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/employee";
    public static String EMPLOYEEPROFILE = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/employeeview";
    public static String CREATEDEPARTMENT = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/department";
    public static String DEPARMENTLIST = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/departmentlist";
    public static String CREATEBUSINESSHEAD = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/businesshead";
    public static String BUSINESSHEADLIST = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/businessheadlist";
    public static String BUSINESSDEPARTMENTLIST = "http://ec2-13-127-133-170.ap-south-1.compute.amazonaws.com:9000/businessheadanddepartmentlistt";


    public static final String LOADING = "Loading...";
    public static final String CREATING = "Creating...";
    public static final String LOGING = "Logging in...";
    public static final String SENDING = "Sending...";
    public static final String UPDATING = "Updating...";
    public static final String FETCHING = "Fetching data...";
    public static final String LOGINVALIDATION = "Please enter both Username and Password";
    public static final String VALIDUSERNAME = "Please enter valid username";
    public static final String VALIDPASSWORD = "Password should be between 4 to 15 characters!";

    //SharedPrefferences
    public static final String TOKEN = "tokenkey";
    public static final String COMPANYPROFILEDATA = "companyprofiledata";

}
