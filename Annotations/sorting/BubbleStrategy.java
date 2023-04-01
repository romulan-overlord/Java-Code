package sorting;

import java.util.*;

public class BubbleStrategy implements Strategy{

	public Object sort(Object arr){
		System.out.println("In bubble sort.");
		for(int i = 0; i< arr.size; i++){
			for(int j=i+1; j<arr.size; j++){
				if(arr.get(j) < arr.get(i)){
					int temp = arr.get(j);
					arr.set(j, arr.get(i));
					// arr.get(j) = arr.get(i);
					arr.set(i, temp);
				}
			}
		}
		return arr;
	}

	// public static void main(String args[]){
	// 	BubbleStrategy ob = new BubbleStrategy();
	// 	double arr3[] = {10,14,12,1,2,3,4};
	// 	double output[] = ob.sort(arr3);
	// 	for(int i =0; i< output.length; i++){
	// 		System.out.print(output[i] + " ");
	// 	}
	// }
}