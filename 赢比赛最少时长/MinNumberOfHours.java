public class MinNumberOfHours {
    public static void main(String[] args) {

    }

}

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = 0;
        // int ind = 0;
        // int max = -1;
        // int sum1 = 0;
        int ansExperience = 0;
        for (int i = 0; i < energy.length; i++) {
            sum += energy[i];

            if (initialExperience <= experience[i]) {
                System.out.println(initialExperience);

                ansExperience += experience[i] - initialExperience + 1;
                initialExperience = 2 * experience[i] + 1;

            } else {
                initialExperience += experience[i];

            }

        }
        System.out.println(ansExperience);
        // return sum - initialEnergy + max + 1 - initialExperience - ind;
        int ansEnerhy = 0;
        if (sum >= initialEnergy) {

            ansEnerhy = sum - initialEnergy + 1;
        }

        return ansEnerhy + ansExperience;

    }
}
