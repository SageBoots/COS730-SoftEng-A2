import java.util.*;

public class EvaluationManager
{
    private Database db;
    private float averageScore;
    private Submission submission;
    NotificationService notificationService;
    private List<Reviewer> availableReviewers;
    private int score;

    public EvaluationManager(Database db, Submission submission, List<Reviewer> availableReviewers)
    {
        this.db = db;
        this.submission = submission;
        this.availableReviewers = availableReviewers;
        this.notificationService = new NotificationService();
    }

    public void startEvaluation()
    {
        for (Reviewer reviewer : availableReviewers)
        {
            score = (int)(Math.random() * 10) + 1;
            reviewer.submitScore(score);
            db.saveScore(score);
        }

        this.calculateAverageScore();
        this.checkConsensus();
        this.applyRules();
    }

    public void saveScore(int score)
    {
        db.saveScore(score);
    }

    public void calculateAverageScore()
    {
        List<Integer> scores = db.fetchScores(submission);

        if (scores.isEmpty())
        {
            this.averageScore = 0;
            return;
        }

        int totalScore = 0;

        for (int score : scores)
        {
            totalScore += score;
        }

        this.averageScore = (float) totalScore / scores.size();
    }

    private void checkConsensus()
    {
        List<Integer> scores = db.fetchScores(submission);
        if (scores.isEmpty()) return;

        int maxScore = Collections.max(scores);
        int minScore = Collections.min(scores);

        if (maxScore - minScore > 2)
        {
            //System.out.println("Consensus not reached, further review needed.");
        }
        else
        {
            //System.out.println("Consensus reached.");
        }
    }

    private void applyRules()
    {
        if (averageScore >= 8)
        {
            notifyAcceptance();
        }
        else if (averageScore >= 5)
        {
            notifyRevision();
        }
        else
        {
            notifyRejection();
        }
    }
    private void notifyAcceptance()
    {
        notificationService.AcceptedNotification();
    }

    private void notifyRejection()
    {
        notificationService.RejectionNotification();
    }

    private void notifyRevision()
    {
        notificationService.RevisionRequestNotification();
    }
}