package com.example.springboot.getcontroller;

import com.example.springboot.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")   // http://localhost:8080/api/get/hello
    public String hello(){
        return "get Hello";
    }

    // 예전에 사용하던 방식
    @RequestMapping(path = "/hi", method = RequestMethod.GET)  // get  http://localhost:8080/api/get/hi
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName){
        System.out.println("PathVariable : "+pathName);
        return pathName;
    }

    // http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    // ? key = value & key2 = value2
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    // ?user=steve&email=steve@gmail.com&age=30
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
