package demo.example.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;

@RestController
public class myTest {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String myTestList(){
		return "hello world";
		
		JsonArray resultjosn=
		
	}
}
