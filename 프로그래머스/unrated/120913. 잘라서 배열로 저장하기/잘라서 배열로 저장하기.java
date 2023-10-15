class Solution {
    public String[] solution(String my_str, int n) {
        int my_str_length = my_str.length();
        int result_cnt = (int) Math.ceil((double) my_str_length / n);
        String[] answer = new String[result_cnt];
        
        for(int i = 0; i < result_cnt; i++) {
            int start = i * n;
            int end = start + n <= my_str_length ? start + n : my_str_length;
            
            answer[i] = my_str.substring(start, end);
        }
        return answer;
    }
}