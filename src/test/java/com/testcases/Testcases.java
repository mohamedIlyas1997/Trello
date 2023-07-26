package com.testcases;

import org.testng.annotations.Test;

import com.base.Baseclass;
import com.pages.Login;

public class Testcases extends Baseclass {

	Login login= new Login();
	
	@Test() 
	public void signupmethod()throws Exception {
		login.logintest();
	}

	
	
	


}
