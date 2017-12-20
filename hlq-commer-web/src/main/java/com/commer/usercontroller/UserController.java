package com.commer.usercontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.commer.app.UserService.UserService;
import com.commer.shiroconfig.ShiroToken;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.commer.entity.User;
import java.util.Map;
@Controller
@RequestMapping("/user") 
public class UserController extends BaseController{
	private static Logger logger = Logger.getLogger(UserController.class);  
	   
	@Resource  
    private UserService userService;
	@RequestMapping("/getUserById")
    public Object getUserById() {  
        User user = userService.selectByPrimaryKey(1);  
        if(user!=null){  
            System.out.println("user.getName():"+user.getUsername());  
            logger.info("user.getAge():"+user.getUsername());  
        }  
        return user;  
    }  
	
	@GetMapping("/login")
    public String login() {
		return "/default/login";
    }
    @GetMapping("/firstPage")
    public String index_14() {
        return "/default/index_v148b2";
    }

    @GetMapping("/index")
    public String index() {
        return "/default/index";
    }
    /**
     * 登录提交
     * @param entity		登录的UUser
     * @param rememberMe	是否记住
     * @param request		request，用来取登录之前Url地址，用来登录后跳转到没有登录之前的页面。
     * @return
     */
    @RequestMapping(value="submitLogin",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submitLogin(User entity, Boolean rememberMe, HttpServletRequest request){
        String url = null ;
        ShiroToken token = new ShiroToken(entity.getUsername(),entity.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);

            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");
            url="/user/index";

            //跳转地址
            resultMap.put("back_url", url);
        } catch (UnknownAccountException uae) {
            //用户名不存在
            resultMap.put("status", 500);
            resultMap.put("message", "用户名不存在");
            logger.info("用户名或密码错误");
        }catch (IncorrectCredentialsException ice) {
            //密码错误
            resultMap.put("status", 500);
            resultMap.put("message", "密码错误");
            logger.info("用户名或密码错误");
        }catch (LockedAccountException lae) {
            //账户被锁定
            resultMap.put("status", 500);
            resultMap.put("message", "账户被锁定");
            logger.info("账户被锁定");
        }catch(ExcessiveAttemptsException eae){
            //登录失败次数超过系统最大次数,请稍后重试
            resultMap.put("status", 500);
            resultMap.put("message", "登录失败次数超过系统最大次数,请稍后重试!");
            logger.info("登录失败次数超过系统最大次数,请稍后重试!");
        }catch (Exception e) {
            //出现其他异常
            resultMap.put("status", 500);
            resultMap.put("message", "登录失败次数超过系统最大次数,请稍后重试!");
        }
        return resultMap;
    }
	
	@RequestMapping("/customer_index")
    public ModelAndView BackstageIndex(HttpServletRequest request, HttpSession session) {
		
		//判断如果服务器存在用户session的话，不需要重新登录来访问该(配置拦截设置)
		if (session.getAttribute("user") != null)
            return new ModelAndView("customer_index");

        // 跳转登录页面
		return new ModelAndView("login");
    }

}
