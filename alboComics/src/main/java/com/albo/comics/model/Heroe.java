package com.albo.comics.model;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* Domain for Heroe.
*/
@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Heroe {

  /**
   * Heroe's id.
   *
   * @param id Heroe's id.
   * @return Heroe's id.
   */
  private Integer id;
  
  /**
   * Heroe name.
   *
   * @param name Heroe name.
   * @return Heroe name.
   */
  private String name;
  
  /**
   * Heroe lastSync.
   *
   * @param lastSync Heroe lastSync.
   * @return Heroe lastSync.
   */
  @JsonProperty("last_sync")
  private String lastSync;
  
  /**
   * Heroe colorists.
   *
   * @param colorists Heroe colorists.
   * @return Heroe colorists.
   */
  private String[] colorists;
  
  /**
   * Heroe writers.
   *
   * @param writers Heroe writers.
   * @return Heroe writers.
   */
  private String[] writers;
  
  /**
   * Heroe editors.
   *
   * @param writers Heroe editors.
   * @return Heroe editors.
   */
  private String[] editors;
  
  /**
   * Heroe characters.
   *
   * @param writers Heroe characters.
   * @return Heroe characters.
   */
  private List<CharacterModel> characters;

  @Override
  public String toString() {
    
    return
      "Heroe [id=" + id +
      ", name=" + name +
      ", lastSync=" + lastSync +
      ", colorists=" + Arrays.toString(colorists) +
      ", writers=" + Arrays.toString(writers) +
      ", editors=" + Arrays.toString(editors) +
      ", characters=" + characters + "]";
    
  }
  
}
