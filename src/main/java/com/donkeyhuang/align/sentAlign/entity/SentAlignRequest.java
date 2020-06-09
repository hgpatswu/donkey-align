package com.donkeyhuang.align.sentAlign.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SentAlignRequest {

    private SentAlignSource source;

    private SentAlignTarget target;

    private Boolean inorder;

    private List<SentAlignTerm> termList;

}
