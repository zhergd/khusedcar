package com.khusedcar.car.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.khusedcar.car.entities.TCar;
import com.khusedcar.car.service.TCarService;
import com.khusedcar.user.entities.TSalesman;
import com.khusedcar.utils.ResultVO;
import com.khusedcar.utils.ResultVOUtil;
import com.khusedcar.utils.enums.ResultEnums;
import com.khusedcar.utils.reqdto.car.carRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @author Created by Jobzher
 * @date 2018-11-01 0:00
 */
@Slf4j
@RestController
@RequestMapping("/car")
public class TCarController {

    @Autowired
    private TCarService tCarService;

    @GetMapping("/findAllCar")
    public ResultVO<PageInfo<TCar>> findAllCar( TCar tCar
                               ,@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "5")Integer pageSize
                               ) {
        PageInfo<TCar> pageInfo = tCarService.findAllCar(tCar,pageNum,pageSize);
        if (pageInfo != null) {
            return ResultVOUtil.success(pageInfo, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.CAR_FINDBY_ERROR);
        }
    }

    @GetMapping("/findCar")
    public ResultVO<List<TCar>> findCar(@RequestParam(value = "name")String name){
        List<TCar> carList = tCarService.findCar(name);
        if (carList != null){
            return ResultVOUtil.success(carList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.CAR_FINDBY_ERROR);
        }
    }

    @GetMapping("/findCarBy")
    public ResultVO<List<TCar>> findCarBy(@RequestParam(value = "brand", required = false) String brand,
                              @RequestParam(value = "price", required = false) String price,
                              @RequestParam(value = "carAge", required = false) String carAge,
                              @RequestParam(value = "mileage", required = false) String mileage,
                              @RequestParam(value = "colour", required = false) String colour,
                              @RequestParam(value = "fuelType", required = false) String fuelType
//                              ,@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
//                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize
                              ){
        List<TCar> carList = tCarService.findCarBy(brand, price, carAge, mileage, colour, fuelType);
        if (carList != null) {
            return ResultVOUtil.success(carList, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.CAR_FINDBY_ERROR);
        }
    }

    @GetMapping("/findCarById")
    public ResultVO<List<TCar>> findCarById(String salesmanName,HttpSession session){
        TSalesman tSalesman = (TSalesman) session.getAttribute("username");
        salesmanName = tSalesman.getName();
        log.info("【根据id查找车辆信息】 请求参数 = {}",salesmanName);
        List<TCar> carList = tCarService.findCarById(salesmanName);
        if (carList != null){
            return ResultVOUtil.success(carList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.CAR_FINDBY_ERROR);
        }
    }

    @PostMapping("/addCar")
    public ResultVO addCar(HttpServletRequest request,MultipartFile file, HttpSession session) {
        TSalesman tSalesman = (TSalesman) session.getAttribute("username");
        TCar tCar = new TCar();
        tCar.setSalesmanName(tSalesman.getName());
        tCar.setSalesmanPhone(tSalesman.getPhone());
        tCar.setCompanyName(tSalesman.getCompanyName());
        try {
            MultipartHttpServletRequest multipartRequest = null;
            MultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                multipartRequest = (MultipartHttpServletRequest) request;

                InputStream stream = multipartRequest.getInputStream();
                String filePath = "D://data/";
                FileOutputStream fileOutputStream = new FileOutputStream(filePath + "1.jpg");
                byte temp[] = new byte[1024];
                int index = 0;
                while((index=stream.read(temp))!=-1){
                    fileOutputStream.write(temp,0,index);
                }
                tCar.setImg(filePath+"1.jpg");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("【上报车辆】 请求参数 = {}",tCar);
        boolean carList = tCarService.addCar(tCar);
        if (carList) {
            return ResultVOUtil.success(null, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.CAR_ADD_ERROR);
        }
    }

    @GetMapping("/finishCar")
    public ResultVO finishCar(@RequestParam(value = "id") String id) {
        log.info("【车辆交易完成】 业务员id = {}", id);
        boolean carType = tCarService.finishCar(id);
        if (carType) {
            return ResultVOUtil.success(null, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.CAR_FINISH_ERROR);
        }
    }

    @GetMapping("/deleteCar")
    public ResultVO deleteCar(@RequestParam(value = "id") Integer id) {
        log.info("【车辆信息删除】 业务员id = {}", id);
        boolean carType = tCarService.deleteCar(id);
        if (carType) {
            return ResultVOUtil.success(null, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.CAR_DELETE_ERROR);
        }
    }

    @GetMapping("/lockingCar")
    public ResultVO lockingCar(@RequestParam(value = "id") Integer id){
        log.info("【车辆信息锁定】 请求参数 = {}",id);
        Integer result = tCarService.lockingCar(id);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.CAR_LOCKING_ERROR);
        }
    }

    @GetMapping("/carRecord")
    public ResultVO<List<carRecordDTO>> carRecord(carRecordDTO dto){
        log.info("【操作记录】 请求参数 = {}",dto);
        List<carRecordDTO> carRecordDTOList = tCarService.carRecord(dto);
        if (carRecordDTOList != null){
            return ResultVOUtil.success(carRecordDTOList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_RECORD_ERROR);
        }
    }

    @GetMapping("/findCarSalesRecords")
    public ResultVO<List<carRecordDTO>> findCarSalesRecords(carRecordDTO dto){
        log.info("【查看交易记录】 请求参数 = {}",dto);
        List<carRecordDTO> carRecordDTOList = tCarService.findCarSalesRecords(dto);
        if (carRecordDTOList != null){
            return ResultVOUtil.success(carRecordDTOList,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.CAR_FINDBY_ERROR);
        }
    }

    @GetMapping("/recoveryCar")
    public ResultVO recoveryCar(@RequestParam(value = "id") Integer id){
        log.info("【操作恢复】 请求参数 = {}",id);
        Integer result = tCarService.recoveryCar(id);
        if (result > 0){
            return ResultVOUtil.success(null,ResultEnums.SUCCESS);
        }else {
            return ResultVOUtil.failed(ResultEnums.ADMIN_RECOVERY_ERROR);
        }
    }

}
