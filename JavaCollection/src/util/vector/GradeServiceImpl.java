package util.vector;
// 전체에서 특정 글자 바꾸는 단축키 !!!! 컨트롤 에이 누르고 컨트롤 에프를 누르자
// 벡터와 어레이스트 차이는 벡터는 elementAt를 쓰고 어레이스트는 get을 쓴다
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
	
	private List<Grade> vec = new ArrayList<Grade>();
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
			String searchHakbun = vec.get(i).getHakbun();
			String name= vec.get(i).getName();
			if (hakbun.equalsIgnoreCase(searchHakbun)) //대소문자 구분하지 않는것 equalsIgnoreCase
				{
				//객체.메소드.메소드.메소드.메소드 이런 패턴은 반드시 리턴값이 있는 메소들끼리 연결시에만 가능하다
				//이런 방식을 메소드 체인이라고 한다.
				int kor = vec.get(i).getKor();
				int eng = vec.get(i).getEng();
				int math = vec.get(i).getMath();
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
	public Vector<Grade> searchGradeByName(String name) {
		Vector<Grade> temp = new Vector<Grade>(); //자료구조를 만들고 그 자료구조에 들어가는 객체를 선언해준다
		Grade grade = null;  					  //자료구조를 만들고 그 자료구조에 들어가는 객체를 선언해준다
		
		
		for (int i = 0; i < vec.size(); i++) {
			String searchName= vec.get(i).getName();
			
			//고정값(파라미터).equals(변수값)
			if (name.equalsIgnoreCase(searchName)) 	{
				//객체.메소드.메소드.메소드.메소드 이런 패턴은 반드시 리턴값이 있는 메소들끼리 연결시에만 가능하다
				//이런 방식을 메소드 체인이라고 한다.
				grade = new Grade(vec.get(i).getHakbun(),searchName,vec.get(i).getKor(),
						vec.get(i).getEng(),vec.get(i).getMath());
				temp.add(grade);
				
				 // 중간이라도 이름이 일치하면 그대로 스톱
			} else {
				// temp 라는 벡터를 완전히 비워서 null로 리턴
				temp.remove(new Grade());
			}
			
			
		}
		return temp;
		
	}

	@Override
	public void descByTotal() { //성적정렬 성적으로 내림 차순
		
		// Java API 중에서 정렬을 담담하는 클래스 
		// Comparator
		// 인터페이스를 구현한 익명 내부 클래스
		// anonymouns inner class
		Comparator<Grade> desc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				//삼항연산자
				/*
				 if(condition){
				 -> true 면 statement를 실행
				 }else{
				 -> false면 statement를 실행
				 }
				 (조건식) ? 참 : 거짓;
				 */
				
			/*	if (g1.getTotal()<g2.getTotal()) {
					temp= 1;
				} else {
					if (g1.getTotal() == g2.getTotal()) {
						temp= 0;
					} else {
						temp= -1;
					}
					return temp;
				}*/
			return	(g1.getTotal()<g2.getTotal()) ? 1 :
				     (g1.getTotal() == g2.getTotal()) ? 0 : -1;
			}
		};
		Collections.sort(vec,desc);
		System.out.println(vec.toString());
	
	}

	@Override
	public void ascByName() { //이름으로 오름차순
		Comparator<Grade> asc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				/*값(Value)이 int 타입이 아니고 
				  String 타입의 우선순의 결정할때는
				  compareTo() 메소드를 사용해야 한다.
				 * */
				return	g1.getName().compareTo(g2.getName());
			}
		};
		Collections.sort(vec,asc);
		System.out.println(vec.toString());
	}

}
