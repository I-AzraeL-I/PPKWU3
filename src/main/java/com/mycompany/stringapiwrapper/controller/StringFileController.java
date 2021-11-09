package com.mycompany.stringapiwrapper.controller;

import com.mycompany.stringapiwrapper.service.StringApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StringFileController {

    private final StringApiClient stringApiClient;

    @GetMapping("/is-word")
    public ResponseEntity<Boolean> isAlpha(@RequestParam("data") String data) {
        return stringApiClient.isAlpha(data);
    }
}
