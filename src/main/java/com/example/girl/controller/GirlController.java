package com.example.girl.controller;

import com.example.girl.aspect.HttpAspect;
import com.example.girl.domain.Girl;
import com.example.girl.Repository.GirlRepository;
import com.example.girl.domain.Result;
import com.example.girl.service.GirlService;
import com.example.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        logger.info("查查查查查");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value="/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtils.success(girlRepository.save(girl));
    }

    /**
     * 查找一位女生
     * @param id
     * @return
     */

    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.getOne(id);
    }

    /**
     * 更新一位女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);

    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 根据年龄进行查找
     * @param age
     * @return
     */
    @GetMapping(value="/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){//为什么age要pathvariable而不是requestparam
        return girlRepository.findByAge(age);
    }

    @PostMapping(value="/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
