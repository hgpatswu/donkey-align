package com.donkeyhuang.align.sentAlign.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SentAlignTerm {

    private String source;

    private String target;
}
