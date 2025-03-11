import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int headcount = friends.length;
        Map<String, Integer> index = new HashMap<>();
        
        for(int i = 0; i < headcount; i++) {
            index.put(friends[i], i);
        }
        
        // 히스토리 계산
        int[][] history = new int[headcount][headcount];
        for(String gift : gifts) {
            String[] splited = gift.split(" ");
            int senderIdx = index.get(splited[0]);
            int receiverIdx = index.get(splited[1]);
            
            history[senderIdx][receiverIdx] += 1;
        }
        
        // 선물지수 계산
        int[] giftIndex = new int[headcount];
        for(int i = 0; i < headcount; i++) {
            int sent = 0;
            int received = 0;
            
            for(int j = 0; j < headcount; j++) {
                sent += history[i][j];
                received += history[j][i];
            }
            
            giftIndex[i] = sent - received;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < headcount; i++) {
            int gift = 0;
            
            for(int j = 0; j < headcount; j++) {
                if(i == j)
                    continue;
                
                int iSent = history[i][j];
                int jSent = history[j][i];
                if (iSent > jSent) {
                    gift += 1;
                } else if (iSent == jSent) {
                    if (giftIndex[i] > giftIndex[j]) {
                        gift += 1;
                    }
                }
            }
            
            max = Math.max(max, gift);
        }
        
        return max;
    }
}