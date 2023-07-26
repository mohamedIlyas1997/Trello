package com.base;

public interface OR {

	String login = " Login Button>(//a[text()='Log in'])[1]"; 
	String emailId = " Email Id>user"; 
	String continuebtn = " Contine button>login"; 
	String password = " Password>//input[@type='password']"; 
	String loginbtn= " Log in button>//span[text()='Log in']"; 
	String createboard= " Create button>//span[text()='Create new board']";
	String boardtext= " Text field>//input[@type='text']";
	String createbtn= " Create button>//button[text()='Create']";
	String listname1= " Created 1st list>//input[@type='text']";
	String addlist1= " Added 1st list>//input[@value='Add list']";
	String listname2= " Created 1st list>//input[@type='text']";
	String addlist2= " Added 1st list>//input[@value='Add list']";
	String xbutton= " X button>//a[@aria-label='Cancel list editing']";
	String ListAfield = " List A>(//div[@class='js-list list-wrapper list-wrapper-with-margins'])[1]";
	String ListBfield = " List A>(//div[@class='js-list list-wrapper list-wrapper-with-margins'])[2]";
	String accountbtn= " Account button>(//button[@type='button'])[11]";
	String logout= " Logout button>//span[text()='Log out']";
	
	
}

