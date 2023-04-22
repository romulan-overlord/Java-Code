package com.palindrome.practice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.*;
import com.backend.*;


@RestController
public class ServiceController{

	@PostMapping(value = "/resource", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String service(@RequestParam Map<String,String> input){
		System.out.println("Printing body: " + input.toString());
		App ob = new App();
        String str = ob.getPalindrome(input.get("string"));
		return (str);
	}
}
