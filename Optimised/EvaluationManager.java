import java.util.*;

public class EvaluationManager
{
    private Database db;
    private Evaluator evaluator = new Evaluator();
    private NotificationService notificationService = new NotificationService();

    public EvaluationManager(Database db)
    {
        this.db = db;
    }

    public void saveScore(int score)
    {
        db.saveScore(score);
    }

    public void startEvaluation(Submission submission)
    {
        List<Integer> scores = db.fetchScores(submission);
        
        float avg = evaluator.calculateAverage(scores);
        boolean consensus = evaluator.checkConsensus(scores);
        String result = evaluator.applyRules(avg);

        if (!consensus)
        {
            System.out.println("Consensus not reached.");
        }
        
        notify(result);
    }

    private void notify(String result)
    {
        if (result.equals("accepted")) notificationService.AcceptedNotification();
        else if (result.equals("revision")) notificationService.RevisionRequestNotification();
        else notificationService.RejectionNotification();
    }
}