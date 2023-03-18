package com.proj.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.mycompany.app.*;


@RestController
public class ServiceController{

	@RequestMapping("/resource")
	public String service(){
		Test ob = new Test();
		String str = ob.show();
		return (str);
	}

	@RequestMapping(
		value = "/bubblesort",
		params = "arr" ,
		method = RequestMethod.GET)
	public double[] bubble_sorter(@RequestParam("arr") String body){
		String arr[] = body.split(",");
		double x[] = new double[arr.length];
		String temp = "";
		Sorter sorter = new Sorter();
		sorter.setStrategy(new BubbleStrategy());

		for(int i = 0; i < arr.length; i++){
			x[i] = Double. parseDouble(arr[i]);
		}

		double output[] = sorter.sort(x);

		for(int i = 0; i < output.length; i++){
			temp += output[i] + " ";
		}

		return(output);
	}

	@RequestMapping(
		value = "/mergesort",
		params = "arr" ,
		method = RequestMethod.GET)
	public double[] merge_sorter(@RequestParam("arr") String body){
		String arr[] = body.split(",");
		double x[] = new double[arr.length];
		Sorter sorter = new Sorter();
		sorter.setStrategy(new MergeStrategy());

		for(int i = 0; i < arr.length; i++){
			x[i] = Double. parseDouble(arr[i]);
		}
		return(sorter.sort(x));
	}
}
