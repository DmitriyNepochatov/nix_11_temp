package dot.dim.orp;

import org.apache.commons.math3.random.*;

public class MathManipulation
{
    public void makeManipulation()
    {
        RandomDataGenerator randomDataGenerator= new RandomDataGenerator();
        System.out.println("Random int: "+randomDataGenerator.nextInt(10, 20));
    }
}
