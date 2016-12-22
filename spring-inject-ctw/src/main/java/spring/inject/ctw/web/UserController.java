package spring.inject.ctw.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.inject.ctw.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public User postUser() {
        User user = new User();
        user.setId(System.currentTimeMillis() + "");
        user.setName("hello");
        log.info("user={}", user);
        user.displayDependencies();
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public User postUser(@RequestBody User user) {
        log.info("user={}", user);
        user.displayDependencies();
        new User().displayDependencies();
        return user;
    }
}
