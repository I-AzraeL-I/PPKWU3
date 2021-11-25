package com.mycompany.stringapiwrapper.controller;

import com.mycompany.stringapiwrapper.configuration.MediaTypeExtended;
import com.mycompany.stringapiwrapper.dto.Statistics;
import com.mycompany.stringapiwrapper.exception.IncorrectMediaTypeException;
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
@RequestMapping(value = "/api", produces = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE,
        MediaType.TEXT_PLAIN_VALUE,
        MediaTypeExtended.TEXT_CSV_VALUE
})
@RequiredArgsConstructor
public class StringFormatController {

    private final StringApiClient stringApiClient;

    @GetMapping(value = "/statistics")
    public ResponseEntity<Statistics> getStatistics(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.getStatistics(data).getBody();
        var mediaType = parseMediaType(format);
        return responseWithMediaType(body, mediaType);
    }

    @GetMapping(value = "/is-word")
    public ResponseEntity<Boolean> isAlpha(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isAlpha(data).getBody();
        var mediaType = parseMediaType(format);
        return responseWithMediaType(body, mediaType);
    }

    @GetMapping(value = "/is-number")
    public ResponseEntity<Boolean> isNumber(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isNumber(data).getBody();
        var mediaType = parseMediaType(format);
        return responseWithMediaType(body, mediaType);
    }

    @GetMapping(value = "/is-lower")
    public ResponseEntity<Boolean> isLower(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isLower(data).getBody();
        var mediaType = parseMediaType(format);
        return responseWithMediaType(body, mediaType);
    }

    @GetMapping(value = "/is-upper")
    public ResponseEntity<Boolean> isUpper(@RequestParam String data, @RequestParam String format) {
        var body = stringApiClient.isUpper(data).getBody();
        var mediaType = parseMediaType(format);
        return responseWithMediaType(body, mediaType);
    }

    private <T> ResponseEntity<T> responseWithMediaType(T body, MediaType mediaType) {
        var headers = new HttpHeaders();
        headers.setContentType(mediaType);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(body);
    }

    private MediaType parseMediaType(String format) {
        switch (format) {
            case "json":
                return MediaType.APPLICATION_JSON;
            case "xml":
                return MediaType.APPLICATION_XML;
            case "txt":
                return MediaType.TEXT_PLAIN;
            case "csv":
                return MediaTypeExtended.TEXT_CSV;
            default:
                throw new IncorrectMediaTypeException(format, "Given format is not supported");
        }
    }
}
