package com.polak.magda.lab_1;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by DELL on 14.03.2017.
 */

public class CountBMITest {
    @Test
    public void weightUnderZeroIsIncorrect()throws Exception
    {
        //given
        float testWeight = -10;
        //when
        BMIInterface test = new CountBMIForKgM();
        BMIInterface test1 = new CountBMIForIbFeet();
       //then
        Assert.assertFalse(test.isValidWeight(testWeight));
        Assert.assertFalse(test1.isValidWeight(testWeight));

    }
    @Test
    public void heightUnderZeroIsIncorrect()throws Exception
    {
        //given
        float testHeight = -10;
        //when
        BMIInterface test = new CountBMIForKgM();
        BMIInterface test1 = new CountBMIForIbFeet();
        //then
        Assert.assertFalse(test.isValidHeight(testHeight));
        Assert.assertFalse(test1.isValidHeight(testHeight));


    }
    @Test
    public void weightOverLimitIsIncorrect()throws Exception
    {
        //given
        float testWeight = 600;
        //when
        BMIInterface test = new CountBMIForKgM();
        BMIInterface test1 = new CountBMIForIbFeet();
        //then
        Assert.assertFalse(test.isValidWeight(testWeight));
        Assert.assertFalse(test1.isValidWeight(testWeight));

    }
    @Test
    public void heightUOverLimitIsIncorrect()throws Exception
    {
        //given
        float testHeight = 9;

        //when
        BMIInterface test = new CountBMIForKgM();
        BMIInterface test1 = new CountBMIForIbFeet();

        //then
        Assert.assertFalse(test.isValidHeight(testHeight));
        Assert.assertFalse(test1.isValidHeight(testHeight));
    }
}



