package nsc.iot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController(value = "/api")
public class IOTTranscation {

    @Transactional
    @RequestMapping(value = "/save/{userName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public String api (@PathVariable String userName,
                       @RequestParam(value = "key") String key,
                       @RequestParam(value = "secret") String secret,
                       @RequestParam String name,
                       @RequestParam String value) {

        return null;
    }

    @Transactional
    @RequestMapping(value = "/query/{userName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public String query (@PathVariable String userName,
                         @RequestParam(value = "key") String key,
                         @RequestParam(value = "secret") String secret,
                         @RequestParam String name) {

        return null;
    }
}
