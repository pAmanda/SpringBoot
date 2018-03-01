package br.com.springboot.project.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

  @Autowired
  public ResourceBundleMessageSource messageSource;

  @GetMapping(path="/hello-world")
  public String helloWord(@RequestHeader(name="Accept-Language", required=false) Locale locale){
    return messageSource.getMessage("good.morning", null,  locale);
  }

  @GetMapping(path="/hello-world-bean")
  public HelloWorldBean helloWordBean(){
    return new HelloWorldBean("Hello World!");
  }
    
  @GetMapping(path="/hello-world-bean/{name}")
  public HelloWorldBean helloWordBeanPathVariable(@PathVariable String name){
    return new HelloWorldBean(String.format("Hello World, %s!", name));
  }

}
