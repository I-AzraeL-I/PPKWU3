package com.mycompany.stringapiwrapper.controller;

import com.mycompany.stringapiwrapper.controller.util.ControllerUtils;
import com.mycompany.stringapiwrapper.service.StringApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StringFormatController {

    private final StringApiClient stringApiClient;

    @GetMapping(value = "/statistics", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_PLAIN_VALUE
    })
    public ResponseEntity<?> getStatistics(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.getStatistics(data).getBody();
        var mediaType = ControllerUtils.parseMediaType(format);
        return ControllerUtils.preparedResponse(body, mediaType);
    }

    @GetMapping(value = "/is-word", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_PLAIN_VALUE
    })
    public ResponseEntity<?> isAlpha(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isAlpha(data).getBody();
        var mediaType = ControllerUtils.parseMediaType(format);
        return ControllerUtils.preparedResponse(body, mediaType);
    }

    @GetMapping(value = "/is-number", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_PLAIN_VALUE
    })
    public ResponseEntity<?> isNumber(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isNumber(data).getBody();
        var mediaType = ControllerUtils.parseMediaType(format);
        return ControllerUtils.preparedResponse(body, mediaType);
    }

    @GetMapping(value = "/is-lower", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_PLAIN_VALUE
    })
    public ResponseEntity<?> isLower(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isLower(data).getBody();
        var mediaType = ControllerUtils.parseMediaType(format);
        return ControllerUtils.preparedResponse(body, mediaType);
    }

    @GetMapping(value = "/is-upper", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_PLAIN_VALUE
    })
    public ResponseEntity<?> isUpper(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isUpper(data).getBody();
        var mediaType = ControllerUtils.parseMediaType(format);
        return ControllerUtils.preparedResponse(body, mediaType);
    }
}
