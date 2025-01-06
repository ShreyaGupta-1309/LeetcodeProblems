class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int c = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                c++;
            }
        }
        for(int i = n-1; i >= 0; i--){
            if( i + c < n){
                arr[i + c] = arr[i];
            }
            if( arr[i] == 0){
                c--;
                if( i + c < n){
                    arr[i + c] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}