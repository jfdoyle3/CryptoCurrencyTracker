package com.cryptocurrency.backend.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CurrencyController {

	@Autowired
	private RetrieveCurrency itemListService;
	
// 	@GetMapping("/users/{username}/itemlist")
//	public List<ItemList> getAllItems(@PathVariable String username){
//		return itemListService.findAll();
//	}
 	@GetMapping("/itemlist")
	public List<ItemList> getAllItem(){
		return itemListService.findAll();
	}
}

