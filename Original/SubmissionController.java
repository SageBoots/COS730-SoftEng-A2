import java.util.*;

public class SubmissionController
{
    private Submission submission;
    private ReviewerManager reviewerManager;
    private EvaluationManager evaluationManager;
    private List<Reviewer> availableReviewers;
    private Database db = new Database();

    public SubmissionController()
    {
        this.reviewerManager = new ReviewerManager(db);
    }

    public Database getDb() { return db; }

    public void validateFormat(Submission data)
    {
        this.submission = data;
        
        if (!Validator.isValid(data))
        {
            System.out.println("Validation failed for: " + data.getTitle());
        }
        else
        {
            saveSubmission(data);
            getAvailableReviewers();
            assignReview();
            startEvaluation();
            //System.out.println("Validation passed. Reviewers assigned.");
        }
    }

    private void saveSubmission(Submission data)
    {
        db.saveSubmission(data);
    }

    public void getAvailableReviewers()
    {
        this.availableReviewers = reviewerManager.filterReviewers(submission);
    }

    public void assignReview()
    {
        for (Reviewer reviewer : availableReviewers)
        {
            reviewer.assignReview(submission);
        }
        
    }

    public void startEvaluation()
    {
        evaluationManager = new EvaluationManager(db, submission, availableReviewers);
        evaluationManager.startEvaluation();
    }
}