package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 廖师兄
 * 2016-11-03 23:15
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */


    /**
     * 添加一个女生
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getList(){
        List list=girlRepository.findAll();
        return list;
    }
    @PostMapping(value = "/girls")
    //利用Girl作为方法形参，避免了@RequestParam造成的麻烦
//    @Valid和实体类中加上@Min注解来进行表单验证
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtils.error(-1,bindingResult.getFieldError().getDefaultMessage());
        }else {
            return ResultUtils.success(girlRepository.save(girl));
        }
    }
    @GetMapping(value = "/{id}/girls")
    public Girl getGirl(@PathVariable("id") Integer id){
       return girlRepository.findOne(id);
    }
    @PutMapping(value = "/{id}/girls")
    public  Girl updateGirl(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    @DeleteMapping(value = "/{id}/girls")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }
    @GetMapping(value = "/girls/cupSize")
    public List<Girl> findByCupSize(@RequestParam("cupSize")String cupSize){
       return girlRepository.findByCupSize(cupSize);
    }
    @PostMapping(value = "/girls/insertTwo")
    public void insertTwo(){
        girlService.insertTwo();
    }
    @PostMapping(value = "/girls/getage/{id}")
    public void getAge(@PathVariable("id")Integer id){
        girlService.getAge(id);
    }

//    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
//        }
//
//        girl.setCupSize(girl.getCupSize());
//        girl.setAge(girl.getAge());
//
//        return ResultUtil.success(girlRepository.save(girl));
//    }

    //查询一个女生
//    @GetMapping(value = "/girls/{id}")
//    public Girl girlFindOne(@PathVariable("id") Integer id) {
//        return girlRepository.findOne(id);
//    }
//
//    //更新
//    @PutMapping(value = "/girls/{id}")
//    public Girl girlUpdate(@PathVariable("id") Integer id,
//                           @RequestParam("cupSize") String cupSize,
//                           @RequestParam("age") Integer age) {
//        Girl girl = new Girl();
//        girl.setId(id);
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//
//        return girlRepository.save(girl);
//    }
//
//    //删除
//    @DeleteMapping(value = "/girls/{id}")
//    public void girlDelete(@PathVariable("id") Integer id) {
//        girlRepository.delete(id);
//    }
//
//    //通过年龄查询女生列表
//    @GetMapping(value = "/girls/age/{age}")
//    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
//        return girlRepository.findByAge(age);
//    }
//
//    @PostMapping(value = "/girls/two")
//    public void girlTwo() {
//        girlService.insertTwo();
//    }
//
//    @GetMapping(value = "girls/getAge/{id}")
//    public void getAge(@PathVariable("id") Integer id) throws Exception{
//        girlService.getAge(id);
//    }
}
