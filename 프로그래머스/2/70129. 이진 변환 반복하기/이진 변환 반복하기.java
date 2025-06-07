class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zeroCount = 0;

        while (!"1".equals(s)) {
            // 0 제거
            int originalLength = s.length();
            s = s.replace("0", "");
            zeroCount += originalLength - s.length();

            // 변환
            s = Integer.toBinaryString(s.length());
            count++;
        }

        return new int[] { count, zeroCount };
    }
}