class Solution {
    public String solution(String s, int n) {
        // 대소문자 구분
        // char 구간을 나머지 연산으로
        // char array로 만들어서 순회
        StringBuilder answer = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                answer.append(' ');
                continue;
            }
            
            char moved = ' ';
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            
            int offset = (ch - base + n) % 26;
            moved = (char)(base + offset);
            
            answer.append(moved);
        }
        
        return answer.toString();
    }
}