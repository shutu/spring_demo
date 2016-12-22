package spring.inject.ctw.entity;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import spring.inject.ctw.service.UserService;

@Data
@Slf4j
@Configurable(autowire = Autowire.BY_TYPE)
@JsonPropertyOrder
public class User {

    private String name;

    private String id;

    @Autowired
    @JsonIgnore
    private UserService userService;

    public void displayDependencies() {
        log.info("userService={}", userService);
    }
}
