package minki.submit13.main;

import java.util.ArrayList;
import java.util.Scanner;

import minki.submit13.service.BoardService;
import minki.submit13.service.HomepageService;
import minki.submit13.vo.BoardVO;
import minki.submit13.vo.HomepageVO;

public class HomepageMain {

	public static void main(String[] args) {
		HomepageService hservice = HomepageService.getInstance();
		BoardService bservice = BoardService.getInstance();
		Scanner scan = new Scanner(System.in);
		int select = 0;
		String nowid = "";

		outer: while (true) {
			System.out.println("행동을 선택해 주세요.");
			System.out.println("1. 회원 가입 | 2. 로그인 | 3. 종료");
			System.out.print(">>>");
			try {
				select = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e1) {
				System.out.println("잘못된 범위의 값입니다.");
			}
			System.out.println("\n============================\n");

			// 1. 회원 가입 및 중복 체크
			if (select == 1) {
				System.out.println("아이디를 입력해주세요 : ");
				String id = scan.nextLine();
				// 여기서 중복 체크코드 작성하기
				ArrayList<HomepageVO> custList = hservice.getCustList();
				for (int i = 0; i < custList.size(); i++) {
					HomepageVO vo = new HomepageVO(id);
					String a = custList.get(i).getCustId();
					if (id.equals(a)) {
						System.out.println("중복된 아이디입니다. 다른 아이디를 입력해주세요.");
						continue outer;
					}
				}
				System.out.println("비밀번호를 입력해주세요 : ");
				String pw = scan.nextLine();
				HomepageVO vo = new HomepageVO(id, pw);
				hservice.registCustomer(vo);

				// 2. 로그인
			} else if (select == 2) {
				System.out.print("아이디를 입력해 주세요 :");
				String id = scan.nextLine();
				System.out.print("비밀번호를 입력해 주세요 : ");
				String pw = scan.nextLine();
				boolean check = false;
				ArrayList<HomepageVO> custList = hservice.getCustList();
				for (HomepageVO vo : custList) {
					if (vo.getCustId().equalsIgnoreCase(id) && vo.getCustPw().equalsIgnoreCase(pw)) {
						check = true;
						nowid = vo.getCustId();
						break;
					}
				}
				if (check == true) {
					System.out.println("로그인 되었습니다.");
					System.out.println("\n================\n");
					outer2: while (true) {
						System.out.println("행동을 선택해주세요");
						System.out.println("1. 글쓰기 | 2. 글조회 | 3. 로그아웃");
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("잘못된 범위의 값입니다.");
						}

						if (select == 1) {
							System.out.print("글 제목을 입력해 주세요 : ");
							String title = scan.nextLine();
							System.out.print("글 내용을 입력해 주세요 : ");
							String text = scan.nextLine();
							ArrayList<BoardVO> no = bservice.getNo();
							int i = 0, number = 0;
							for (BoardVO vo : no) {
								number = no.get(i).getNo();
								i++;
							}
							BoardVO vo = new BoardVO(number + 1, title, text, nowid);
							System.out.println(vo);
							bservice.writeBoard(vo);

						} else if (select == 2) {
							// TODO 글 조회
							BoardVO boardList = bservice.getBoardList();
							if (boardList.getTitle() == null) {
								System.out.println("존재하지 않는 게시글 번호입니다.");
							} else {
								System.out.println("===========================");
								;
								System.out.println("제목 : " + boardList.getTitle());
								System.out.println("작성자 : " + boardList.getUser());
								System.out.println("작성일 : " + boardList.getDates());
								System.out.println("글 내용 : " + boardList.getText());
								System.out.println("===========================");

								ArrayList<BoardVO> List = bservice.getAllBoardList();
								for (int i = 0; i < List.size(); i++) {
									System.out.println(List.get(i).getNo() + "|" + List.get(i).getTitle() + "|"
											+ List.get(i).getUser() + "|" + List.get(i).getDates());
								}
							}
						} else if (select == 3) {
							System.out.println("로그아웃 되었습니다.");
							break;
						} else {
							System.out.println("다시 입력해주세요");
							continue outer2;
						}
					}
				} else {
					System.out.println("잘못된 회원정보입니다.");
					System.out.println("\n=======================\n");
				}

				// 3. 홈페이지 종료
			} else if (select == 3) {
				System.out.println("다음에 또 방문해주세요! 감사합니다!");
				break;
			} else {
				System.out.println("다시 입력해 주세요.");
			}
		}
	}

}
