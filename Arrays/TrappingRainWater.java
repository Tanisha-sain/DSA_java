package Arrays;
import java.util.*;

public class TrappingRainWater {
    static int trappingWater(int[] height){
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int i = 1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        for(int i = n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int trappedWater = 0;
        for(int i = 0; i<n; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(water > 0) trappedWater += water;
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        int trappedWater = trappingWater(height);
        System.out.println(trappedWater);
    }
}
