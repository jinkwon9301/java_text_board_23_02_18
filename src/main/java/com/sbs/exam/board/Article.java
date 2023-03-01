package com.sbs.exam.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {
  int id;
  String title;
  String body;

  @Override
  public String toString() {
    return String.format("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
  }
}