package com.sbs.exam.board;

import java.util.Map;
import java.util.Scanner;

public class App {
  void run() {
    Scanner sc = Container.sc;
    Article lastArticle = null;

    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");
    while (true) {
      System.out.printf("명령 ) ");
      String cmd = Container.sc.nextLine();

      Rq rq = new Rq(cmd);
      Map<String, String> params = rq.getParams();

      if (rq.getUrlPath().equals("exit")) {
        break;
      } else if (rq.getUrlPath().equals("usr/article/list")) {
        Container.usrArticleController.actionList(rq);
      } else if (rq.getUrlPath().equals("usr/article/detail")) {
        Container.usrArticleController.actionDetail(rq);
      } else if (rq.getUrlPath().equals("usr/article/write")) {
        Container.usrArticleController.actionWrite(rq);
      } else if (rq.getUrlPath().equals("usr/article/modify")) {
        Container.usrArticleController.actionModify(rq);
      } else if (rq.getUrlPath().equals("usr/article/delete")) {
        Container.usrArticleController.actionDelete(rq);
      } else if (rq.getUrlPath().equals("usr/member/join")) {
        Container.usrMemberController.actionJoin(rq);
      } else if (rq.getUrlPath().equals("usr/member/login")) {
        Container.usrMemberController.actionLogin(rq);
      } else {
        System.out.printf("입력된 명령어 : %s\n", cmd);
      }
    }

    System.out.println("== 프로그램 종료 ==");

    Container.sc.close();
  }
}
