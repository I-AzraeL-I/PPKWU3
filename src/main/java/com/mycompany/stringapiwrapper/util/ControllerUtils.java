package com.mycompany.stringapiwrapper.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ControllerUtils {

    public static <T> ResponseEntity<?> preparedResponse(T body, MediaType mediaType) {
        if (mediaType == null) {
            return ResponseEntity.badRequest().build();
        }
        var headers = getContentHeaders(mediaType);
        if (mediaType.equals(MediaType.TEXT_PLAIN)) {
            return responseOk(headers, body.toString());
        }
        return responseOk(headers, body);
    }

    public static <T> ResponseEntity<T> responseOk(HttpHeaders httpHeaders, T body) {
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(body);
    }

    public static HttpHeaders getContentHeaders(MediaType mediaType) {
        var responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(mediaType);
        return responseHeaders;
    }

    public static MediaType parseMediaType(String format) {
        switch (format) {
            case "json":
                return MediaType.APPLICATION_JSON;
            case "xml":
                return MediaType.APPLICATION_XML;
            case "txt":
                return MediaType.TEXT_PLAIN;
            default:
                return null;
        }
    }
}
