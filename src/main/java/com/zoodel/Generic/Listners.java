package com.zoodel.Generic;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Listners extends GlobalVariable implements ITestListener {
    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        String screenShotPath = androidDriverUtility.getScreenShot(FrameWorkConstant.screenShotPath, "screenshot " + javaUtility.getDateAndTime("dd-MM-yyyy_HH-mm-ss-SSSS"));
        log.info("Screenshot captured successfully " + screenShotPath);
        Throwable exception = result.getThrowable();
        StringWriter sw = new StringWriter();
        PrintWriter pr = new PrintWriter(sw);
        exception.printStackTrace(pr);
        log.error("Failed to execute " + result.getName() + " " + sw.toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }
}
