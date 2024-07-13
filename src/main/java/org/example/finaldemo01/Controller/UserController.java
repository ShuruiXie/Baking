package org.example.finaldemo01.Controller;


import org.example.finaldemo01.mapper.UserMapper;
import org.example.finaldemo01.pojo.dto.UserLoginDTO;
import org.example.finaldemo01.pojo.dto.UserRegDTO;
import org.example.finaldemo01.pojo.dto.UserUpdateDTO;
import org.example.finaldemo01.pojo.entity.User;
import org.example.finaldemo01.pojo.vo.UserVO;
import org.example.finaldemo01.response.JsonResult;
import org.example.finaldemo01.response.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @PostMapping("/reg")
    public JsonResult reg(@RequestBody UserRegDTO userRegDTO){
        UserVO userVO = userMapper.selectUserByUserName(userRegDTO.getUserName());
        // 根据用户名查询用户是否存在
        if(userVO != null){
            // 用户名已存在
            return new JsonResult(StatusCode.USERNAME_ERROR);
        }
        if(userRegDTO.getUserName()==null){
            System.out.println("用户名不能为空");
        }
        User user = new User();
        BeanUtils.copyProperties(userRegDTO, user); // 将UserRegDTO对象中的属性复制到User对象中
        user.setCreateTime(new Date());

        userMapper.insertUser(user);
        return JsonResult.ok();
    }

    @PostMapping("/login")
    public JsonResult login(@RequestBody UserLoginDTO userLoginDTO, HttpSession session){
        UserVO userVO = userMapper.selectUserByUserName(userLoginDTO.getUserName());
        // 根据用户名查询用户是否存在
        if(userVO == null){
            return new JsonResult(StatusCode.USERNAME_ERROR);
        }
        if(!userVO.getPassword().equals(userLoginDTO.getPassword())){
            return new JsonResult(StatusCode.PASSWORD_ERROR);
        }
        session.setAttribute("user", userVO);
        return JsonResult.ok(userVO);
    }

    @GetMapping("logout")
    public JsonResult logout(HttpSession session) {
        session.removeAttribute("user");
        return JsonResult.ok();
    }

    @GetMapping
    public JsonResult selectAll(){
        return JsonResult.ok(userMapper.selectAllUser());
    }

    @PostMapping("/update")
    public JsonResult update(@RequestBody UserUpdateDTO userUpdateDTO)
    {

        if(userUpdateDTO.getImgUrl() != null){
            //得到图片的路径
            String imgUrl = userMapper.selectImgUrlById(userUpdateDTO.getId());
            //删除原来的图片
            new File(imgUrl).delete();
        }
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        userMapper.updateUserById(user);
        return JsonResult.ok();
    }


}
