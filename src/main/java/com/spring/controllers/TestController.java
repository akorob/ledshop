package com.spring.controllers;

/**
 * Created by Andrey on 25.12.2014.
 */


    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.ModelMap;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.ResponseBody;

    import java.util.ArrayList;
    import java.util.List;

    @Controller
    @RequestMapping("/")
    public class TestController {

        private static final Logger log = LoggerFactory.
                getLogger(TestController.class);


        @RequestMapping(method = RequestMethod.GET)
        public String printWelcome(ModelMap model) {
            log.debug("printWelcome");
            model.addAttribute("message", "Hello wogg444rld!");
            return "hello";
        }

        @RequestMapping(value = "/postInfo", method = RequestMethod.POST)
        public @ResponseBody List<String>
        postInfo( @RequestBody List<String> urls){
            log.debug("/getSitesInfo");
            List<String> list = new ArrayList<String>();
            list.add("kkkkkkkkkk");
            list.add("llllllllll");
            return list;
        }

        @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
        public @ResponseBody List<String>	getInfo(){
            log.debug("/getInfo");
            List<String> list = new ArrayList<String>();
            list.add("dddddddddd");
            list.add("ffffffffff");
            return list;
        }

}
