package emailapp;

import java.io.InputStream;
import java.util.Scanner;

public class Email
{
	String firstname;
	String lastname;
	String email;
	String password;
	String 	department;
	
	int defaultPl=10;
	int mailboxcapacity=100;
	String alternateemail;
	String companysuffix="anycompany.com";

	//first name and last name 
	public Email(String firstname,String lastname)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		System.out.println("Email Created "+this.firstname+" "+this.lastname);

		//call a method asking for dept.
		this.department=setDepartment();
		System.out.println("Departmrnt: "+this.department);

		//call a method that return random password.
		this.password=randomPassword(defaultPl);
		System.out.println("Your password: "+this.password);

		//combine elements to generate email
		email=firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department+"."+companysuffix;
		System.out.println("Your email is: "+email);

	}
	// ask for dept.
	private String setDepartment()
	{
		System.out.print("Enter the department code:\n 0 for none \n 1 for sales \n 2 for development \n 3 for accounting ");
		Scanner in=new Scanner(System.in);
		int deptChoice=in.nextInt();

		if(deptChoice==1) {return "sales";}
		else if(deptChoice==2) {return "development" ;}
		else if(deptChoice==3) {return "accounting";}
		else {return "none";}

	}
	
	// generate random password
	private String randomPassword(int length)
	{
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()[]";
		char password[]=new char[length];

		for(int i=0;i<length;i++)
		{
			int rand=(int )(Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	//Set mailbox capacity

	public void setMailBoxCapacity(int capacity)
	{
		this.mailboxcapacity=capacity;
	}
	//set alternate email
	public void setAlternateEmail(String altEmail)
	{
		this.alternateemail=altEmail;
	}
	//Change the password.
	public void changePassword(String password)
	{
		this.password=password;
	}
	public int getMailBoxCapacity(){return mailboxcapacity;}

	public String getAlternateEmail(){return alternateemail;}

	public String getPassword(){return password;}

	public String showInfo()
	{
		return "Display Name: "+firstname+" "+lastname+"\n"+"Company Email: "+email+"\n"+"Mailbox Capacity: "+mailboxcapacity;
	}

}