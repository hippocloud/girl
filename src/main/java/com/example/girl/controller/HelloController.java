package com.example.girl.controller;


import com.example.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value={"/hello","/hi"},method =RequestMethod.GET)
    @GetMapping(value={"/hello","/hi"})
    public String say(@RequestParam(value="id",required=false,defaultValue = "0") Integer myid){
      // return girlProperties.getCupSize()+"hello spring boot!";
        return "id"+myid;
    }
    //@RequestParam比@PathVariable好用
}
