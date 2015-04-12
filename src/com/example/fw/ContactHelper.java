package com.example.fw;

public class ContactHelper extends HelpersBase {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5)
			.click("Add").winWaitAndActivate("Add Contact", "", 5);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12", contact.getName())
			.send("TDBEdit11", contact.getSurname());
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 5);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5)
			.click("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 5);
		Contact contact = new Contact()
			.setName(manager.getAutoItHelper().getText("TDBEdit12"))
			.setSurname(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
			.click("Cancel")
			.winWaitAndActivate("AddressBook Portable", "", 5);
		return contact;
	}

	public void selectLastContact() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5)
			.click("TListView1")
			.send("{END}{SPACE}");
	}

	public void selectAllContact() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5)
		.click("Select All");
	}

	public void deleteContact(){
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5)
		.click("Delete")
		.send("{SPACE}")
		.winWaitAndActivate("AddressBook Portable", "", 5);		
	}

}
