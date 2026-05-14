import java.util.*;

public class Reviewer
{
    private String name;
    private boolean available = true;
    private List<Submission> assignedReviews = new ArrayList<>();
    private int maxAssignedReviews;

    public Reviewer(String name)
    {
        this.name = name;
        this.maxAssignedReviews = 10;
        this.available = true;
    }

    public String getName()
    {
        return name;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void assignReview(Submission submission)
    {
        if (assignedReviews.size() < maxAssignedReviews)
        {
            assignedReviews.add(submission);
        }
        else
        {
            available = false;
        }
    }

    public void submitScore(int score, EvaluationManager manager)
    {
        manager.saveScore(score);
        assignedReviews.removeFirst();
        
        if (assignedReviews.size() < maxAssignedReviews)
        {
            available = true;
        }
    }
}