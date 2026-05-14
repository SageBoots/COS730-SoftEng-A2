public class SubmissionController
{
    private Database db = new Database();
    private ReviewerController reviewerController = new ReviewerController(db);

    public SubmissionController()
    {}

    public Database getDb() { return db; }

    public void validateFormat(Submission data)
    {
        if (!Validator.isValid(data))
        {
            System.out.println("Validation failed for: " + data.getTitle());
        }
        else
        {
            saveSubmission(data);
            reviewerController.startReviewProcess(data);
        }
    }

    private void saveSubmission(Submission data)
    {
        db.saveSubmission(data);
    }
}