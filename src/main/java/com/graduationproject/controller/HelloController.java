package com.graduationproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "/login";
    }
   /* @RequestMapping("/topersonalinformation")
    public String topersonalinformation()
    {
        return "personalinformation";
    }
*/
    @RequestMapping("/tomaterialinformation")
    public String tomaterialinformation()
    {
        return "materialinformation";
    }

    @RequestMapping("/tostaffinformation")
    public String tostaffinformation()
    {
        return "staffinformation";
    }

    @RequestMapping("/toinventorymanagement")
    public String toinventorymanagement()
    {
        return "inventorymanagement";
    }

    @RequestMapping("/todesign")
    public String todesign()
    {
        return "design";
    }

    @RequestMapping("/tooffer")
    public String tooffer()
    {
        return "offer";
    }

    @RequestMapping("/toproject")
    public String toproject()
    {
        return "project";
    }

    @RequestMapping("/toprocess")
    public String toprocess()
    {
        return "process";
    }

    @RequestMapping("/toplan")
    public String toplan()
    {
        return "plan";
    }

    @RequestMapping("/tocheck")
    public String tocheck()
    {
        return "check";
    }

    @RequestMapping("/torecord")
    public String torecord()
    {
        return "record";
    }

    @RequestMapping("/toslary")
    public String toslary()
    {
        return "slary";
    }

    @RequestMapping("/topurchase")
    public String topurchase()
    {
        return "purchase";
    }

    @RequestMapping("/tocost")
    public String tocost()
    {
        return "cost";
    }

    @RequestMapping("/tocontract")
    public String tocontract()
    {
        return "contract";
    }

    @RequestMapping("/tostate")
    public String tostate()
    {
        return "state";
    }

    @RequestMapping("/toexpenditure")
    public String toexpenditure()
    {
        return "expenditure";
    }

    @RequestMapping("/toopinion")
    public String toopinion()
    {
        return "opinion";
    }

    @RequestMapping("/tolink")
    public String tolink()
    {
        return "link";
    }

    @RequestMapping("/tomessage")
    public String tomessage()
    {
        return "message";
    }

    @RequestMapping("/tomaintain1")
    public String tomaintain1()
    {
        return "maintain1";
    }

    @RequestMapping("/tomaintain")
    public String tomaintain()
    {
        return "maintain";
    }
}
