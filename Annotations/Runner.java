import java.lang.annotation.*;
import java.lang.reflect.*;
import java.lang.reflect.Field;
import annotations.*;
import sorting.*;

public class Runner{
	public String sorter() throws Throwable{
		Class<Test> controller = Test.class;
		Field[] fields = controller.getDeclaredFields();
		for(Field field : fields){
			Sort sort = field.getAnnotation(Sort.class);
			if(sort != null){
				Test objectInstance = new Test();
				Object value = field.get(objectInstance);
				System.out.println(value.type());
				String strategy = sort.strategy();
				// if(strategy.equalsIgnoreCase("merge")){
				// 	BubbleStrategy bubble = new BubbleStrategy();
				// 	bubble.sort(value);
				// }
			}
		}
		return null;
	}

	public void help() throws Throwable{
		Class  aClass = Test.class;
		Field field = aClass.getField("x");

		Test objectInstance = new Test();

		Object value = field.get(objectInstance);
	}

	public static void main(String... args){
		try{
			new Runner().sorter();
		} catch (Throwable e){

		}
		
	}

}