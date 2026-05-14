public class NotificationService
{
    private String message;

    public void AcceptedNotification()
    {
        this.message = "Submission accepted.";
        sendNotification();
    }

    public void RejectionNotification()
    {
        this.message = "Submission rejected.";
        sendNotification();
    }

    public void RevisionRequestNotification()
    {
        this.message = "Submission requires revision.";
        sendNotification();
    }

    private void sendNotification()
    {
        System.out.println("Notification sent: " + message);
    }
}