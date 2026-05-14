public class Review
{
    private String reviewer, title;
    private int score;

    public Review(String reviewer, String title, int score)
    {
        this.reviewer = reviewer;
        this.title = title;
        this.score = score;
    }

    public String getReviewer()
    {
        return reviewer;
    }

    public String getTitle()
    {
        return title;
    }

    public void setReviewer(String reviewer)
    {
        this.reviewer = reviewer;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}