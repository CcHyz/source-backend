package com.cc.tips.date;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api("/api/date")
public class DateController {
    @Resource
    private DateDtoRepository dateDtoRepository;

    @PostMapping("/create")
    public ResponseEntity crete(@RequestBody DateDto dateDto) {
        dateDtoRepository.save(dateDto);
        return ResponseEntity.ok().build();
    }
}
