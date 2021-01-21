package com.albo.comics.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
//@Document(collection = "heroes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Heroe {

  //@Id
  private Integer id;
  private String name;
  private String last_sync;
  private String[] colorists;
  private String[] writers;
  private String[] editors;;
  private List<CharacterModel>  characters;
}
