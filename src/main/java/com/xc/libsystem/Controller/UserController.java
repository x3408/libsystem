package com.xc.libsystem.Controller;

import com.xc.libsystem.Entity.User;
import com.xc.libsystem.Service.BookService;
import com.xc.libsystem.Service.UserService;
import com.xc.libsystem.Util.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;


    /**
     * 获取用户信息，测试使用
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        return user;
    }

    /**
     * 用户登陆
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public LoginResult login(User user) {
        return userService.login(user);
    }

    /**
     * 用户登陆伴随记住密码功能
     *
     * @param user
     * @param loginSymbol
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping(value = "/user/{loginSymbol}")
    public LoginResult login(
            User user, @PathVariable(value = "loginSymbol") Boolean loginSymbol,
            HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //判断用户是否登陆成功
        LoginResult login = userService.login(user);


        //不成功则直接跳回
        if (!"200".equals(login.getCode())) {
            return LoginResult.failLogin();
        }

        //成功添加自动登陆cookie信息
        Cookie cookie = new Cookie("autoLogin",
                URLEncoder.encode(user.getAccount(), "utf-8") + "#login#" +
                        URLEncoder.encode(user.getPassword(), "utf-8"));
        //设置有效期
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return LoginResult.success(login);
    }

    /**
     * 查询用户收藏书本数
     *
     * @param id
     * @return
     */
    @GetMapping("/user/getCollectBooksNum/{id}")
    public Integer getCollectBooksNum(@PathVariable Integer id) {
        Integer num = bookService.getUserCollectBooksNum(id);
        return num;
    }

    /**
     * 未登录用户返回
     *
     * @return
     */
    @GetMapping("noAuthorization")
    public LoginResult noAuthorization() {
        return LoginResult.noAuthorization();
    }
}
