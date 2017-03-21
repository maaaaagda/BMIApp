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
        FirstInterface test = new CountBMIForKGM();
       //then
        Assert.assertFalse(test.isValidWeight(testWeight));

    }
    @Test
    public void heightUnderZeroIsIncorrect()throws Exception
    {
        //given
        float testHeight = -10;
        //when
        FirstInterface test = new CountBMIForKGM();
        //then
        Assert.assertFalse(test.isValidHeight(testHeight));

    }
    @Test
    public void weightOverLimitIsIncorrect()throws Exception
    {
        //given
        float testWeight = 300;
        //when
        FirstInterface test = new CountBMIForKGM();
        //then
        Assert.assertFalse(test.isValidWeight(testWeight));

    }
    @Test
    public void heightUOverLimitIsIncorrect()throws Exception
    {
        //given
        float testHeight = 3;
        //when
        FirstInterface test = new CountBMIForKGM();
        //then
        Assert.assertFalse(test.isValidHeight(testHeight));

    }
}



