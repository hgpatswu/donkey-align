package com.donkeyhuang.align.sentAlign.entity;

import java.util.List;

public class SentAlignRequest {

    private SentAlignSource source;

    private SentAlignTarget target;

    private Boolean inorder;

    private Boolean fullAlign;

    private List<SentAlignTerm> termList;

    public SentAlignRequest() {

    }

    public SentAlignSource getSource() {
        return source;
    }

    public void setSource(SentAlignSource source) {
        this.source = source;
    }

    public SentAlignTarget getTarget() {
        return target;
    }

    public void setTarget(SentAlignTarget target) {
        this.target = target;
    }

    public Boolean getInorder() {
        return inorder;
    }

    public void setInorder(Boolean inorder) {
        this.inorder = inorder;
    }

    public Boolean getFullAlign() {
        return fullAlign;
    }

    public void setFullAlign(Boolean fullAlign) {
        this.fullAlign = fullAlign;
    }

    public List<SentAlignTerm> getTermList() {
        return termList;
    }

    public void setTermList(List<SentAlignTerm> termList) {
        this.termList = termList;
    }

    @Override
    public String toString() {
        return "SentAlignRequest{" +
                "source=" + source +
                ", target=" + target +
                ", inorder=" + inorder +
                ", termList=" + termList +
                '}';
    }
}
