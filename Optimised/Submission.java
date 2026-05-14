import java.util.*;

public class Submission
{
    private int id;
    private String title;
    private String author;
    private List<Review> reviews;
    public boolean isValid;

    public Submission(String title, String author)
    {
        this.id = new Random().nextInt(Integer.MAX_VALUE);
        this.title = title;
        this.author = author;

        reviews = new ArrayList<>();
        isValid = new Random().nextBoolean();
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getId()
    {
        return id;
    }

    public void addReview(Review review)
    {
        reviews.add(review);
    }
}