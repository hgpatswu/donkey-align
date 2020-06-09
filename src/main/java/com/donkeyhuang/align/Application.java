package com.donkeyhuang.align;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RedisAutoConfiguration.class, ElasticsearchAutoConfiguration.class})
@ComponentScan(value = {"com.donkeyhuang.commons", "com.donkeyhuang.align"})
@RestController
public class Application {

    @Value("${application.hello.message:greeting}")
    private String greeting;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    String greetGet() {
        return JSONObject.quote(greeting);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    String greetPost()  {
        return JSONObject.quote(greeting);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
