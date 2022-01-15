package com.example.springboot.putcontroller;

import com.example.springboot.dto.PostRequestDto2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PostRequestDto2 put(@RequestBody PostRequestDto2 requestDto, @PathVariable Long userId){
        System.out.println(userId);
        return requestDto;
    }

}
