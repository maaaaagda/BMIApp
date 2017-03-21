/**
 * Created by DELL on 14.03.2017.
 */

public class CountBMIForKgm implements FirstInterface{
    static final float minHeight = 0.5;
    static final float maxHeight = 2.5;
    static final float minWeight = 10;
    static final float maxWeight = 250;

     public boolean isValidHeight(float height)
    {
        return (height > minHeight) && (height <maxHeight);
    }
    public boolean isValidWeight(float weight)
    {
        return (weight>minWeight) && (weight < maxWeight);
    }
    public float countBMI(float weight, float height)
    {
        if(isValidWeight(weight) && isValidHeight(height))
        {
            return weight/(height*height)
        }
        else
            throw new IllegalArgumentException("Wrong height or weight");
    }


}
