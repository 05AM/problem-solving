class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int h = 3; h <= total / 3; h++) {
            if (total % h != 0) {
                continue;
            }

            int w = (int)(total / h);

            if (yellow == (w - 2) * (h - 2)) {
                return new int[] {w, h};
            }
        }

        return new int[]{};
    }
}