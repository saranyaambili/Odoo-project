package testodoo;

import java.io.IOException;

import org.testng.annotations.Test;

import baseodoo.Odoobaseclass;
import excelodoo.Excelodoo;
import pageodoo.Odoopage;


public class Testodoo extends Odoobaseclass{
	@Test(priority = 1)
	public void signup() {
		Odoopage pg=new Odoopage(driver);
		pg.signin();
	}
	@Test(priority = 2)
	public void login() throws IOException, InterruptedException {
		
		Odoopage pg1=new Odoopage(driver);
		String excel="C:\\Users\\shilp\\OneDrive\\Desktop\\Odoo.xlsx";
		String sheet="Sheet1";
		int rowcount=Excelodoo.getrowcount(excel, sheet);
		
		for(int i=1;i<=rowcount;i++) {
			String email2=Excelodoo.setcellvalue(excel, sheet, i, 0);
			System.out.println("email id is------"+email2);
			String password2=Excelodoo.setcellvalue(excel, sheet, i,1);
			System.out.println("password is-----"+password2);
			pg1.clear();
			pg1.log(email2, password2);
			pg1.buttonclick();
			}}
	@Test(priority = 3)
	public void window() {
		Odoopage pg2=new Odoopage(driver);
		pg2.windowhandling();
	}
	@Test(priority = 4)
	public void free() {
		Odoopage pg3=new Odoopage(driver);
		pg3.startfree();
	
	}
	@Test(priority = 5)
	public void logout() {
		Odoopage pg4=new Odoopage(driver);
		pg4.quit();
	}
	}


