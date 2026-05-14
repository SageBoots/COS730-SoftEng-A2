import java.util.*;

public class Database
{
    private List<Review> reviews = new ArrayList<>();
    private List<Reviewer> reviewers = new ArrayList<>();
    private List<Integer> scores = new ArrayList<>();
    private List<Submission> submissions = new ArrayList<>();

    public void saveSubmission(Submission data)
    {
        submissions.add(data);
    }

    public void saveReview(Review review)
    {
        reviews.add(review);
    }

    public void saveReviewer(Reviewer reviewer)
    {
        reviewers.add(reviewer);
    }

    public void saveScore(int score)
    {
        scores.add(score);
    }

    public List<Reviewer> fetchReviewers()
    {
        return new ArrayList<>(reviewers);
    }

    public List<Review> fetchReviews()
    {
        return new ArrayList<>(reviews);
    }

    public List<Integer> fetchScores(Submission submission)
    {
        List<Integer> submissionScores = new ArrayList<>();

        for (Review review : reviews)
        {
            if (review.getTitle().equals(submission.getTitle()))
            {
                submissionScores.add(review.getScore());
            }
        }
        
    return submissionScores; 
}

    public List<Submission> fetchSubmissions()
    {
        return new ArrayList<>(submissions);
    }
}