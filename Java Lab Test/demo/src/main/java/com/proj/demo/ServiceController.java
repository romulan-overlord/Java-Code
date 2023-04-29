package com.proj.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.*;
import java.lang.*;


@RestController
public class ServiceController{


	//this route expects the options array to be only one of the five mentioned in the question paper. Therefore, it just gets the 0th index for the action type and if extra data is needed, it gets the 1st index.
	@PostMapping(value = "/resource")
	@ResponseBody
	public Map<String,String> service(@RequestBody Map<String,Object> input){
		System.out.println("Printing body: " + input.toString());

		StringService ob = new StringService();
		String nstr = (String)input.get("data");
		ArrayList<String> options = (ArrayList<String>)input.get("options");
		Map<String,String> response = new LinkedHashMap<String, String>();

		if(options.get(0).equals("-c")){
			nstr = ob.caseFlip(nstr, options.get(1).equals("lower"));
		}

		else if(options.get(0).equals("-e")){
			nstr = ob.encoder(nstr, Integer.parseInt(options.get(1)));
		}

		else if(options.get(0).equals("-x")){
			nstr = ob.blackListLines(nstr,options.get(1));
		}

		else if(options.get(0).equals("-a")){
			nstr = ob.char2Ascii(nstr);
		}

		else if(options.get(0).equals("-p")){
			nstr = ob.addPrefix(nstr, options.get(1));
		}

		response.put("output", nstr);
		return (response);
	}

}
