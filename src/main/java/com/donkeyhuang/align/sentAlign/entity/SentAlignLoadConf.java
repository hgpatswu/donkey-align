package com.donkeyhuang.align.sentAlign.entity;

public class SentAlignLoadConf {

    private String srcVocabPath;

    private String tgtVocabPath;

    private String straightAlignModelPath;

    private String reverseAlignModelPath;

    private String phraseTablePath;

    public SentAlignLoadConf() {

    }

    public SentAlignLoadConf(String srcVocabPath, String tgtVocabPath, String straightAlignModelPath,
                             String reverseAlignModelPath, String phraseTablePath) {
        this.srcVocabPath = srcVocabPath;
        this.tgtVocabPath = tgtVocabPath;
        this.straightAlignModelPath = straightAlignModelPath;
        this.reverseAlignModelPath = reverseAlignModelPath;
        this.phraseTablePath = phraseTablePath;
    }

    public String getSrcVocabPath() {
        return srcVocabPath;
    }

    public void setSrcVocabPath(String srcVocabPath) {
        this.srcVocabPath = srcVocabPath;
    }

    public String getTgtVocabPath() {
        return tgtVocabPath;
    }

    public void setTgtVocabPath(String tgtVocabPath) {
        this.tgtVocabPath = tgtVocabPath;
    }

    public String getStraightAlignModelPath() {
        return straightAlignModelPath;
    }

    public void setStraightAlignModelPath(String straightAlignModelPath) {
        this.straightAlignModelPath = straightAlignModelPath;
    }

    public String getReverseAlignModelPath() {
        return reverseAlignModelPath;
    }

    public void setReverseAlignModelPath(String reverseAlignModelPath) {
        this.reverseAlignModelPath = reverseAlignModelPath;
    }

    public String getPhraseTablePath() {
        return phraseTablePath;
    }

    public void setPhraseTablePath(String phraseTablePath) {
        this.phraseTablePath = phraseTablePath;
    }
}
