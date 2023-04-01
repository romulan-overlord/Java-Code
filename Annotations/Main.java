import java.lang.annotation.*;
import java.lang.reflect.Method;
import annotations.*;

public class Main{
	public String execute() throws Throwable {
		//reflection eqivalent of Class
		Class<CustomController> controller = CustomController.class;
		// Annotation[] annotations = controller.getDeclaredAnnotations();
		// Annotation[] annotations = controller.getAnnotationsByType(RestController.class);
		// RestController restController = controller.isAnnotationPresent(RestController.class);
		RestController restController = controller.getAnnotation(RestController.class);
		if(restController != null){
			Method[] methods = controller.getMethods();
			for(Method method : methods) {
				// boolean isann = method.isAnnotationPresent(RequestMapping.class);
				RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
				if(requestMapping.invoke()){
					if(requestMapping != null){
						method.invoke(controller.newInstance());
					}
				}
			}
		}
		
		return null;
	}

	public String execute2() throws Throwable {
		Class<CustomController> controller = CustomController.class;
		RestController restController = controller.getAnnotation(RestController.class);
		if(restController != null){
			Method[] methods = controller.getMethods();
			for(Method method : methods) {
				RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
				// if(requestMapping.myVar()){
				if(requestMapping.myVar().equals("help")){
					if(requestMapping != null){
						method.invoke(controller.newInstance());
					}
				}
			}
		}
		
		return null;
	}

	public static void main(String... args){
		try{
			new Main().execute2();
		} catch (Throwable e){

		}
		
	}

}