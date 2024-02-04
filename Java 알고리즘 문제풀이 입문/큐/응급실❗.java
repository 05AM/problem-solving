import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  // 💡 main idea: 클래스를 만들어 필요한 정보가 함께 존재하게 한다.
    private class Patient {
        private int sequenceNumber;
        private int riskLevel;

        public Patient(int sequenceNumber, int riskLevel) {
            this.sequenceNumber = sequenceNumber;
            this.riskLevel = riskLevel;
        }
    }

    private int solution(int n, int m, int[] arr) {
        int answer = 1;

        LinkedList<Patient> patients = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            patients.offer(new Patient(i, arr[i]));
        }

        while (!patients.isEmpty()) {
            Patient currentPatient = patients.poll();

          // stream으로 간단한 판단 가능
            if (patients.stream().anyMatch(p -> p.riskLevel > currentPatient.riskLevel)) {
                patients.offer(currentPatient);
            } else {
                if (currentPatient.sequenceNumber == m) {
                    return answer;
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
