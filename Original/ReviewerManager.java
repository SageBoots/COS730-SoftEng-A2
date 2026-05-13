import java.util.List;

public class ReviewerManager
{
    private Database db;
    private List<Reviewer> reviewerList;
    private List<Reviewer>

    public ReviewerManager(Database db)
    {
        this.db = db;
    }

    public void fetchReviewers()
    {
        this.reviewerList = db.fetchReviewers();
    }

    public List<Reviewer> filterReviewers(Submission submission)
    {
        List<Reviewer> filteredReviewers = new ArrayList<>();

        filteredReviewers = filterConflicts(submission);
        filteredReviewers = checkWorkload(filteredReviewers);

        return filteredReviewers;
    }

    public List<Reviewer> filterConflicts(Submission submission)
    {
        List<Reviewer> conflictFreeReviewers = new ArrayList<>();
        boolean hasConflict;

        for (Reviewer reviewer : reviewerList)
        {
            hasConflict = false;

            for (Submission submission : submissions)
            {
                if (Submission.getAuthor() = )
                {
                    hasConflict = true;
                    break;
                }
            }
            if (!hasConflict)
            {
                conflictFreeReviewers.add(reviewer);
            }
        }
    }

    private List<Reviewer> checkWorkload(List<Reviewer> reviewers)
    {
        List<Reviewer> underloadedReviewers = new ArrayList<>();

        for (Reviewer reviewer : reviewers)
        {
            if (reviewer.isAvailable())
            {
                underloadedReviewers.add(reviewer);
            }
        }

        return underloadedReviewers;
    }
}