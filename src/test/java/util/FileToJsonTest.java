package util;

import com.donkeyhuang.align.sentAlign.entity.SentAlignRequest;
import com.donkeyhuang.align.sentAlign.entity.SentAlignSource;
import com.donkeyhuang.align.sentAlign.entity.SentAlignTarget;
import com.donkeyhuang.commons.lang.Language;
import com.donkeyhuang.commons.rest.RestRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileToJsonTest {

    @Test
    void loadSentTest() {
        var srcFilePath = "/home/donkeyhuang/data/5000_en.txt";
        var tgtFilePath = "/home/donkeyhuang/data/5000_zh.txt";
        var outputPath = "/home/donkeyhuang/data/5000_json.txt";

        List<String> srcSentList = null, tgtSentList = null;
        try {
            srcSentList = Files.readAllLines(Path.of(srcFilePath));
            tgtSentList = Files.readAllLines(Path.of(tgtFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        var request = new SentAlignRequest();

        var source = new SentAlignSource();
        source.setLang(Language.ENGLISH);
        source.setSentList(srcSentList);

        var target = new SentAlignTarget();
        target.setLang(Language.CHINESE);
        target.setSentList(tgtSentList);

        request.setSource(source);
        request.setTarget(target);
        request.setInorder(true);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        String result;

        try {
            result = mapper.writeValueAsString(new RestRequest<>(request));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            Files.writeString(Path.of(outputPath), result);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }
}
