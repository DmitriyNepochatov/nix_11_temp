package ua.com.nix;

import dot.dim.orp.MathManipulation;
import ua.com.nix.spg.StringManipulation;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello from Maven");
        StringManipulation stringManipulation = new StringManipulation();
        stringManipulation.printString();
        MathManipulation mathManipulation= new MathManipulation();
        mathManipulation.makeManipulation();
    }
}
