package com.sbs.exam.board;

import java.util.ArrayList;
import java.util.List;

public class UsrMemberController {
  private int memberLastId;
  private static List<Member> members;

  UsrMemberController() {
    memberLastId = 0;
    members = new ArrayList<>();

    makeTestData();

    if (members.size() > 0) {
      memberLastId = members.get(members.size() - 1).id;
    }
  }

  void makeTestData() {
    for (int i = 1; i <= 3; i++) {
      members.add(new Member(i, "user" + i, "user" + i));
    }
  }

  public void actionJoin(Rq rq) {
    System.out.println("== 회원 가입 ==");
    System.out.printf("로그인 아이디 : ");
    String loginId = Container.sc.nextLine();
    System.out.printf("로그인 비밀번호 : ");
    String loginPw = Container.sc.nextLine();
    System.out.printf("로그인 비밀번호 확인 : ");
    String loginPwConfirm = Container.sc.nextLine();

    if (loginPw.equals(loginPwConfirm) == false) {
      System.out.println("비밀번호가 일치하지 않습니다.");
      return;
    }

    int id = ++memberLastId;
    Member member = new Member(id, loginId, loginPw);
    members.add(member);

    System.out.printf("%s님 가입을 환영합니다.\n", member.loginId);
    System.out.printf("%d번 회원이 생성 되었습니다.\n", member.id);
  }

  static void actionLogin(Rq rq) {
    System.out.printf("로그인 아이디 : ");
    String loginId = Container.sc.nextLine().trim();

    if (loginId.length() == 0) {
      System.out.println("로그인 아이디를 입력해주세요.");
      return;
    }

    Member member = getMemberLoginId(loginId);

    if (member == null) {
      System.out.println("해당 회원은 존재하지 않습니다.");
      return;
    }

    System.out.printf("로그인 비밀번호 : ");
    String loginPw = Container.sc.nextLine().trim();

    if (loginPw.length() == 0) {
      System.out.println("로그인 비밀번호를 입력해주세요.");
      return;
    }

    if (member.loginPw.equals(loginPw) == false) {
      System.out.println("비밀번호가 일치하지 않습니다.");
      return;
    }

    rq.setSessionAttr("loginedMember", member);

    System.out.printf("%s님 환영합니다.\n", member.loginId);
  }

  private static Member getMemberLoginId(String loginId) {
    for (Member member : members) {
      if (member.loginId.equals(loginId)) {
        return member;
      }
    }
    return null;
  }

  public void actionLogout(Rq rq) {
    Member loginedMember = (Member) Container.session.getAttribute("loginedMember");

    if (loginedMember == null) {
      System.out.println("로그인 후 이용해주세요.");
      return;
    }
    else {
      rq.removeSessionAttr("loginedMember");
    }

    System.out.println("로그아웃 되었습니다.");
  }
}
