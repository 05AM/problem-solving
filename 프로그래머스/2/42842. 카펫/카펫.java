class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (double h = 3; ; h++) {
            for (double w = 3; ; w++) {
                if (w * h > sum) {
                    break;
                } else if (w * h == sum) {
                    if (brown == (2 * w + 2 * h - 4) && yellow == (w - 2) * (h - 2)) {
                        answer[0] = (int) w;
                        answer[1] = (int) h;
                        break;
                    }
                }
            }

            if (answer[0] != 0) {
                break;
            }
        }
        
        return answer;
    }
}