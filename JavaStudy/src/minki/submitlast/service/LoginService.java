package minki.submitlast.service;

import java.util.Scanner;

import minki.submitlast.vo.LoginVO;

public class LoginService {
	Scanner scan = new Scanner(System.in);
	LoginVO lvo = new LoginVO();
	
	private static LoginService instance = new LoginService();
	
	public void Login() {
		System.out.print("ID : ");
		String ID = scan.nextLine();
		System.out.println("PW : ");
		String pw = scan.nextLine();
		
		
	}
}
