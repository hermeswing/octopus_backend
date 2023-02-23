package octopus.backend.basic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/hello")
	public Map<String, Object> firstController() {
		Map<String, Object> rtnMsg = new HashMap<>();
		rtnMsg.put("message", "Hello World !!!!");

		return rtnMsg;
	}
}
