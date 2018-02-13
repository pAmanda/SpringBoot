package br.com.springboot.project.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

  @GetMapping(path="/hello-word")
  public String helloWord(){
    return"Hello Word!";
  }

  @GetMapping(path="/hello-word-bean")
  public HelloWorldBean helloWordBean(){
    return new HelloWorldBean("Hello Word!");
  }
    
  @GetMapping(path="/hello-word-bean/{name}")
  public HelloWorldBean helloWordBeanPathVariable(@PathVariable String name){
    return new HelloWorldBean(String.format("Hello Word, %s!", name));
  }
  
}
