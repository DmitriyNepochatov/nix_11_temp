package ua.com.nix.generatorID;

public final class GeneratorID
{
    private static int idCounter=0;

    private GeneratorID() {}

    public static String createID()
    {
        return String.valueOf(idCounter++);
    }
}
