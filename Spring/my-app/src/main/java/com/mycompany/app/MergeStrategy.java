package com.mycompany.app;

public class MergeStrategy implements Strategy{

	double[] merge(double arr1[], double arr2[]){
		int length = arr1.length + arr2.length;
		int index1 = 0, index2 = 0;
		double finArr[] = new double[length];

		for(int i=0; i<length; i++){
			if(index1 == arr1.length){
				finArr[i] = arr2[index2];
				index2++;
				continue;
			}
			if(index2 == arr2.length){
				finArr[i] = arr1[index1];
				index1++;
				continue;
			}
			if(arr1[index1] < arr2[index2]){
				finArr[i] = arr1[index1];
				index1++;
			}
			else{
				finArr[i] = arr2[index2];
				index2++;
			}
		}
		return finArr;
	}

	double[] mergeSort(double arr[], int start, int end){
		if(start == end){
			double retval[] = {arr[start]};
			return (retval);
		}
		int mid = (start + end) / 2;
		double temp1[] = mergeSort(arr, start, mid);
		double temp2[] = mergeSort(arr, mid+1, end);
		return(merge(temp1, temp2));
	}

	public double[] sort(double arr[]){
		System.out.println("In merge sort.");
		double finArr[] = mergeSort(arr, 0, arr.length-1);
		return (finArr);
	}

	// public static void main(String args[]){
	// 	MergeStrategy ob = new MergeStrategy();
	// 	double arr3[] = {10,14,12,1,2,3,4};
	// 	double output[] = ob.sort(arr3);
	// 	for(int i =0; i< output.length; i++){
	// 		System.out.print(output[i] + " ");
	// 	}
	// }
}