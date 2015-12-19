/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageStegno;

/**
 *
 * @author hi
 */
 
public class MonoalhabeticCipher
{
    public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z',' ' ,'1','2','3','4','5','6','7','8','9','0',
            '/','*','-','+','!','@','#','$','%','^','&','(',')','_','=','{',
            '}','[',']','|',',','"',':',';','.','>','<','?','/','~','`'};
    public static char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
            'V', 'B', 'N', 'M',' ','3','5','8','1','0','9','1','2','7','6',
            '}','[',']','|',',','"',':',';','.','>','<','?','/','~','`','/',
            '*','-','+','!','@','#','$','%','^','&','(',')','_','=','{', };
 
    public  String doEncryption(String s)
    {
        char c[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 69; j++)
            {
                if (p[j] == s.charAt(i))
                {
                    c[i] = ch[j];
                    break;
                }
            }
        }
        return (new String(c));
    }
 
    public String doDecryption(String s)
    {
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 66; j++)
            {
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }
 
}
