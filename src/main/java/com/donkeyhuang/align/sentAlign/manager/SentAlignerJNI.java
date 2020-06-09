package com.donkeyhuang.align.sentAlign.manager;

public class SentAlignerJNI {

    static {
        System.loadLibrary("sentalign");
    }

    public native boolean init();
    public native Object alignSent(Object request);
}
