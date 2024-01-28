public class ReverseArray{
    public static void main(String[] args){

        int [] arr = {10, 20, 3000, 40, 50};
        reverse(arr, arr.length);
        int [] arr2 = {10, 20, 3000, 40, 50, 56, 656};

    }

    //method to reverse array
    static void reverse (int a[], int n){

        int[] b = new int[n];
        int j = n;

        //loop
        for (int i = 0 ; i < n; i++){
            b[j-1] = a[i];
            j = j -1;

        }
    }

    //print the reversed array
    System.out.println("Reversed arry is: \n");
    for (int k =0; k <n; i++){
        System.out.println(revarr[k]);
    }
}