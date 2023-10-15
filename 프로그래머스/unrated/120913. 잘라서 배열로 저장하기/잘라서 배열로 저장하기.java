class Solution {
    public String[] solution(String my_str, int n) {
        int my_str_length = my_str.length();
        int answer_length = (int) Math.ceil((double) my_str.length() / n);
        String[] answer = new String[answer_length];
        
        for(int i = 0; i < answer_length; i++) {
            if((i+1) * n >= my_str_length) {
                answer[i] = my_str.substring(i * n, my_str_length);
                break;
            }
            answer[i] = my_str.substring(i * n, (i+1) * n);
        }
        return answer;
    }
}