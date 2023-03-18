public class Sorter{

	Strategy strategy;

	Sorter(){
		strategy = null;
	}

	double[] sort(double arr[], Strategy strategy){
		return strategy.sort(arr);
	}

	double[] sort(double arr[]){
		return strategy.sort(arr);
	}

	void setStrategy(Strategy strategy){
		this.strategy = strategy;
	}

	void displayArr(double arr[]){
		for(int i =0; i< arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]){
		Sorter ob = new Sorter();
		ob.setStrategy(new BubbleStrategy());
		double arr1[] = {10,14,12,1,2,3,4};
		double output[] = ob.sort(arr1);
		ob.displayArr(output);
		output = ob.sort(arr1, new MergeStrategy());
		ob.displayArr(output);
		ob.setStrategy(new InsertionStrategy());
		output = ob.sort(arr1);
		ob.displayArr(output);
	}
}