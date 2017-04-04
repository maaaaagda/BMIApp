package com.polak.magda.lab_1;

/**
 * Created by DELL on 23.03.2017.
 */

public class CountBMIForIbFeet  implements BMIInterface {
    static final float minHeight = 1.6f;
    static final float maxHeight = 8f;
    static final float minWeight = 20;
    static final float maxWeight = 450;

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
            return weight*4.88f/(height*height);
        }
        else
            throw new IllegalArgumentException("Wrong height or weight");
    }


}


/*
zmiana orientacji, ma uzytkownik widziec wszystko przy rotate wszystkie dane mająbyc widoczne, dane mają byc zapamietane
onSaveInstanceType
w opcjach developerskich dont keep activities
wprowadzamy dane i ma zachowac dane
doimplementowanie intentów ? aboutAuthorPage = nasza wizja i zdjęcie, awatar
Author
Save button - dwie wartości, masa i wzrost, jednostke, preferences -
Share button - z tekstem wywołuje liste aplikacji
zip na eportal z midletem, do wtorku 19.00

 */