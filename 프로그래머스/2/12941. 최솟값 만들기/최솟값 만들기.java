import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int index = 0;
        int size = A.length;
        while(index < size) {
            answer += A[index] * B[size - 1 - index];
            index++;
        }
        
        return answer;
    }
}