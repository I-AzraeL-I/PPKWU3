package com.mycompany.stringapiwrapper.service;

import com.mycompany.stringapiwrapper.controller.dto.Statistics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "string-api-client", url = "localhost:8080/api")
public interface StringApiClient {

    @GetMapping("/is-word")
    ResponseEntity<Boolean> isAlpha(@RequestParam("data") String data);

    @GetMapping("/is-number")
    ResponseEntity<Boolean> isNumber(@RequestParam("data") String data);

    @GetMapping("/is-lower")
    ResponseEntity<Boolean> isLower(@RequestParam("data") String data);

    @GetMapping("/is-upper")
    ResponseEntity<Boolean> isUpper(@RequestParam("data") String data);

    @GetMapping("/statistics")
    ResponseEntity<Statistics> getStatistics(@RequestParam("data") String data);
}
