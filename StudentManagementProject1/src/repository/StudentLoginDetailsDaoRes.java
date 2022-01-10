package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.MyConnection;
import model.StudentUserDetails;

public class StudentLoginDetailsDaoRes {
	Connection connection=null;
	Statement statement=null;
	ResultSet resultset=null;
	PreparedStatement pstmt;
	public StudentLoginDetailsDaoRes() throws SQLException
	{
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
	}
	
	public boolean signUp(StudentUserDetails user) throws SQLException {
		// TODO Auto-generated method stub
	
	int r=statement.executeUpdate("insert into userdetails values('"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getLocation()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getMobileno()+"')");
	if(r==1)
	{
	return true;
	}else
		return false;

	}
	public boolean signIn(StudentUserDetails user) throws SQLException {
		// TODO Auto-generated method stub
		
		
		String tuser=user.getUsername();
		String pass=user.getPassword();
		resultset=statement.executeQuery("select *from userdetails where username='"+tuser+"' and password='"+pass+"'");
		if(resultset.next())
		{
		return true;
		}else
			return false;
		/*while(resultset.next())
		{
			user.setUsername(resultset.getString(1));
			user.setPassword(resultset.getString(2));
			
		}
			if((tuser.equals(" "))&&(pass.equals(" ")))
		{
				System.out.println("UserName & Password are Valid....");
		       return true;
		}else
		{
			System.out.println("Invalid UserName and Password...");
		}*/
	
	}
	public boolean deleteUser(String username)
	{       //getUsername();
	      try{
		  String sql = "delete from userdetails where username=?";
		  PreparedStatement pstmt= connection.prepareStatement(sql);
		  //set the value of parameters
		   pstmt.setString(1,username); 
		   //execute
		   pstmt.executeUpdate();
	      }catch(Exception e){
	      
	      }
	      return false;
       }
  public boolean updateUser(int val,String toUpdate,String usernames,StudentUserDetails s)
  {
	  boolean f = false;
		try
		{
			 Connection connection= MyConnection.getConnection();
			 if(val==1)
			 {
				 //Update User first Name
				 String query = "update userdetails set firstname =? where username=?";
				PreparedStatement pstmt= connection.prepareStatement(query);
				 pstmt.setString(1, toUpdate);
				 pstmt.setString(2, usernames);
				 //execute
				 pstmt.executeUpdate();
				 f=true;
			 }
			 else if(val==2){
				 //Update User last name
				 String query = "update userdetails set lastname=? where username=?";
				PreparedStatement pstmt= connection.prepareStatement(query);
				 pstmt.setString(1, toUpdate);
				 pstmt.setString(2, usernames);
				 //execute
				 pstmt.executeUpdate();
				 f=true;

			 }
			 else if(val==3){
				 //Update User location
			 String query = "update userdetails set location=? where username=?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			 pstmt.setString(1, toUpdate);
			 pstmt.setString(2, usernames);
			 //execute
			 pstmt.executeUpdate();
			 f=true;
			 }
			 else if(val==3){
				 //Update User UserName
			 String query = "update userdetails set username=? where username=?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			 pstmt.setString(1, toUpdate);
			 pstmt.setString(2, usernames);
			 //execute
			 pstmt.executeUpdate();
			 f=true;
			 }
			 else if(val==4){
				 //Update User Password
			 String query = "update userdetails set password=? where username=?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			 pstmt.setString(1, toUpdate);
			 pstmt.setString(2, usernames);
			 //execute
			 pstmt.executeUpdate();
			 f=true;
			 }
			 else if(val==5){
				 //Update User Mobileno
			 String query = "update userdetails set mobile_no=? where username=?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			 pstmt.setString(1, toUpdate);
			 pstmt.setString(2, usernames);
			 //execute
			 pstmt.executeUpdate();
			 f=true;
			 }
			
			 else{
				 
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
	return f;

  }
  /*public  int isValidPassword(String pass)
  {
	   //check valid password
	   if(pass.matches(".*[0-9]{1,}.*")&& pass.matches(".*[@#$]{1,}.*")
			   && pass.length()>=6 && pass.length()<=20)
	   {
		   return 1;
	   }
	   else
	   {
		   return -1;
	   }
	
  }*/
      public  boolean insertStudentRecord(StudentUserDetails st)
      { 	  
    		   Connection con= MyConnection.getConnection();
    		   System.out.println("Connection Establish");
    		   
    		   
    		   try{
    			int r=statement.executeUpdate("insert into studentab values("+st.getStudentId()+",'"+st.getStudentname()+"','"+st.getStudentPhone()+"','"+st.getStudentCity()+"')");
    			if(r==1)
    			{
    			return true;
    			}else
    				return false;  
    		   }catch(Exception e){
    			   System.out.println(e.getMessage());
    		   }
    		   return false;
    		   }
      
     
    			

    		  /* String query = "insert into studentab values(?,?,?,?);";
    		 PreparedStatement  pstmt= con.prepareStatement(query);
    		 //set the values of parameters
    		   pstmt.setInt(1, st.getStudentId()); 
    		   pstmt.setString(2, st.getStudentname()); 
    		   pstmt.setString(3, st.getStudentPhone()); 
    		   pstmt.setString(4, st.getStudentCity()); 
    		   //execute
    		  pstmt.execute();
    		 // System.out.println("Adding record successfully..");
    		  /* if(query==1){
    		   f=true;
    		   }else{
    			   return false;
    		   }*/
    	
      public static boolean deleteStudentRecord(int userId)
      {
    	  boolean f= false;
    	  try{
    		   Connection con = MyConnection.getConnection();
    		   String query = "delete from studentab where sid=?";
    		  PreparedStatement pstmt= con.prepareStatement(query);
    		  //set the value of parameters
    		   pstmt.setInt(1, userId); 
    		   //execute
    		   pstmt.executeUpdate();
    		   f=true;
    		   
    	  }catch(Exception e){
    		  
    	  }
    	  return f;
      }
      public static void  showAllStudentRecord()
      {
    	  boolean f= false;
    	  try{ 
    		     Connection con=MyConnection.getConnection();
    		   String query = "select *from studentab";
    		 Statement st=con.createStatement();
    			ResultSet resultset = st.executeQuery(query);
    			 while(resultset.next()){
    				 int sid= resultset.getInt(1);
    				  String sname = resultset.getString(2);
    				  String phone= resultset.getString(3);
    				  String city= resultset.getString("scity");
    				  System.out.println(" Student Id:"+sid +"\n Student Name : "+sname +"\n Student Phone:"+phone+ "\n Student City: "+city);
    				 System.out.println("-------------------------------------------------------------------------------------");
    			 }
    		   
    	  }catch(Exception e){
    		  
    	  }
    	 
      }
	public static boolean updateStudentRecord(int val,String toUpdate,int id,StudentUserDetails s)
	{
		boolean f = false;
		try
		{
			 Connection connection= MyConnection.getConnection();
			 if(val==1)
			 {
				 //Update Student Name
				 String query = "update studentab set sname=? where sid=?";
				PreparedStatement pstmt= connection.prepareStatement(query);
				 pstmt.setString(1, toUpdate);
				 pstmt.setInt(2, id);
				 //execute
				 pstmt.executeUpdate();
				 f=true;
			 }
			 else if(val==2){
				 //Update Student Phone
				 String query = "update studentab set sphone=? where sid=?";
				PreparedStatement pstmt= connection.prepareStatement(query);
				 pstmt.setString(1, toUpdate);
				 pstmt.setInt(2, id);
				 //execute
				 pstmt.executeUpdate();
				 f=true;

			 }
			 else if(val==3){
				 //Update Student Address
			 String query = "update studentab set scity=? where sid=?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			 pstmt.setString(1, toUpdate);
			 pstmt.setInt(2, id);
			 //execute
			 pstmt.executeUpdate();
			 f=true;
			 }
			 else{
				 
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
	return f;
	}
	

}
