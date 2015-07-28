package util.vector;

import java.util.Vector;

public interface GradeService {
	//인터페이스는 추상메소드만 존재한다. 따라서 abstract 을 생략해도 디폴트로 존재한다
	
	/*
	 성적표를 컬렉션에 입력
	 */
	public void input(Grade grade);
	
	
	/*
	 학생들 전체 성적표 출력
	 */
	public void printList();
	
	/*
	 학번으로 성적결과 조회
	 */
	public String searchGradeByHakbun(String hakbun);
	/*
	 이름으로 성적결과 조
	 * */
	public Vector<Grade> searchGradeByName(String name);
	
	/*
	 총점 역순 정렬
	 */
	public void descByTotal();
	
	/*
	 이름오름차순정렬
	 */
	public void ascByName();
}
