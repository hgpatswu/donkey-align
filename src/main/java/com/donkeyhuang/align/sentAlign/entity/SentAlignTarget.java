package com.donkeyhuang.align.sentAlign.entity;

import com.donkeyhuang.commons.lang.Language;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SentAlignTarget {

    private Language lang;

    private List<String> sentList;
}
