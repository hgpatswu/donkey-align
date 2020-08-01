package com.donkeyhuang.align.sentAlign.manager;

import com.donkeyhuang.align.sentAlign.entity.SentAlignLoadConf;

import java.util.List;

public class SentAlignerJNI {

    static {
        System.loadLibrary("donkeyalign");
    }

    public native boolean init(Object conf);

    public native Object alignSent(Object request);

    public native Object alignWord(Object request);

    public native Object tokenSent(Object request);

    public native String alignSentAsync(Object request);

    public native boolean checkAlignSentTask(String taskId);

    public native boolean deleteAlignSentResult(String taskId);

    public native Object loadAlignSentResult(String taskId);
}
