import java.util.*;

public class SubmissionController
{
    private Submission submission;
    /*private ReviewerManager reviewerManager;
    private EvaluationManager evaluationManager;
    private List<Reviewer> availableReviewers;*/
    private Database db = new Database();

    public SubmissionController()
    {}

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
            /*getAvailableReviewers();
            assignReview();*/

            //System.out.println("Validation passed. Reviewers assigned.");
        }
    }

    private void saveSubmission(Submission data)
    {
        db.saveSubmission(data);
    }

    /*public void getAvailableReviewers()
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
    }*/
}