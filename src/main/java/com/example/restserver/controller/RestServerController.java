package com.example.restserver.controller;

import com.example.restserver.common.Return;
import com.example.restserver.service.RestServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wei.song
 * @since 2023/7/2 22:16
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/restServer")
public class RestServerController {

    private final RestServerService restServerService;

    @PostMapping("/int/asc")
    public Return<List<Integer>> integerAsc(@RequestBody List<Integer> numbers) {
        List<Integer> sort = restServerService.sort(numbers, true);
        return Return.success(sort);
    }

    @PostMapping("/int/desc")
    public Return<List<Integer>> integerDesc(@RequestBody List<Integer> numbers) {
        List<Integer> sort = restServerService.sort(numbers, false);
        return Return.success(sort);
    }

    @PostMapping("/string/asc")
    public Return<List<String>> stringAsc(@RequestBody List<String> strings) {
        List<String> sort = restServerService.sort(strings, true);
        return Return.success(sort);
    }

    @PostMapping("/string/desc")
    public Return<List<String>> stringDesc(@RequestBody List<String> strings) {
        List<String> sort = restServerService.sort(strings, false);
        return Return.success(sort);
    }

    @PostMapping("/decimal/asc")
    public Return<List<BigDecimal>> decimalAsc(@RequestBody List<BigDecimal> decimals) {
        List<BigDecimal> sort = restServerService.sort(decimals, true);
        return Return.success(sort);
    }

    @PostMapping("/decimal/desc")
    public Return<List<BigDecimal>> decimalDesc(@RequestBody List<BigDecimal> decimals) {
        List<BigDecimal> sort = restServerService.sort(decimals, false);
        return Return.success(sort);
    }

}
