package com.stacksimplify.restservices.Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    //Simple Method
    //URI - /helloworld
    //GET
    //@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/helloworld-bean")
    public UserDetails helloWorldBean() {
        return new UserDetails("Kayan", "Reddy", "Hyderabad");
    }

    @GetMapping("/hello-int")
    public String getMessagesInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {
        return messageSource.getMessage("label.hello", null, new Locale(locale));
    }

    @GetMapping("/hello-int2")
    public String getMessagesInI18NFormat2() {
        return messageSource.getMessage("local.hello", null, LocaleContextHolder.getLocale());
    }
}
