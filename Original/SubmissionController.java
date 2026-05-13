java.util.*;

public class SubmissionController
{
    public Validator validator;
    private Submission submission;
    private ReviewerManager reviewerManager;
    private List<Reviewer> availableReviewers;

    public void submit(Submission data)
    {
        if (!validator.validateFormat(data))
        {
            throw new IllegalArgumentException("Invalid format");
        }
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
}