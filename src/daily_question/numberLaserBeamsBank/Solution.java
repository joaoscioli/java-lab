package daily_question.numberLaserBeamsBank;

import java.util.Arrays;

public class Solution {
    public static int numberOfBeams(String[] bank) {

        // Etapa 1: contar os dispositivos ('1') em cada linha
        int[] devicesPerRow = new int[bank.length];

        for (int i = 0; i < bank.length; i++) {
            String row = bank[i];
            int count = 0;

            for (char c : row.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }

            devicesPerRow[i] = count;
        }

        // Etapa 2: calcular o total de feixes (beams)
        int totalBeams = 0;
        int previousDevices = 0;

        for (int devices : devicesPerRow) {
            if (devices > 0) {
                totalBeams += previousDevices * devices;
                previousDevices = devices;
            }
        }

        return totalBeams;
    }

    public static void main(String[] args) {
        String[] bank = {"011001", "000000", "010100", "001000"};
        System.out.println("Total beams: " + numberOfBeams(bank));
    }
}
