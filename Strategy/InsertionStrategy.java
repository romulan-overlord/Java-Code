public class InsertionStrategy implements Strategy{
  public double[] sort(double arr[]){
    System.out.println("In insertion sort.");
    int pass = 1, i = 0;
    double temp = 0;
    for(pass = 1; pass < arr.length; pass++){
      temp = arr[pass];
      for(i = pass-1; i >= 0; i--){
        if(temp >= arr[i])
          break;
        else
          arr[i+1] = arr[i];
      }
      arr[i+1] = temp;
    }
    return arr;
  }
}
