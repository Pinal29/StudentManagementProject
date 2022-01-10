package appmain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import daoimpl.UserPasswordValidationDaoImpl;
import model.StudentUserDetails;
import repository.StudentLoginDetailsDaoRes;

public class StudentInterface {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***********************Hello User**********************");
		System.out.println(" ------------------Welcome to User Administration-------------------  ");
		System.out.println("*************************************************");
		System.out.println("1: SIGN UP");
		System.out.println("2: SIGN IN");
		System.out.println("3. DELETE USER");
		System.out.println("4. UPDATE USER");
		System.out.println("5: EXIT");
		System.out.println("*************************************************************");
		char ch=' ';
		StudentLoginDetailsDaoRes LoginDao=new StudentLoginDetailsDaoRes();
		UserPasswordValidationDaoImpl userdaoimpl = new UserPasswordValidationDaoImpl();
		String username,firstname,lastname,password, location, mobileno;
		do {
			System.out.println("What you do wish to check from the above list.....");
		
		
			Scanner sn=new Scanner(System.in);
			int option=sn.nextInt();
		
			switch(option)
			{
							
				case 1:System.out.println("Enter The all details required for signup....");
				
				
						System.out.println("Enter the First Name-->");
						firstname=sn.next();
						System.out.println("Enter the Last Name-->");
						lastname=sn.next();
						System.out.println("Enter the Location-->");
						location=sn.next();
						System.out.println("Enter the Username-->");
						username=sn.next();
						System.out.println("Enter the Password-->");
						password=sn.next();
						
						System.out.println("Enter the MobileNO-->");
						mobileno=sn.next();
						StudentUserDetails user=new StudentUserDetails();
						user.setFirstname(firstname);
						user.setLastname(lastname);
						user.setLocation(location);
						user.setUsername(username);
						user.setPassword(password);
						user.setMobileno(mobileno);
					LoginDao.signUp(user);
					System.out.println("Sign Up Completed Successfully.......");
					
					break;
				case 2:
					System.out.println("Enter the Username-->");
					String usern=sn.next();
					System.out.println("Enter the Password-->");
					String pass=sn.next();
					boolean n = userdaoimpl.isValidPassword(pass);
			          if(n == true){
			              System.out.println("It is a valid password");
			          }
			          else {
			              System.out.println("It is not a valid password");
			          }
					StudentUserDetails details=new StudentUserDetails();
					details.setUsername(usern);
					details.setPassword(pass);
					boolean res=LoginDao.signIn(details);
					if(res){
						System.out.println("Login success...........");
						while(true){
					//	int studentId;
						//String studentName,phone,city;
						System.out.println("-------------------------------------------------------");
						System.out.println("*****************  Welcome to the Student Management *********************");
						System.out.println("-------------------------------------------------------");
						System.out.println("1. ADD students");
						System.out.println("2. DELETE students");
						System.out.println("3. DISPLAY students");
						System.out.println("4. UPDATE students");
						System.out.println("5. EXIT");
						System.out.println(" Please Choose Any Options:--");
						int c= sn.nextInt();
						if(c==1)
						{
							//Add student
							System.out.println("Please Enter the Roll No-->");
							int sid=sn.nextInt();
							System.out.println("Please Enter the Student Name-->");
							String sname=sn.next();
							System.out.println("Please Enter the Student Phone number-->");
							String phone=sn.next();
							System.out.println("Please Enter the Student City-->");
							String city=sn.next();
							//create studentuserdetails object
							StudentUserDetails st= new StudentUserDetails();
							st.setStudentId(sid);
							st.setStudentname(sname);
							st.setStudentPhone(phone);
							st.setStudentCity(city);
							boolean ans= LoginDao.insertStudentRecord(st);
							if(ans){
								System.out.println("Student Record Inserted Succcessfully....");
								System.out.println("Student Record:" +st);
							}
							else{
								System.out.println("Something went wrong ....");
								System.out.println("Please Try Again ....");
								
							}
							
						}
						else if(c==2)
						{
							//Delete student
							System.out.println("Enter the Student Id to Delete:->");
							int userId= Integer.parseInt(br.readLine());
							boolean f= StudentLoginDetailsDaoRes.deleteStudentRecord(userId);
							if(f){
								System.out.println("Student Id:" +userId );
								System.out.println(" Record Deleted.....");
							}
							else{
								System.out.println("Something Went Wrong ....Try Again ");
							}
						}
						else if(c==3){
							//Display Student
							StudentLoginDetailsDaoRes.showAllStudentRecord();
						}
						else if(c==4)
						{
							//Update Student Information
							System.out.println("Select Options which You Want to Update.........");
							System.out.println("1. Update Name!");
							System.out.println("2. Update Age!");
							System.out.println("3. Update Residence!");
							int val= Integer.parseInt(br.readLine());
							if(val==1){
								//Update Student Name
								System.out.println("Enter Student Id to identify student-->");
								int id=Integer.parseInt(br.readLine());
								System.out.println("Enter New Name For Student to Update....");
								String name = br.readLine();
								
								StudentUserDetails st = new StudentUserDetails();
								st.setStudentname(name);
								boolean f= StudentLoginDetailsDaoRes.updateStudentRecord(val,name,id,st);
								if(f)
								{
									System.out.println("Student Name Updated Successfully..");
								}
								else{
									System.out.println("Something Went Wrong Please ...Please try Again...");
									
								}
							}
							else if(val==2){
								//Update Student phone
								System.out.println("Enter Student Id to identify Student-->");
								int id=Integer.parseInt(br.readLine());
								System.out.println("Enter the Phone to Update....");
								String phone = br.readLine();
								
								
								StudentUserDetails st = new StudentUserDetails();
								st.setStudentPhone(phone);
								boolean f= StudentLoginDetailsDaoRes.updateStudentRecord(val,phone,id,st);
								if(f)
								{
									System.out.println("Student Phone Updated Successfully..");
								}
								else{
									System.out.println("Something Went Wrong Please ...Please try Again...");
									
								}
						
							}
							else if(val==3){
								//Update Student City
								System.out.println("Enter Student Id to identify student-->");
								int id=Integer.parseInt(br.readLine());
								System.out.println("Enter the Residence to Update....");
								String city = br.readLine();
								
								StudentUserDetails st = new StudentUserDetails();
								st.setStudentCity(city);
								boolean f= StudentLoginDetailsDaoRes.updateStudentRecord(val,city,id,st);
								if(f)
								{
									System.out.println("Student Address Updated Successfully..");
								}
								else{
									System.out.println("Something Went Wrong Please ...Please try Again...");							
								}
							}
							else{
								System.out.println("Hey You Have not updated Anything...Please choose option Correctly...");
								
							}			
						}
						else if(c==5){
							//Exit
							System.out.println("Thank You For Using ........ ");
							break;
						}
						else{
							System.out.println("Something went wrong.....Select Correct Options......");
						}
						}
				}				
					else 
						System.out.println("Login failed.....");
					break;
				case 3:
					System.out.println("Enter the User name to Delete:->");
					 username= sn.next();
				
					LoginDao.deleteUser(username);
					//if(){
						System.out.println("User Name:" +username);
						System.out.println("User Record Deleted successfully.....");
					//}
					//else{
					//	System.out.println("Something Went Wrong ....Try Again ");
					//}

					break;
				case 4:
					//Update User Information
					System.out.println("Select Options which You Want to Update.........");
					
					System.out.println("1. Update FirstName!");
					System.out.println("2. Update LastName!");
					System.out.println("3. Update Location!");
					System.out.println("4. Update UserName!");
					System.out.println("5. Update Password!");
					System.out.println("6. Update MobileNo!");
					
					int val= Integer.parseInt(br.readLine());
					if(val==1){
						//Update User First Name
						System.out.println("Enter the UserName to identify user-->");
						username=sn.next();
						System.out.println("Enter the First Name to Update....");
						String name = br.readLine();
						
						StudentUserDetails st = new StudentUserDetails();
						st.setFirstname(name);
						boolean f= LoginDao.updateUser(val,name,username,st);
						if(f)
						{
							System.out.println("User FirstName Updated Successfully..");
						}
						else{
							System.out.println("Something Went Wrong Please ...Please try Again...");
							
						}
					}
					else if(val==2){
						//Update User Last Name
						System.out.println("Enter the UserName to identify user-->");
						username=sn.next();
						System.out.println("Enter the Last Name to Update....");
						String lastname1 = br.readLine();
						
						StudentUserDetails st = new StudentUserDetails();
						st.setLastname(lastname1);
						boolean f= LoginDao.updateUser(val,lastname1,username,st);
						if(f)
						{
							System.out.println("User LastName Updated Successfully..");
						}
						else{
							System.out.println("Something Went Wrong Please ...Please try Again...");
							
						}
					}
					
					else if(val==3){
						//Update User location
						System.out.println("Enter User Name to identify User-->");
						username=sn.next();
						System.out.println("Enter the Location to Update....");
						String local = br.readLine();
						
						StudentUserDetails st = new StudentUserDetails();
						st.setLocation(local);
						boolean f= LoginDao.updateUser(val,local,username,st);
						if(f)
						{
							System.out.println("User Location Updated Successfully..");
						}
						else{
							System.out.println("Something Went Wrong Please ...Please try Again...");
							
						}
				
					}
					else if(val==4){
						//Update username
						System.out.println("Enter User Name to identify user-->");
						username=sn.next();
						System.out.println("Enter the UserName to Update....");
						String username1 = br.readLine();
						
						StudentUserDetails st = new StudentUserDetails();
						st.setUsername(username1);
						boolean f= LoginDao.updateUser(val,username1,username,st);
						if(f)
						{
							System.out.println("User UserName Updated Successfully..");
						}
						else{
							System.out.println("Something Went Wrong Please ...Please try Again...");
							
						}
						
					}
					else if(val==5){
						//Update password
						System.out.println("Enter User Name to identify User-->");
						username=sn.next();
						System.out.println("Enter the Password to Update....");
						String passw = br.readLine();
						
						StudentUserDetails st = new StudentUserDetails();
						st.setPassword(passw);
						boolean f= LoginDao.updateUser(val,passw,username,st);
						if(f)
						{
							System.out.println("User Password Updated Successfully..");
						}
						else{
							System.out.println("Something Went Wrong Please ...Please try Again...");
							
						}
						
					}
					else if(val==6){
						//Update Mobile Number
						System.out.println("Enter User Name to identify user-->");
						username=sn.next();
						System.out.println("Enter the Mobile Number to Update....");
						String mobile = br.readLine();
						
						StudentUserDetails st = new StudentUserDetails();
						st.setMobileno(mobile);
						boolean f= LoginDao.updateUser(val,mobile,username,st);
						if(f)
						{
							System.out.println("User Mobile Number Updated Successfully..");
						}
						else{
							System.out.println("Something Went Wrong Please ...Please try Again...");							
						}						
					}				
					else{
						System.out.println("Hey You Have not updated Anything...Please choose option Correctly...");					
					}				
				break;
				case 5:
					System.exit(0);
					
				default:System.out.println("----Enter the valid option----");
			}
			System.out.println("Do You Want to check other options..........");				
		ch=sn.next().charAt(0);
			
	  }while(ch=='y'||ch=='Y');
			
		}

	
	}
	



