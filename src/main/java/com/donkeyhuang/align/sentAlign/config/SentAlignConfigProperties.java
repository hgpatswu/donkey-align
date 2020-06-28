package com.donkeyhuang.align.sentAlign.config;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sent.align")
public class SentAlignConfigProperties {

    private String sourceVocabPath;

    private String targetVocabPath;

    private String straightAlignModelPath;

    private String reverseAlignModelPath;

    private String phraseTablePath;

    private String svmModelPath;

    public SentAlignConfigProperties() {
    }

    public String getSourceVocabPath() {
        return sourceVocabPath;
    }

    public void setSourceVocabPath(String sourceVocabPath) {
        this.sourceVocabPath = sourceVocabPath;
    }

    public String getTargetVocabPath() {
        return targetVocabPath;
    }

    public void setTargetVocabPath(String targetVocabPath) {
        this.targetVocabPath = targetVocabPath;
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

    public String getSvmModelPath() {
        return svmModelPath;
    }

    public void setSvmModelPath(String svmModelPath) {
        this.svmModelPath = svmModelPath;
    }
}
