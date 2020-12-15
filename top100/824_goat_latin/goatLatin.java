class Solution 
{
    public String toGoatLatin(String S) 
    {
        String[] words = S.split(" ");
        
        for (int i=0; i<words.length; i++)
        {
            if ( !isVowel(words[i].charAt(0)) )
                words[i] = words[i].substring(1) + words[i].charAt(0);
            words[i] += "ma";
            words[i] += addAs(i);
        }
        return String.join(" ", words);
    }
    
    private boolean isVowel(char letter)
    {
        if (letter == 'a' || letter == 'A' ||
            letter == 'e' || letter == 'E' ||
            letter == 'i' || letter == 'I' ||
            letter == 'o' || letter == 'O' ||
            letter == 'u' || letter == 'U')
            return true;
        return false;
    }
    
    private String addAs(int num)
    {
        String result = "";
        for (int i=0; i<num+1; i++)
            result+="a";
        return result;
    }
}