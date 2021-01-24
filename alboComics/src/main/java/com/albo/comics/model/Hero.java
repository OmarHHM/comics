package com.albo.comics.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* Domain for Hero.
*/
@Getter
@Setter
@Accessors(
  chain =true,
  fluent=false
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "heroes")
public class Hero {

  /**
   * Hero's id.
   *
   * @param heroId Hero's id.
   * @return Hero's id.
   */
  @Id
  private Integer heroId;
  
  /**
   * Hero name.
   *
   * @param name Hero name.
   * @return Hero name.
   */
  private String name;
  
  /**
   * Hero lastSync.
   *
   * @param lastSync Hero lastSync.
   * @return Hero lastSync.
   */
  @JsonProperty("last_sync")
  private String lastSync;
  
  /**
   * Hero colorists.
   *
   * @param colorists Hero colorists.
   * @return Hero colorists.
   */
  private String[] colorists;
  
  /**
   * Hero writers.
   *
   * @param writers Hero writers.
   * @return Hero writers.
   */
  private String[] writers;
  
  /**
   * Hero editors.
   *
   * @param writers Hero editors.
   * @return Hero editors.
   */
  private String[] editors;
  
  /**
   * Hero characters.
   *
   * @param writers Hero characters.
   * @return Hero characters.
   */
  private List<CharacterModel> characters;

  @Override
  public String toString() {
    
    return
      "Hero [id=" + heroId +
      ", name=" + name +
      ", lastSync=" + lastSync +
      ", colorists=" + Arrays.toString(colorists) +
      ", writers=" + Arrays.toString(writers) +
      ", editors=" + Arrays.toString(editors) +
      ", characters=" + characters + "]";
    
  }
  
}
