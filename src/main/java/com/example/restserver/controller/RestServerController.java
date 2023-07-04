package com.example.restserver.controller;

import com.example.restserver.common.Result;
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
    public Result<List<Integer>> integerAsc(@RequestBody List<Integer> numbers) {
        List<Integer> sort = restServerService.sort(numbers, true);
        return Result.success(sort);
    }

    @PostMapping("/int/desc")
    public Result<List<Integer>> integerDesc(@RequestBody List<Integer> numbers) {
        List<Integer> sort = restServerService.sort(numbers, false);
        return Result.success(sort);
    }

    @PostMapping("/string/asc")
    public Result<List<String>> stringAsc(@RequestBody List<String> strings) {
        List<String> sort = restServerService.sort(strings, true);
        return Result.success(sort);
    }

    @PostMapping("/string/desc")
    public Result<List<String>> stringDesc(@RequestBody List<String> strings) {
        List<String> sort = restServerService.sort(strings, false);
        return Result.success(sort);
    }

    @PostMapping("/decimal/asc")
    public Result<List<BigDecimal>> decimalAsc(@RequestBody List<BigDecimal> decimals) {
        List<BigDecimal> sort = restServerService.sort(decimals, true);
        return Result.success(sort);
    }

    @PostMapping("/decimal/desc")
    public Result<List<BigDecimal>> decimalDesc(@RequestBody List<BigDecimal> decimals) {
        List<BigDecimal> sort = restServerService.sort(decimals, false);
        return Result.success(sort);
    }

}
