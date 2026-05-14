import java.util.*;

public class Evaluator
{
    public float calculateAverage(List<Integer> scores)
    {
        if (scores.isEmpty()) return 0;
        int total = 0;
        for (int s : scores) total += s;
        return (float) total / scores.size();
    }

    public boolean checkConsensus(List<Integer> scores)
    {
        if (scores.size() < 2) return true;
        int max = Collections.max(scores);
        int min = Collections.min(scores);
        return (max - min) <= 2;
    }

    public String applyRules(float average) {
        if (average >= 8) return "accepted";
        if (average >= 5) return "revision";
        return "rejected";
    }
}