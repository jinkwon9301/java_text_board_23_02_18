package com.sbs.exam.board;

public class Member {
  int id;
  String loginId;
  String loginPw;

  Member(int id, String title, String body) {
    this.id = id;
    this.loginId = title;
    this.loginPw = body;
  }

  @Override
  public String toString() {
    return String.format("{id : %d, loginId : \"%s\", loginPw : \"%s\"}", id, loginId, loginPw);
  }
}
