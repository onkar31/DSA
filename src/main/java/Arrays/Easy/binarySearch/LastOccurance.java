package Arrays.Easy.binarySearch;

public class LastOccurance {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,4,5};
        int target = 2;
        int lastOcc = lastOccurance(arr, target);
        System.out.println("Last Occurance: " + lastOcc);
    }

    public static int lastOccurance(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans =-1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                ans = mid;
                low = mid +1;  // Search right
            }else if(arr[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
