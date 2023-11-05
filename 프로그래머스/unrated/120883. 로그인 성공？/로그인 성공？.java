class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        
        String enterId = id_pw[0];
        String enterPw = id_pw[1];
        
        for(int i = 0; i < db.length; i++) {
            if(db[i][0].equals(enterId)) {
                if(db[i][1].equals(enterPw)) {
                    answer = "login";
                    continue;
                } else {
                    answer = "wrong pw";
                    continue;
                }
            }
        }
        
        return answer;
    }
}