import annotations.*;

@RestController(number = 10)
public class CustomController { 
	@RequestMapping
	public String method(){
		System.out.println("hello");
		return "Sairam";
	}

	@RequestMapping(invoke = true)
	public String method2(){
		System.out.println("hello2");
		return "Sairam";
	}

	@RequestMapping(myVar = "help")
	public String method3(){
		System.out.println("through help");
		return "Sairam";
	}
}