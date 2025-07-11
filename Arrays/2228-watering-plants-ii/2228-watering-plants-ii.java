class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int i = 0, j = n - 1;
        int alice = capacityA, bob = capacityB;
        int count = 0;
        while (i <= j) {
            if (i == j) {
                if (alice >= plants[i]) {
                    alice -= plants[i];
                    break;
                } else if (bob >= plants[i]) {
                    bob -= plants[i];
                    j--;
                    break;
                } else {
                    count++;
                    break;
                }
            }

            if (plants[i] <= alice) {
                alice -= plants[i];
                i++;
            } else {
                alice = capacityA;
                count++;
                alice -= plants[i];
                i++;
            }

            if (i > j)
                break;

            if (plants[j] <= bob) {
                bob -= plants[j];
                j--;
            } else {
                bob = capacityB;
                count++;
                bob -= plants[j];
                j--;
            }
        }
        return count;
    }
}