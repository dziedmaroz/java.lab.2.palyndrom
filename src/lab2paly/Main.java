/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab2paly;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author lucian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println(findPalyndr("dxdxdXXYYXXksdf"));
    }

    public static String readFromFile(String path)
    {
        String str="";
        FileInputStream fIStream;
        try
        {
            fIStream = new FileInputStream (path);
            InputStreamReader iStrReader = new InputStreamReader (fIStream );
            BufferedReader bReader = new BufferedReader (iStrReader);
            try
            {
                str = bReader.readLine();
            }
            catch (IOException e)
            {
                System.out.println("ERR::"+e.getLocalizedMessage());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println ("ERR::"+e.getLocalizedMessage());
        }      
        return str;
    }

    public static boolean ifPalyndrom (String str)
    {

        int len = str.length();
        if (len < 2) return false;
        for (int i=0;i<len/2;i++)
        {
            if (str.charAt(i)!=str.charAt(len-1-i))
            {
                return false;
            }
        }
        return true;
    }

    public static String findPalyndr (String str)
    {
        if (str.length()<=1) return "";

       

        if (ifPalyndrom(str))
        {
           return str;
        }
        else
        {
             String lRes = findPalyndr(str.substring(0, str.length()-2));
             String rRes = findPalyndr(str.substring(1));
             if (lRes.length()>rRes.length()) return lRes;
             else return rRes;
        }


    }

}
