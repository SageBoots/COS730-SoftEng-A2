import java.util.*;

public class ReviewerController
{
    private ReviewerManager reviewerManager;
    private EvaluationManager evaluationManager;
    private Database db;
    List<Reviewer> filteredReviewers;
    private Submission submission;

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
            reviewer.submitScore((int)(Math.random() * 10) + 1); // Simulate score submission
        }

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