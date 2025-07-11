import java.util.Collections;
import java.util.List;

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int n = tasks.size();
        int mini = 0;
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int currIdx = 0, j = n - 1;;
        while (j >= 0) {
            mini = Math.max(mini, processorTime.get(currIdx) + tasks.get(j));
            j -= 4;
            currIdx++;
        }
        return mini;
    }
}