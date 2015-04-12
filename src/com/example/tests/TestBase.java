package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected Logger log = Logger.getLogger("TEST");
	
	protected ApplicationManager app;
	
	@BeforeTest
	@Parameters({"configfile"})
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = System.getProperty("configFile");
		}
		if (configFile == null) {
			configFile = System.getenv("configFile");
		}
		if (configFile == null) {
			configFile = "application.properties";
		}
		Properties props = new Properties();
		props.load(new FileReader(new File(configFile)));
		log.info("setUp start");
		app = ApplicationManager.getInstance(props);
		log.info("setUp end");
	  }

	@AfterTest
	public void tearDown() throws Exception {
		log.info("tearDown start");
		app.stop();
		log.info("tearDown end");
	  }

}
