package util.hashmap;

import java.util.Scanner;

import util.vector.Grade;

public class MemberMain {

	public static void main(String[] args) {
		//커맨드 패턴
		
		MemberService service = new MemberServiceImpl();
		Scanner scan = new Scanner(System.in);
		String input ="";
		
		for( ;; ){
			System.out.println("[JOIN] : 회원가입, [LOGIN] : 로그인, [LOGOUT] : 로그아웃");
			input = scan.next();
			if (input.equals("logout")) {
				System.out.println("로그아웃");
				break;
			} else {
				switch (input) {
				case "join": //1.회원정보입력
					System.out.println("아이디 : ");
					String userid = scan.next();
					System.out.println("비번 : ");
					String password = scan.next();
					System.out.println("이름 : ");
					String name = scan.next();
					System.out.println("나이 : ");
					int age = scan.nextInt();
					System.out.println("주소 : ");
					String address = scan.next();
					service.join(userid,password, name,age,address);
					System.out.println("회원가입 성공");
					break;
				
				case "login": //2.로그인
					System.out.println("아이디 : ");
					String userid2 = scan.next();
					System.out.println("비번 : ");
					String password2 = scan.next();
					String result = service.login(userid2,password2);
					String flag = result.substring(0,5);
					if (flag.equals("환영합니다")) {
						System.out.println(result);
						break; //여기까지
					} else if(flag.equals("비번이 다")) {
						

					} else{
						
					}
				    break;

				default:
					System.out.println("올바르지 않음");
					break;
				}

			}
		}

	}

}
