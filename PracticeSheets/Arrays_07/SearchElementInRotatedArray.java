// There is an integer array nums sorted in ascending order 
//  (with distinct values).Prior to being passed to your function,
// nums is possibly rotated at an unknown pivot  index k (1  <=  k  <  nums.length)  
// such  that  the  resulting  array  is 
// [nums[k], nums[k+1],   ...,   nums[n-1], nums[0],   nums[1],   ...,   nums[k-1]] (0-indexed).   
// For   example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, 
// return the index of target if it is in nums, or -1 if it is not in nums. 
// You must write an algorithm with O(log n) runtime complexity.

package PracticeSheets.Arrays_07;


public class SearchElementInRotatedArray{
    static int search(int[] arr, int key){
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = (s+e)/2;
            if(arr[mid] == key) return mid;
            else if(arr[s] <= arr[mid]){
                if(key <= arr[mid] && key >= arr[s]){
                    e = mid - 1;
                }else{
                    s = mid+1;
                }
            }else if(arr[mid] <= arr[e]){
                if(key >= arr[mid] && key <= arr[e]){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            } 
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int key = 3;
        int index = search(arr, key);

        System.out.println(index);
    }
}