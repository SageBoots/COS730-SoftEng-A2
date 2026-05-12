public class Validator
{
    public static boolean validate(String input)
    {
        if (input == null || input.isEmpty())
        {
            return false;
        }
        
        return true;
    }
}