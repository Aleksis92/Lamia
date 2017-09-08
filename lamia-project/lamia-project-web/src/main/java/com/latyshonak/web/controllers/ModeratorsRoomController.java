package com.latyshonak.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ModeratorsRoomController {

    @RequestMapping(value = "/ModeratorsRoom")
    public String moderatorsRoomReturn() {
        return "moderatorsRoom";
    }



}
