/**
 * Created by look on 16/7/8.
 */
public class FindKLargest {

    public int findKthLargest(int[] nums, int k) {
        boolean isKLargerThanHalf = k > nums.length/2;
        if (isKLargerThanHalf){
            return findKthSmallest(nums, nums.length - k+1);
        }
        int sliceLength = nums.length/k;
        int max = nums[0];
        int maxSliceStart = 0;
        int maxSliceEnd = sliceLength;
        int[] tempArray = new int[k];
        for(int n=0; n<k; n++){
            int start = n*sliceLength;
            int end = start+sliceLength;
            if (n == (k-1)){
                end = nums.length;
            }
            int maxInSlice = nums[start];
            for (int i = start+1; i< end; i++){
               if (nums[i] > maxInSlice){
                   maxInSlice = nums[i];
               }
            }
            tempArray[n]=maxInSlice;
            if  (maxInSlice > max)  {
                max = maxInSlice;
                maxSliceStart = start;
                maxSliceEnd = end;
            }
        }
        if (k == 1){
            return max;
        }
        int newArrayLength = k-2;
        newArrayLength += maxSliceEnd - maxSliceStart;
        int[] newArray = new int[newArrayLength];
        int j = 0;
        boolean maxRemoved = false;
        for (int i = maxSliceStart; i< maxSliceEnd; i++){
            if (!maxRemoved  && nums[i] == max){
                maxRemoved = true;
            }else{
                newArray[j++] = nums[i];
            }
        }
        maxRemoved = false;
        for (int i = 0; i< k; i++ ){
            if (!maxRemoved  && tempArray[i] == max){
                maxRemoved = true;
            }else{
                newArray[j++] = tempArray[i];
            }
        }
        return findKthLargest(newArray, k-1);

    }

    private int findKthSmallest(int[] nums, int k){
        boolean isKLargerThanHalf = k > nums.length/2;
        if (isKLargerThanHalf){
            return findKthLargest(nums, nums.length - k+1);
        }
        int sliceLength = nums.length/k;
        int min = nums[0];
        int minSliceStart = 0;
        int minSliceEnd = sliceLength;
        int[] tempArray = new int[k];
        for(int n=0; n<k; n++){
            int start = n;
            int end = start+sliceLength;
            if (n == (k-1)){
                end = nums.length;
            }
            int minInSlice = nums[start];
            for (int i = start+1; i< end; i++){
                if (nums[i] > minInSlice){
                    minInSlice = nums[i];
                }
            }
            tempArray[n]=minInSlice;
            if  (minInSlice < min)  {
                min = minInSlice;
                minSliceStart = start;
                minSliceEnd = end;
            }
        }
        if (k == 1){
            return min;
        }
        int newArrayLength = k-2;
        newArrayLength += (minSliceEnd - minSliceStart);
        int[] newArray = new int[newArrayLength];
        int j = 0;
        boolean minRemoved = false;
        for (int i = minSliceStart; i< minSliceEnd; i++){
            if (!minRemoved  && nums[i] == min){
                minRemoved = true;
            }else{
                newArray[j++] = nums[i];
            }
        }
        minRemoved = false;
        for (int i = 0; i< k; i++ ){
            if (!minRemoved  && tempArray[i] == min){
                minRemoved = true;
            }else{
                newArray[j++] = tempArray[i];
            }
        }
        return findKthSmallest(newArray, k-1);
    }

    public static void main(String[] args) {
        FindKLargest o = new FindKLargest();
        int[] input = new int[]{1,2,3,4};
        System.out.println(o.findKthLargest(input, 2));
    }
}
