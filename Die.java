public class Die {
    private final int MINIMUM_DEFAULT = 1;
    private final int MAXIMUM_DEFAULT = 6;
    private int minimum;
    private int maximum;

    public Die(int min,int max)
    {
        this.maximum = max;
        this.minimum = min;
    }
    public Die()
    {
        this.maximum = MAXIMUM_DEFAULT;
        this.minimum = MINIMUM_DEFAULT;
    }
    public int roll(){
        return (Main.rnd.nextInt((maximum-minimum)+1)+minimum);
    }
}
