package com.example.tests;

import org.testng.annotations.Test;

public class TestContactDeleting extends TestBase {
	
	@Test
	public void DeleteLastContact(){
		app.getContactHelper().selectLastContact();
		app.getContactHelper().deleteContact();
	}

	@Test
	public void DeleteAllContacts(){
		app.getContactHelper().selectAllContact();
		app.getContactHelper().deleteContact();
	}

}
