import java.util.*;
import java.lang.*;
import java.io.*;

class OCRStrings
{
    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        String s = "A2Le";
        String t = "2pL1"; 
        StringBuilder sExpanded = expandedString(s);
        StringBuilder tExpanded = expandedString(t);
        System.out.println(sExpanded); //A??Le
        System.out.println(tExpanded); //??pL?
        if(sExpanded.length()!=tExpanded.length())
            System.out.println("false");
        for(int i=0;i<sExpanded.length();i++)
        {
            if((sExpanded.charAt(i)!='?' && tExpanded.charAt(i)!='?') &&
                sExpanded.charAt(i) != tExpanded.charAt(i))
                {
                    System.out.println("false");
                }
        }
        System.out.println("true");
    }
    
    public static StringBuilder expandedString(String s)
    {
        int n = s.length();
        StringBuilder result = new StringBuilder();  
        for(int i=0;i<n;)
        {
             
            int j = i;
            if(Character.isDigit(s.charAt(j)))
            {
                String sub="";
                while(j<n && Character.isDigit(s.charAt(j)))
                {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                
                for(int x=0;x<num;x++)
                {
                    result.append("?");
                }
                //System.out.println("num: "+num);
                i=j;
            }
            else
            {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}
