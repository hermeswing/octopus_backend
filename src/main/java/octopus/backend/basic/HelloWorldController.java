package octopus.backend.basic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloWorldController {
	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	@GetMapping("/hello")
	public Map<String, Object> firstController() {
		Map<String, Object> rtnMsg = new HashMap<>();
		rtnMsg.put("message", messageSourceAccessor.getMessage("msg.wellcom"));

		return rtnMsg;
	}

}
