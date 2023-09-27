package org.szh.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    UserService userService;

    /**
     * set方法注入 这种方式就是为属性添加一个set方法，然后把注解放在方法上面。虽然看起来有点多余 但这个也是Spring官方推荐注入的一种写法。
     *原因是注解直接加在属性上 没有set方法的话，那么当前类就只能在容器中完成初始化，如果用户想new一个当前对象就不可以。因为无法给userService
     * 设置值，如果有了set方法，则当前Bean既可以在容器中使用 也可以new出来使用
     * @param userService
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 这个是构造器注入，当Spring容器初始化userController的时候，会调用这个构造方法，结果这个构造方法需要UserService参数,
     * 那么Spring容器会去容器中查找是否存在UserService实例 如果存在 直接使用之
     *
     * ps: Spring官方实际上推荐我们使用构造器的方式去注入Bean，而不是通过@Autowired注解去注入Bean。原因在于，一个类可以被
     * 注入到Spring容器中，也可以自己new 出来去使用。如果是自己new出来去使用的话，得有一个方式给Bean传参数进去。那么构造器就是
     * 最好的方式，防止用户忘记初始化值 进而导致空指针。但在实际开发中，使用注解注入的方式要多于构造器注入的方式。
     * @param userService
     */
    //如果存在多个构造方法 可以使用@Autowired 指明具体使用哪一个
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    public UserController() {
//    }


    public String hello() {
        return userService.hello();
    }
}
