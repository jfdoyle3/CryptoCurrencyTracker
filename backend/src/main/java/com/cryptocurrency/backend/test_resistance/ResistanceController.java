package com.cryptocurrency.backend.test_resistance;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin
public class ResistanceController {

	@GetMapping(path = "/resistance")
	public String resistance() {
		return "Resistance is Futile!!";
	}
}
