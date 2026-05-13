public class Review
{
    private String reviewer;
    private int score;

    public Review(String reviewer, int score)
    {
        this.reviewer = reviewer;
        this.score = score;
    }

    public String getReviewer()
    {
        return reviewer;
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