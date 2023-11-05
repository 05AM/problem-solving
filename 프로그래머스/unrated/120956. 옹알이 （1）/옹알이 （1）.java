class Solution {
    public int solution(String[] babbling) {
        String[] availables = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for(String word : babbling) {
            for(String available : availables){
                word = word.replaceAll(available, " ");
            }

            answer = word.isBlank() ? answer + 1 : answer;
        }

        return answer;
    }
}