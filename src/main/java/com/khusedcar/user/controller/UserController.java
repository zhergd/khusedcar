package com.khusedcar.user.controller;

import com.khusedcar.user.entities.Key;
import com.khusedcar.user.entities.TSalesman;
import com.khusedcar.user.entities.TSuperAdmin;
import com.khusedcar.user.service.UserService;
import com.khusedcar.utils.GeneralToken;
import com.khusedcar.utils.GeneralUUIDUtil;
import com.khusedcar.utils.ResultVO;
import com.khusedcar.utils.ResultVOUtil;
import com.khusedcar.utils.enums.ResultEnums;
import com.khusedcar.utils.reqdto.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by Jobzher
 * @date 2018-10-29 21:55
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param dto
     * @param session
     * @return
     */
    @PostMapping(value = "/login")
    public ResultVO login(LoginDTO dto, HttpSession session) {
        dto.md5Encode();
        log.info("【登陆】 用户名={},密码={}", dto.getUsername(), dto.getPassword());
        TSalesman tSalesman = userService.login(dto.getUsername(), dto.getPassword());
        if (tSalesman == null) {
            return ResultVOUtil.failed(ResultEnums.LOGIN_FAILED);
        }
        session.setAttribute("username", tSalesman);
        return ResultVOUtil.success(null, ResultEnums.SUCCESS);
    }

    /**
     * 注销
     * @param session
     * @return
     */
    @GetMapping(value = "/written")
    public ResultVO written(HttpSession session){
        session.removeAttribute("username");
        return ResultVOUtil.success(null,ResultEnums.SUCCESS);
    }


    /**
     * 注册用户
     *
     * @param dto
     * @return
     */
    @PostMapping(value = "/addUser")
    public ResultVO addUser(RegistyDTO dto) {
        dto.md5Encode();
        log.info("【用户注册】 请求参数 = {}", dto);
        TSalesman tSalesman = userService.findUserByName(dto.getUsername());
        if (tSalesman != null) {
            log.info("【用户注册】 该账号已存在,请重新输入");
            return ResultVOUtil.failed(ResultEnums.REGISTYFAILED);
        }
        boolean result = userService.addUesr(dto);
        if (result) {
            Integer tSalesman1 = userService.upKey(dto.getInvitationCode());
        } else {
            log.info("【用户注册】 请填写正确的邀请码");
            return ResultVOUtil.failed(ResultEnums.USER_UPKEY_ERROR);
        }
        return ResultVOUtil.success(null, ResultEnums.SUCCESS);
    }

    /**
     * 从session获取用户信息
     * @param session
     * @return
     */
    @GetMapping(value = "/getUser")
    public ResultVO getUser(HttpSession session) {
        TSalesman tSalesman = (TSalesman) session.getAttribute("username");
        return ResultVOUtil.success(tSalesman, ResultEnums.SUCCESS);
    }

    /**
     * 更改用户信息
     *
     * @param dto
     * @return
     */
    @PostMapping(value = "/upUser")
    public ResultVO upUser(UserDTO dto,HttpSession session) {
        TSalesman tSalesman = (TSalesman) session.getAttribute("username");
        dto.setId(tSalesman.getId());
        log.info("【更改用户信息】 请求参数 = {}", dto);
        boolean result = userService.upUser(dto);
        return result ? ResultVOUtil.success(null, ResultEnums.SUCCESS) : ResultVOUtil.failed(ResultEnums.USER_UPDATA_ERROR);
    }

    /**
     * 更改用户密码
     *
     * @param dto
     * @return
     */
    @GetMapping(value = "/upPassword")
    public ResultVO upPassword(PasswordDTO dto,HttpSession session) {
        dto.md5Encode();
        TSalesman tSalesman = (TSalesman) session.getAttribute("username");
        dto.setId(tSalesman.getId());
        log.info("【更改用户密码】 请求参数 = {}", dto);
        boolean result = userService.upPassword(dto);
        return result ? ResultVOUtil.success(null, ResultEnums.SUCCESS) : ResultVOUtil.failed(ResultEnums.USER_UPDATA_ERROR);
    }

    /**
     * 锁定用户
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/deleteUser")
    public ResultVO deleteUser(@RequestParam(value = "id") String id) {
        Integer result = userService.deleteUser(id);
        return result > 0 ? ResultVOUtil.success(null, ResultEnums.SUCCESS) : ResultVOUtil.failed(ResultEnums.USER_DELECT_ERROR);
    }

    /**
     * 生成邀请码
     *
     * @return
     */
    @GetMapping(value = "/newKey")
    public ResultVO newKey() {
        Integer result = userService.newKey();
        return result > 0 ? ResultVOUtil.success(result, ResultEnums.SUCCESS) : ResultVOUtil.failed(ResultEnums.USER_NEWKEY_ERROR);
    }

    /**
     * 查询所有Key
     *
     * @param key
     * @return
     */
    @GetMapping(value = "/findKey")
    public ResultVO findKey(Key key) {
        List<Key> keyList = userService.findKey(key);
        return keyList != null ? ResultVOUtil.success(keyList, ResultEnums.SUCCESS) : ResultVOUtil.failed(null);
    }

    /**
     * 根据安全问题找回密码
     *
     * @param dto
     * @return
     */
    @PostMapping(value = "/retrievePassword")
    public ResultVO retrievePassword(RetrievePasswordDTO dto) {
        dto.md5Encode();
        log.info("【根据安全问题找回密码】 请求参数 = {}", dto);
        boolean result = userService.retrievePassword(dto);
        if (result) {
            return ResultVOUtil.success(null, ResultEnums.SUCCESS);
        } else {
            return ResultVOUtil.failed(ResultEnums.USER_RETRIEVE_ERROR);
        }
    }

    /**
     * 管理员登录校验
     *
     * @param tSuperAdmin
     * @return
     */
    @GetMapping(value = "/superAdmin/login")
    public ResultVO adminLogin(TSuperAdmin tSuperAdmin) {
        log.info("【登陆】 用户名={},密码={}", tSuperAdmin.getUsername(), tSuperAdmin.getPassword());
        TSuperAdmin tSuperAdmin1 = userService.adminLogin(tSuperAdmin.getUsername(), tSuperAdmin.getPassword());
        if (tSuperAdmin1 == null) {
            return ResultVOUtil.failed(ResultEnums.LOGIN_FAILED);
        }
        String token = GeneralToken.getToken(tSuperAdmin1.getUsername());
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        return ResultVOUtil.success(Arrays.asList(result), ResultEnums.SUCCESS);
    }

}
