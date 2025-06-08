class Solution {
    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        int oneCount = binary.length() - binary.replace("1", "").length();
        int count = -1;

        while (oneCount != count) {
            n++;
            String nextBinary = Integer.toBinaryString(n);
            count = nextBinary.length() - nextBinary.replace("1", "").length();
        }

        return n;
    }
}