class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       int low = 0;
       int high = arr.length-1;
       int mid;
       while(low < high){
        mid = (low + high)/2;
        if(arr[mid] < arr[mid + 1]){
            low = mid +1;
        }
        else{
            high = mid;
        }
       }
       return low;
    }
}