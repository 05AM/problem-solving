import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int size = numlist.length;
        
        for(int i = 0; i < size-1; i++){
            for(int k = i+1; k < size; k++){
                int a = (numlist[i] - n) * (numlist[i] > n ? 1 : -1);
                int b = (numlist[k] - n) * (numlist[k] > n ? 1 : -1);
                
                if(a > b || (a == b && numlist[i] < numlist[k])){
                    int temp = numlist[i];
                    numlist[i] = numlist[k];
                    numlist[k] = temp;
                }
            }
        }
        
        return numlist;
    }
}