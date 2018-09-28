package com.example.girl.service;

import com.example.girl.Repository.GirlRepository;
import com.example.girl.domain.Girl;
import com.example.girl.enums.ResultEnum;
import com.example.girl.exception.GirlExcepion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(11);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBBB");
        girlB.setAge(12);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlExcepion(ResultEnum.PRIMARY_SCHOOL);
        }else if(age >= 10 && age < 18){
            throw new GirlExcepion(ResultEnum.MIDDLE_SCHOOL);
        }else {
            //throw new GirlExcepion(102,"来来来，进来");
        }
    }

    /**
     * 通过id来查询一个女生的信息
     * @param id
     * @return
     */
    public Girl getOne(Integer id){
        return girlRepository.getOne(id);
    }

}
