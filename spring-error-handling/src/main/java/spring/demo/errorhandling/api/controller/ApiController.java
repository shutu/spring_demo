/**
 * 
 */
package spring.demo.errorhandling.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.demo.errorhandling.exception.DatabaseException;
import spring.demo.errorhandling.exception.UnconfigException;

/**
 * @author wangoo
 * @since 2016-11-27 20:36
 *
 */
@RestController
public class ApiController {

    @RequestMapping("/api/save")
    @ResponseBody
    public String save() throws DatabaseException {
        throw new DatabaseException("save database failed!");
    }

    @RequestMapping("/unconfigex")
    @ResponseBody
    public String unconfigex() throws UnconfigException {
        throw new UnconfigException("un-config exception!");
    }

    @RequestMapping("/unkownerror")
    @ResponseBody
    public String unkownerror() throws Exception {
        throw new Exception("unknown exception!");
    }
}
