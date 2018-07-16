package it.cws.demo.microservice.demorest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {


	@RequestMapping(value="/string", method= {RequestMethod.GET})
	public Value getString() {
		String string = LocalDateTime.now().toString();
		System.out.println(string);
		return new Value(string);
	}
}
