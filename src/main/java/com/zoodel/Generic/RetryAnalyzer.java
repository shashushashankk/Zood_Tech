package com.zoodel.Generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int initValue=0;
    int repeataiton =3;

    @Override
    public boolean retry(ITestResult result){
        if(initValue==repeataiton){
            return  false;
        }
        initValue++;
        return true;
    }
}
