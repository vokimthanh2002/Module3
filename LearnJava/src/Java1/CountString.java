package Java1;

public class CountString {
    public static int count(String s)
    {
        int i = 0,
        count = 1;
        char[] s1 = s.toCharArray();

        while(s1[i] == ' ')
        {
            i++;
        }
        for (int j = i; j < s1.length - 1; j++)
        {
            if(s1[j] == ' ' && s1[j + 1] != ' ')
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        System.out.println("length = " + count("a   ajhdf    asfjl    afj       a           a     "));
    }
}
