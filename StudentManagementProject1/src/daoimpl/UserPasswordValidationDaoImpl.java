package daoimpl;

import dao.UserPasswordValidationDao;

public class UserPasswordValidationDaoImpl implements UserPasswordValidationDao  {
	
	@Override
	public  boolean isValidPassword(String password) {
		// TODO Auto-generated method stub
		if(password.matches(".*[0-9]{1,}.*") && password.matches(".*[@#$]{1,}.*") && password.length() >=6 && password.length()<=20)
		{
	        return  true;
	    }
	    else
	    {
	        return false;
	    }
		
	}

	}

	