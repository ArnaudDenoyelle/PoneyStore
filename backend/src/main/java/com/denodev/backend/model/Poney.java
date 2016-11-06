package com.denodev.backend.model;

/**
 * @author Arnaud DENOYELLE
 *
 *         Le 06 nov. 2016
 */
public class Poney {

  private Integer id;
  private String name;

  public Poney() {
  }

  public Poney(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
