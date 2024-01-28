public class InsertionSort{

    public static void insertionSort(int array[]){
        int n = array.length;
        for(int j = 1; j < n; j++){ //j++ (j then increment) vs. ++j (incremnt then j)
            int key = array[j];
            int i = j-1;
            while( (i > -1) && ( array[i] > key)){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
            System.out.println("\nAfter Iteration " + j);
            for(int k:array){
                System.out.print(k + " ");
            }
        }
    }

    public static void main(String a[]){

        int[] arr1 ={9, 14, 3, 2, 43, 11, 58, 22};

        System.out.println("Before Insertion Sort");
        for(int i: arr1){
            System.out.print(i + " ");

        }
    }
}