package com.example.springboot.deletecontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account){

        System.out.println(userId);
        System.out.println(account);

        // delete -> 리소스 삭제, 리소스가 이미 삭제되어 없더라도 200 OK
    }
}
