package spring.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import spring.cache.demo.Bar;
import spring.cache.service.BarService;

/**
 * Class BarController
 *
 * @author wangoo
 * @since 2017-03-03 10:21
 */
@RestController
@RequestMapping(path = "/")
public class BarController {

    @Autowired
    BarService barService;

    @RequestMapping(path = "/customer_bar", method = RequestMethod.GET)
    public Bar getCustomerBar(@RequestParam("id") long id) throws IOException {
        return barService.getCustomerBar(id);
    }

}
