package com.mycompany.stringapiwrapper.controller;

import com.mycompany.stringapiwrapper.controller.dto.Statistics;
import com.mycompany.stringapiwrapper.service.StringApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    })
    public ResponseEntity<Statistics> getStatistics(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.getStatistics(data).getBody();
        return prepareResponse(body, format);
    }

    @GetMapping(value = "/is-word", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public ResponseEntity<Boolean> isAlpha(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isAlpha(data).getBody();
        return prepareResponse(body, format);
    }

    @GetMapping(value = "/is-number", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public ResponseEntity<Boolean> isNumber(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isNumber(data).getBody();
        return prepareResponse(body, format);
    }

    @GetMapping(value = "/is-lower", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public ResponseEntity<Boolean> isLower(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isLower(data).getBody();
        return prepareResponse(body, format);
    }

    @GetMapping(value = "/is-upper", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
    })
    public ResponseEntity<Boolean> isUpper(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isUpper(data).getBody();
        return prepareResponse(body, format);
    }

    private <T> ResponseEntity<T> prepareResponse(T body, String format) {
        var mediaType = parseMediaType(format);
        if (mediaType == null) {
            return ResponseEntity.badRequest().build();
        }
        var headers = getContentHeaders(mediaType);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(body);
    }

    private HttpHeaders getContentHeaders(MediaType mediaType) {
        var responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(mediaType);
        return responseHeaders;
    }

    private MediaType parseMediaType(String format) {
        switch (format) {
            case "json":
                return MediaType.APPLICATION_JSON;
            case "xml":
                return MediaType.APPLICATION_XML;
            default:
                return null;
        }
    }
}
