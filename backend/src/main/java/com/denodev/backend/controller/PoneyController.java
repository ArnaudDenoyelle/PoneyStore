package com.denodev.backend.controller;

import com.denodev.backend.model.Poney;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author Arnaud DENOYELLE
 *
 *         Le 06 nov. 2016
 */
@Controller
@RequestMapping(path = "poneys")
public class PoneyController {

  @ResponseBody
  @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
  public List<Poney> list() {
    return Arrays.asList(
        new Poney(42, "PoneyM"),
        new Poney(43, "Harry Poney"),
        new Poney(44, "Poney for nothing")
    );
  }

  @ResponseBody
  @PreAuthorize("isAuthenticated()")
  @RequestMapping(value = "private", method = RequestMethod.GET)
  public String privateMethod() {
    return "private";
  }

}
