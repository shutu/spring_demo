/**
 * 
 */
package spring.demo.errorhandling.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangoo
 * @since 2016-11-27 21:45
 *
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
