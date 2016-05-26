import java.util.Arrays;
import java.util.Random;

/**
 * Created by look on 16/7/15.
 */
public class QuickSort {

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int from, int to){
        if ((to - from) == 2){
            if(arr[to-1] < arr[from]){
                exchange(arr, to-1, from);
            }
        }else if ((to - from) > 2){
            int pivot = partition(arr, from, to);
            System.out.println(Arrays.toString(arr));

            System.out.println(pivot);
            quickSort(arr, from, pivot);
            quickSort(arr, pivot+1, to);
        }

    }

    private static void exchange(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int partition(int[] arr, int from, int to){
        System.out.println("from:"+from+" to:"+to);
        int first = arr[from];
        int num = from;
        for (int i = from + 1; i< to ; i++){
            if (arr[i] < first){
                num++;
            }
        }
        int start = num;
        for (int i = from + 1 ; i< num; i++){
            if (arr[i] >= first){
                for (int j = start; j<to; j++){
                    if (arr[j] < first){
                        exchange(arr, i, j);
                        break;
                    }
                }
            }
        }
        for (int j= start; j< to ; j++){
            if (arr[j] < first){
                int temp = arr[j];
                arr[from] = temp;
                arr[j] = arr[num];
                break;
            }
        }
        arr[num] = first;
        return num;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i =0; i < 100; i++){
            arr[i] = Math.abs(random.nextInt()) % 1000;
        }
        System.out.println("start:"+Arrays.toString(arr));
        quickSort(arr);
        System.out.println("end:"+Arrays.toString(arr));
    }
}
