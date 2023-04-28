package ch14_jdbc_jsp.main;

import java.util.ArrayList;
import java.util.Scanner;

import ch14_jdbc_jsp.service.StudentService;
import ch14_jdbc_jsp.service.WordGameService;
import ch14_jdbc_jsp.vo.StudentVO;
import ch14_jdbc_jsp.vo.WordGameVO;

//import ch14_jdbc_jsp.context.ConnectionFactory;
//import ch14_jdbc_jsp.context.ConnectionPool;

public class JdbcMain {

	public static void main(String[] args) {

//		ConnectionFactory cf = ConnectionFactory.getInstance();
//		ConnectionPool cp = ConnectionPool.getInstance();

		StudentService stuService = StudentService.getInstance();

		System.out.println("\n" + " _   __                            ______         _____        \n"
				+ "| | / /                            | ___ \\       |  __ \\       \n"
				+ "| |/ /   ___    ___   _ __    __ _ | |_/ /  __ _ | |  \\/  ___  \n"
				+ "|    \\  / _ \\  / _ \\ | '_ \\  / _` ||  __/  / _` || | __  / _ \\ \n"
				+ "| |\\  \\| (_) || (_) || | | || (_| || |    | (_| || |_\\ \\| (_) |\n"
				+ "\\_| \\_/ \\___/  \\___/ |_| |_| \\__, |\\_|     \\__,_| \\____/ \\___/ \n"
				+ "                              __/ |                            \n"
				+ "                             |___/                             \n" + "");
		System.out.println("쿵파고에 오신걸 환영합니다.");
		System.out.println("데이터 불러오는 중..");
		WordGameService wordService = WordGameService.getInstance();
		ArrayList<WordGameVO> wordGameList = wordService.getWordList();
		ArrayList<String> wordList = new ArrayList<>();

		for (int i = 0; i < wordGameList.size(); i++) {
			wordList.add(wordGameList.get(i).getWords());
		}

		Scanner scan = new Scanner(System.in);

		while (true) {
			int command = 0;
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원목록 조회 | 4. 종료");
			System.out.print(">>> ");
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}

			if (command == 1) {
				// 로그인
				System.out.print("아이디 :");
				String id = scan.nextLine();

				System.out.println("비밀번호 : ");
				String pw = scan.nextLine();

				StudentVO student = new StudentVO();
				student.setStuId(id);
				student.setStuPassword(pw);

				StudentVO login = stuService.login(student);

				if (login.getStuId() != null) {
					// 로그인 성공
					System.out.println(login.getStuName() + "님 환영합니다.");

					// TODO 끝말잇기 시작
					// DB 연동 순서 ( 1. VO 만들고(SELECT문 매핑객체), 2. DAO 만들고(쿼리문 작성), 3. SERVICE 만들기(dao
					// 메소드 실행문))
					while (true) {
						System.out.println("행동을 선택해주세요.");
						System.out.println("1. 끝말잇기 시작 | 2. 랭킹 | 3. 로그아웃");
						System.out.print(">>> ");

						int select = 0;
						try {
							select = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("숫자로 입력해주세요");
							continue;
						}
						if (select == 1) {
							// 제시어 출력
							// wordList에서 랜덤 인덱스의 단어를 하나 출력
							int randIdx = (int) (Math.random() * wordList.size());
							String computerWord = wordList.get(randIdx);
							System.out.println("제시어 : " + computerWord);
							while (true) {
								// 1. userWord가 wordList 안에 포함되어 있는지 체크
								// 2. userWord의 앞글자가 computerWord의 뒷글자와 같은지 체크
								System.out.print(">>> ");
								String userWord = scan.nextLine();
								boolean checkOne = wordList.contains(userWord);
								boolean checkTwo = userWord.substring(0, 1)
										.equals(computerWord.substring(computerWord.length() - 1));

								if (checkOne && checkTwo) {
									// 잘 대답한 것

									// 컴퓨터가 userWord에 대해 끝말잇기 진행
									// userWord의 마지막 글자로 시작하는 단어들을
									// wordList에서 꺼내기(=컴퓨터가 대답할 수 있는 단어들의 목록)
									ArrayList<String> comAnswerList = new ArrayList<>();

									for (int i = 0; i < wordList.size(); i++) {
										if (userWord.substring(userWord.length() - 1)
												.equals(wordList.get(i).substring(0, 1))) {
											comAnswerList.add(wordList.get(i));
										}
									}
									if (comAnswerList.size() == 0) {
										// TODO 컴퓨터 패배 시, 로그인 한 사람의 점수 +1;
										System.out.println("내가 패배한거야, 인간의 승리가 아니야!");
										stuService.plusScore(login.getStuId());
										break;
									} else {
										// 대답할 수 잇는 목록에서 랜덤 인덱스의 단어를
										// 꺼내서 제시
										int randNum = (int) (Math.random() * comAnswerList.size());
										computerWord = comAnswerList.get(randNum);
										System.out.println(computerWord + " 쿵쿵따!");
									}
								} else {
									// 틀린 것(게임오버)
									System.out.println("인간이 패배한 것이지 내가 패배한것이 아니야");
									break;
								}
							}

						} else if (select == 2) {
							// TODO 랭킹
							ArrayList<StudentVO> stuList = stuService.getStuList();
							for (int i = 0; i < stuList.size(); i++) {
								System.out.println((i + 1) + "등. " + stuList.get(i).getStuName() + "|"
										+ stuList.get(i).getStuScore());
							}

						} else if (select == 3) {
							break;
						} else {
							System.out.println("다시 입력해 주세요.");
						}
					}

				} else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}

			} else if (command == 2) {
				System.out.print("아이디 :");
				String id = scan.nextLine();

				System.out.println("비밀번호 : ");
				String pw = scan.nextLine();

				System.out.println("닉네임 : ");
				String name = scan.nextLine();

//				stuService.registStudent(id, pw, name);
				StudentVO stu = new StudentVO(id, pw, name, 0);
				stuService.registStudent(stu);

			} else if (command == 3) {
				ArrayList<StudentVO> stuList = stuService.getStuList();
				for (int i = 0; i < stuList.size(); i++) {
					System.out.println(stuList.get(i));
				}
			} else if (command == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해 주세요");
				continue;
			}
		}
	}

}
