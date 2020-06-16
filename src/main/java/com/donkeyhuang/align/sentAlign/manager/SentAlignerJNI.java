package com.donkeyhuang.align.sentAlign.manager;

import java.util.List;

public class SentAlignerJNI {

    static {
        System.loadLibrary("donkeyalign");
    }

    public native boolean init();
    public native Object alignSent(Object request);
}
