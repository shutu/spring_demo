/**
 *
 */
package spring.demo.cust.exception.resolver.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.demo.cust.exception.resolver.exception.DatabaseException;

/**
 * @author wangoo
 * @since 2016-11-27 20:36
 */
@RestController
public class ApiController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/api/save")
    @ResponseBody
    public String save() throws DatabaseException {
        throw new DatabaseException("save database failed!");
    }

    @RequestMapping("/unkownerror")
    @ResponseBody
    public String unkownerror() throws Exception {
        throw new Exception("unknown exception!");
    }
}
