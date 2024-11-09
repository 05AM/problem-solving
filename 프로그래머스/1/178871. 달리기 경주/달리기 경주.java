import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranking = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }

        for (String calling : callings) {
            int calledPlayer = ranking.get(calling);
            String tempPlayer = players[calledPlayer - 1];

            players[calledPlayer - 1] = calling;
            players[calledPlayer] = tempPlayer;

            ranking.replace(players[calledPlayer], calledPlayer);
            ranking.replace(calling, calledPlayer - 1);
        }

        String[] answer = new String[players.length];

        for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
            answer[entry.getValue()] = entry.getKey();
        }

        return answer;
    }
}