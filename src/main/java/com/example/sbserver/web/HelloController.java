package com.example.sbserver.web;

import com.example.sbserver.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을
 * 현재는 @RestController 선언 하나로 끝낸다
 *
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

    /*
    @RequestMapping(value = "/bodytest", method = RequestMethod.POST)
    public Response post(@RequestBody Response param){
        String printText = param.getValue();
        return new Response(printText == null ? "null" : printText);
    }
    */
}


