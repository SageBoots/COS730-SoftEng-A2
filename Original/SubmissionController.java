import java.util.*;

public class SubmissionController
{
    private Validator validator;
    private Submission submission;
    private ReviewerManager reviewerManager;
    private List<Reviewer> availableReviewers;
    private EvaluationManager evaluationManager;
    private Database db = new Database();

    public void validateFormat(Submission data)
    {
        this.submission = data;
        if (!Validator.isValid(data))
        {
            throw new IllegalArgumentException("Invalid format");
        }
        else
        {
            saveSubmission(data);
            getAvailableReviewers();
            assignReview();
            startEvaluation();
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
        evaluationManager = new EvaluationManager(db, submission);
    }
}