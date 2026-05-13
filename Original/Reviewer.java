java.util.*;

public class Reviewer
{
    private String name;
    private boolean available = true;
    private List<Review> assignedReviews = new ArrayList<>();
    private int maxAssignedReviews;

    public Reviewer(String name)
    {
        this.name = name;
        this.maxAssignedReviews = new Random().nextInt(10);

        this.available = New Random().nextBoolean();
    }

    public String getName()
    {
        return name;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void assignReview(Review review)
    {
        assignedReviews.add(review);

        if (assignedReviews.size() >= maxAssignedReviews)
        {
            available = false;
        }
        else
        {
            available = true;
        }
    }
}