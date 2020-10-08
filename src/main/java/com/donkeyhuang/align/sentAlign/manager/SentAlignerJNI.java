package com.donkeyhuang.align.sentAlign.manager;

public class SentAlignerJNI {

    static {
        System.loadLibrary("donkeyalign");
    }

    public native boolean init(Object conf);

    public native Object alignSent(Object request);

    public native Object alignWord(Object request);

    public native Object tokenSent(Object request);

    public native String alignSentAsync(Object request);

    public native Object checkAlignSentTask(String taskId);

    public native Object listAlignSentTask();

    public native boolean deleteAlignSentResult(String taskId);

    public native Object loadAlignSentResult(String taskId);
}
