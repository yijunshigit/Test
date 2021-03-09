package demo.example.server;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.example.moudel.User;

@RestController
public class MyPostMethod {

	@Autowired
	private SqlSessionTemplate template1;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public int addUser(@RequestBody User user){
		int result =template1.insert("addUser", user);
		return result;		
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public int upUser(@RequestBody User user) {
		return template1.update("updateUser", user);
		
	}
	
	@RequestMapping(value="/delUser",method=RequestMethod.GET)
	public int delUser(@RequestParam int id){
		return template1.delete("delUser", id);
	}
}
