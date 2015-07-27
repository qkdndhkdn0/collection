package util.vector;

import java.util.Vector;
/*
  프로그램을 코딩하다보면 자료구조를 다루는데 있어서
  CRUD 액션의 반복을 경험하게 됩니다.
  C : create(입력,생산)
  R : read(출력,조회)
  U : update(수정 -> 저장된 값을 수정 DB)
  D : delete(삭제 -> 완전삭제 DB -> null 값으로 바꾸는 삭제)
 */
public class GradeServiceImpl implements GradeService{
/*
 * 1. void있는 녀석들은 일단 놔두고 return이 되있는 녀석부터 손본다 (void녀석은 syso 로 때리면 되니깐 바로)
 * 2. 필드에 아래 메소드들이 공유할 자료구조는 뭘 쓸까? 고민해본다
 *    (1)ArrayList (2)Vector (3)Stack (4)HashMap
 *    순서 o, 중복 o 
 */
	
	private Vector<Grade> vec = new Vector<Grade>();
	Grade garade = new Grade(); //디폴트 생성자가 있어서 에러가 제거됨
	
	@Override
	public void input(Grade grade) {
		//성적표 입력
		//만약 자료구조로 배열을 사용했다면 vec[0]=hong;으로 한다
		 vec.add(grade);
	}

	@Override
	public void printList() {
		System.out.println(vec.toString()); 
		
		
	}

	@Override
	public String searchGradeByHakbun(String hakbun) {
		//msg = grade.toString();
		
		//학번으로의 검색
		String msg = ""; //지역변수
		Grade grade = null; //지변으로 인스턴스를 선언했으므로 초기화 해야함
		//List 계열의 클래스 길이는 size() 로 구한다.
		for (int i = 0; i < vec.size(); i++) {
		
			// 만약 vec가 배열이라면 vec.get(i)
			// vec.get(i)
			String searchHakbun = vec.elementAt(i).getHakbun();
			String name= vec.elementAt(i).getName();
			if (hakbun.equalsIgnoreCase(searchHakbun)) //대소문자 구분하지 않는것 equalsIgnoreCase
				{
				//객체.메소드.메소드.메소드.메소드 이런 패턴은 반드시 리턴값이 있는 메소들끼리 연결시에만 가능하다
				//이런 방식을 메소드 체인이라고 한다.
				int kor = vec.elementAt(i).getKor();
				int eng = vec.elementAt(i).getEng();
				int math = vec.elementAt(i).getMath();
				grade = new Grade(searchHakbun,name,kor,eng,math);
				msg = grade.toString();
				break; // 중간이라도 학번이 일치하면 그대로 스톱
			} else {
				msg = "조회하는 학번이 없습니다.";

			}
			
			
		}
		return msg;
	}

	@Override
	public void ascGradeTotal() {
		//성적 정렬
		
	}

}
