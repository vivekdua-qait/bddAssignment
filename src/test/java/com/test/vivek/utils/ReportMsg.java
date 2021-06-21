package com.test.vivek.utils;

import org.testng.Reporter;

public class ReportMsg {

    protected static final String fail = "[ASSERT FAIL]: ";
    protected static final String info = "[INFO]: ";
    protected static final String pass = "[ASSERT PASS]: ";


    public static String fail(String message) {
        return reportMsg(fail, message);
    }

    public static String pass(String message) {
        return reportMsg(pass, message);
    }
    
    public static String log(String message){
        return reportMsg(info, message);
    }

    private static String reportMsg(String prefix, String message) {
    	Reporter.log(prefix + message, true);
        return prefix + message;
    }

    public static String log(String msgType, String message){
        msgType=msgType.toUpperCase();
        return reportMsg("["+msgType+"]: ", message);
    }

    
}
