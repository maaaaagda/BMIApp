package com.polak.magda.lab_1;

/**
 * Created by DELL on 14.03.2017.
 */

public interface BMIInterface {
    float countBMI(float weight, float height);

    boolean isValidWeight(float weight);

    boolean isValidHeight(float height);
}
