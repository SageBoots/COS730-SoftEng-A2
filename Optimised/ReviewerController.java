import java.util.*;

public class ReviewerController
{
    private ReviewerManager reviewerManager;
    private EvaluationManager evaluationManager;
    private Database db;
    List<Reviewer> filteredReviewers;
    private Submission submission;
    private int score;

    public ReviewerController(Database db)
    {
        this.db = db;
        this.reviewerManager = new ReviewerManager(db);
    }

    public void startReviewProcess(Submission submission)
    {
        this.submission = submission;
        this.evaluationManager = new EvaluationManager(this.db);
        this.getAvailableReviewers();
        this.assignReview();

        for (Reviewer reviewer : filteredReviewers)
        {
            score = (int)(Math.random() * 10) + 1;
            reviewer.submitScore(score);
            db.saveScore(score);
        }
        
        evaluationManager.startEvaluationProcess(submission);
    }

    public void getAvailableReviewers()
    {
        reviewerManager.fetchReviewers();
        this.filteredReviewers = reviewerManager.filterReviewers(submission);
    }

    public void assignReview()
    {
        for (Reviewer reviewer : filteredReviewers)
        {
            reviewer.assignReview(submission);
        }
    }
}