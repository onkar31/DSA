package Arrays.Easy.binarySearch;

public class FirstOccurance {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,4,5};
        int target = 2;
        int firstOcc = firstOccurance(arr, target);
        System.out.println("First Occurance: " + firstOcc);
    }

    public static int firstOccurance(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans =-1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                ans = mid;
                high = mid -1;  // Search left
            }else if(arr[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
