package com.donkeyhuang.align.sentAlign.entity;

import com.donkeyhuang.commons.lang.Language;

public class WordAlignRequest {

    private Language srcLang;

    private String srcSent;

    private Language tgtLang;

    private String tgtSent;

    public WordAlignRequest() {

    }

    public Language getSrcLang() {
        return srcLang;
    }

    public void setSrcLang(Language srcLang) {
        this.srcLang = srcLang;
    }

    public String getSrcSent() {
        return srcSent;
    }

    public void setSrcSent(String srcSent) {
        this.srcSent = srcSent;
    }

    public Language getTgtLang() {
        return tgtLang;
    }

    public void setTgtLang(Language tgtLang) {
        this.tgtLang = tgtLang;
    }

    public String getTgtSent() {
        return tgtSent;
    }

    public void setTgtSent(String tgtSent) {
        this.tgtSent = tgtSent;
    }

    @Override
    public String toString() {
        return "WordAlignRequest{" +
                "srcLang=" + srcLang +
                ", srcSent='" + srcSent + '\'' +
                ", tgtLang=" + tgtLang +
                ", tgtSent='" + tgtSent + '\'' +
                '}';
    }
}
