import java.util.*;

public class ReviewerManager
{
    private Database db;
    private List<Reviewer> reviewerList;

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
        List<Reviewer> nonConflictingReviewers = new ArrayList<>();

        for (Reviewer reviewer : reviewerList)
        {
            if (!submission.getAuthor().equals(reviewer.getName()))
            {
                nonConflictingReviewers.add(reviewer);
            }
        }

        return nonConflictingReviewers;
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