package com.donkeyhuang.align.sentAlign.manager;

import com.donkeyhuang.align.sentAlign.entity.SentAlignRequest;
import com.donkeyhuang.align.sentAlign.entity.SentAlignResponse;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@NoArgsConstructor
public class SentAligner {

    private SentAlignerJNI sentAlignerJNI = new SentAlignerJNI();

    @PostConstruct
    public void init() {
        if (!sentAlignerJNI.init()) {
            System.out.println("failed to init sent aligner");
            return;
        }

        System.out.println("success to init sent aligner");
    }

    public SentAlignResponse alignSent(Object request) {
        return (SentAlignResponse) sentAlignerJNI.alignSent(request);
    }
}
