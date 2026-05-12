public class SubmissionController
{
    public Validator validator;

    public void submit(String data)
    {
        if (!validator.validate(data))
        {
            throw new IllegalArgumentException("Invalid format");
        }
    }
}