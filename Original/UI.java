public class UI
{
    SubmissionController submissionController;

    public void submit (Submission data)
    {
        submissionController.validateFormat(data);
        System.out.println("Data submitted");
        // Add your submit logic here
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to the UI!");
        // Add your UI code here
    }
}