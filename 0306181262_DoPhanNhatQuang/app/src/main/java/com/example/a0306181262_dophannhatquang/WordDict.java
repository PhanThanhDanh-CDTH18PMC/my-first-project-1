package com.example.a0306181262_dophannhatquang;

public class WordDict
{
    private String Word;
    private String Def;

    public WordDict(String word, String def)
    {
        Word = word;
        Def = def;
    }

    public String getWord()
    {
        return Word;
    }

    public String getDef()
    {
        return Def;
    }

    public void setWord(String word)
    {
        Word = word;
    }

    public void setDef(String def)
    {
        Def = def;
    }
}
