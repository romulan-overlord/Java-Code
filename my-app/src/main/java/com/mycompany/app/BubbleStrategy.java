package com.mycompany.app;

public class BubbleStrategy implements Strategy{

	public double[] sort(double arr[]){
		System.out.println("In bubble sort.");
		for(int i = 0; i< arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[j] < arr[i]){
					double temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
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