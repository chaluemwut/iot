package nsc.iot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "console")
public class Console {

    public ModelAndView index(){
        ModelAndView view = new ModelAndView("console/index");
        return view;
    }
}
