package spring.inject.ctw.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import spring.inject.ctw.service.UserService;

@Configurable(autowire = Autowire.BY_TYPE)
@JsonPropertyOrder
public class User {

    private static Logger log = LoggerFactory.getLogger(User.class);

    @Autowired
    @JsonIgnore
    private UserService userService;

    public void displayDependencies() {
        log.info("userService={}", userService);
    }
}
