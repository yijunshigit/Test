package demo.example.test;

import java.io.IOException;
import java.util.ResourceBundle;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.example.server.CreateSession;


public class GetNoteTep {
	
	public CreateSession creat;
	
	@BeforeTest
	public void login() {
		
		creat=new CreateSession();		
	}
	
	
	
	@Test
	public void getNoteTemple() throws ClientProtocolException, IOException {

		ResourceBundle bundle = ResourceBundle.getBundle("properties");

		String uri = bundle.getString("bj01url");

		String url = uri + "/spa1/agent_note_templates?category=call";

		String result = creat.getWithCookie(url, creat.getSign());

		System.out.println(result);

	}
	
	@Test
	public void getCalloutTask() {
		
		ResourceBundle bundle = ResourceBundle.getBundle("properties");

		String uri = bundle.getString("bj01url");

		String url = uri + "/spa1/callcenter_callout_tasks?only_own=true&page=1";

		String result = creat.getWithCookie(url, creat.getSign());
		
		System.out.println(result);
	}
	
}

