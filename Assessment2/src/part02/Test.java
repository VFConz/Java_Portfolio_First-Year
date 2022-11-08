package part02;

public class Test
{

    public static boolean numValid(double number) {
        String str = Double.toString(number);
        for (int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != '.'  || !Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }


}
