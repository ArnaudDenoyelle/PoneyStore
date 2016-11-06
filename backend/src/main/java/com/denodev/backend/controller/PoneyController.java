package com.denodev.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Arnaud DENOYELLE
 *
 *         Le 06 nov. 2016
 */
@RestController
@RequestMapping(path = "poneys")
public class PoneyController {

  @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
  public String hello() {
    return "Hello";
  }

}
