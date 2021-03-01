package demo.example.server;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.mybatis.spring.SqlSessionTemplate;

import demo.example.util.GetScrect;

@RestController
public class MyGetMethod {
	
	@Autowired
	private SqlSessionTemplate template;

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String myGetList(){
		
		return "hello world";
		
	}

	@RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
	public Map<String, Integer> getWithParam(@RequestParam Integer start, @RequestParam Integer end) {

		Map<String, Integer> myList = new HashMap<>();
		myList.put("AAAA", 100);
		myList.put("BBBB", 200);
		myList.put("CCCC", 300);
		myList.put("DDDD", 400);

		return myList;
	}
	
	@RequestMapping(value = "/getscrect", method = RequestMethod.GET)
	public String getScrec(@RequestParam String email,@RequestParam String url,@RequestParam String key) {
		GetScrect screct=new GetScrect();
		String adr=screct.getScrect(email, url, key);
		return adr;
	}
	
	@RequestMapping(value="/getUserCount", method=RequestMethod.GET)
	
	public int getUserCount(){		
		return template.selectOne("getUserCount");
	}


}
