class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int horizontal_limit = board[0] / 2;
        int vertical_limit = board[1] / 2;
        int x = 0;
        int y = 0;
        
        for(String direction : keyinput) {
            switch(direction) {
                case "right":
                    if (x < horizontal_limit)
                        x++;
                    break;

                case "left":
                    if (x > -horizontal_limit)
                        x--;
                    break;

                case "up":
                    if (y < vertical_limit)
                        y++;
                    break;

                case "down":
                    if (y > -vertical_limit)
                        y--;
                    break;
            }
        }
        return new int[]{x, y};
    }
}