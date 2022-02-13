package ua.com.nix;

public final class ReverseStringUtil
{
    private ReverseStringUtil() {}

    public static String simpleReverse(String str)
    {
        StringBuilder reverseStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
        {
            reverseStr.append(str.charAt(i));
        }
        return reverseStr.toString();
    }

    private static String reverseAllWordsW(String str)
    {
        String[] words = str.split("\\s");
        StringBuilder reverseStr = new StringBuilder();
        for (int i = 0; i < words.length; i++)
        {
            reverseStr.append(simpleReverse(words[i]) + " ");
        }
        return reverseStr.deleteCharAt(reverseStr.length() - 1).toString();
    }

    public static String reverseAllWords(String str)
    {
        StringBuilder lastSymbols = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
        {
            if(str.charAt(i)==' ')
                lastSymbols.append(" ");
            else if(str.charAt(i)!=' ')
                break;
        }
        return reverseAllWordsW(str)+lastSymbols.toString();
    }

    public static String reverseSubStringSimple(String str, String dest)
    {
        if (str.contains(dest))
        {
            String destFinally = simpleReverse(dest);
            return reverseSubStr(str, dest, destFinally);
        }
        else
            return null;
    }

    public static String reverseSubStringAllWords(String str, String dest)
    {
        if (str.contains(dest))
        {
            String destFinally;

            if (dest.contains(" "))
                destFinally = reverseAllWordsW(dest);
            else
                destFinally = simpleReverse(dest);

            return reverseSubStr(str, dest, destFinally);
        }
        else
            return null;
    }

    private static String reverseSubStr(String str, String dest, String destFinally)
    {
        int index = str.indexOf(dest);
        StringBuilder finallyStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            if (i == index)
            {
                i += destFinally.length() - 1;
                finallyStr.append(destFinally);
            }
            else
                finallyStr.append(str.charAt(i));
        }

        return finallyStr.toString();
    }

    public static String reverseForIndexesSimple(String str, int firstIndex, int lastIndex)
    {
        if (firstIndex >= 0 && lastIndex <= str.length() - 1 && firstIndex < lastIndex)
            return reverseSubStringSimple(str, str.substring(firstIndex, lastIndex + 1));
        else
            return null;
    }

    public static String reverseForIndexesAllWords(String str, int firstIndex, int lastIndex)
    {
        if (firstIndex >= 0 && lastIndex <= str.length() - 1 && firstIndex < lastIndex)
            return reverseSubStringAllWords(str, str.substring(firstIndex, lastIndex + 1));
        else
            return null;
    }

    public static String reverseForSymbolsSimple(String str, char firstSymbol, char lastSymbol)
    {
        int firstS = str.indexOf(firstSymbol);
        int lastS = str.indexOf(lastSymbol);

        if (firstS != -1 && lastS != -1 && firstS < lastS)
            return reverseForIndexesSimple(str, firstS, lastS);
        else
            return null;
    }

    public static String reverseForSymbolsAllWords(String str, char firstSymbol, char lastSymbol)
    {
        int firstS = str.indexOf(firstSymbol);
        int lastS = str.indexOf(lastSymbol);

        if (firstS != -1 && lastS != -1 && firstS < lastS)
            return reverseForIndexesAllWords(str, firstS, lastS);
        else
            return null;
    }

    public static String reverseForStringSimple(String str, String firstString, String lastString)
    {
        int firstStr = str.indexOf(firstString);
        int lastStr = str.indexOf(lastString);

        if (firstStr != -1 && lastStr != -1 && firstStr + firstString.length() <= lastStr)
            return reverseForIndexesSimple(str, firstStr, lastStr + lastString.length() - 1);
        else
            return null;
    }

    public static String reverseForStringAllWords(String str, String firstString, String lastString)
    {
        int firstStr = str.indexOf(firstString);
        int lastStr = str.indexOf(lastString);

        if (firstStr != -1 && lastStr != -1 && firstStr + firstString.length() <= lastStr)
            return reverseForIndexesAllWords(str, firstStr, lastStr + lastString.length() - 1);
        else
            return null;
    }
}
