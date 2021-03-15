package Hello.HelloSpring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //동적 방식
    @GetMapping("hello") //URL Parameter
    public String hello(Model model)
    {
        model.addAttribute("data", "hello!!"); //html 파일에 data로 hello로 넘겨줌
        return "hello"; //Mapping되는 html 파일
    }

    //MVC Method
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) // URL 파라메터로 변수에 name을 넣음
    {
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody //http body부의 데이터를 직접 넣어주곘다
    public String helloString(@RequestParam("name") String name)
    {
        return "hello " + name; // Hello Name
    }

    //API
    @GetMapping("hello-api")
    @ResponseBody

    public Hello helloApi(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello
    {
        private String name;

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }
    }
}
