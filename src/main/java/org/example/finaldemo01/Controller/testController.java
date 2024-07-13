package org.example.finaldemo01.Controller;

import org.example.finaldemo01.response.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/test")
public class testController {
    //目前Cookie不重要
    @GetMapping("/Cookie1")
    public JsonResult Cookie1(HttpServletResponse response){
        Cookie username = new Cookie("username", "Tom");
        Cookie password = new Cookie("password", "5564545");
        username.setMaxAge(60*60*24*30);
        response.addCookie(username);
        response.addCookie(password);

        return JsonResult.ok();
    }

    @GetMapping("/Cookie2")
    public JsonResult Cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }
        return JsonResult.ok();
    }

    @GetMapping("/session1")
    public JsonResult seection1(HttpSession session){
        session.setAttribute("username", "Tom");
        session.setAttribute("password", "5564545");
        return JsonResult.ok();
    }

    @GetMapping("/session2")
    public JsonResult seection2(HttpSession session){
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        System.out.println(username + " : " + password);
        return JsonResult.ok();
    }
}
