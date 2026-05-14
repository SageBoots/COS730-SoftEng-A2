import java.util.*;

public class Reviewer
{
    private String name;
    private boolean available = true;
    private List<Submission> assignedReviews = new ArrayList<>();
    private int maxAssignedReviews;
    private EvaluationManager manager;

    public Reviewer(String name)
    {
        this.name = name;
        this.maxAssignedReviews = new Random().nextInt(10);

        this.available = new Random().nextBoolean();
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
            available = true;
        }
        else
        {
            available = false;
        }
    }

    public void submitScore(int score)
    {
        manager.saveScore(score);
    }
}