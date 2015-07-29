package util.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MemberServiceImpl implements MemberService{
	/* === 필 드=== */
//	Map<String,Member> map = new HashMap<String,Member>();
//  위에처럼 하는 것이 정석이다. JSP, DB 를 만지게 되면
//	<String,Object> 가 정석
//	하지만 이 예제는 <String,String>을 하겠다. 이유는 쉽게가려고
	Map<String,String> map = new HashMap<String,String>();
	Member member = new Member();
	String userid,password,name,address;
	int age; //필드변수는 초기화하지않는다
	/* ===생성자=== */
	/* ===멤버메소드=== */
	@Override
	public void join(String userid,String password,String name,int age,String address) {
		member.setUserid(userid);
		member.setPassword(password);
		member.setName(name);
		member.setAge(age);
		member.setAddress(address);
		
		map.put("userid", member.getUserid());
		map.put("password", member.getPassword());
		map.put("name", member.getName());
		map.put("age", String.valueOf(member.getAge()));
		map.put("address", member.getAddress());
	}

	@Override
	public String login(String userid,String password) {
		String msg ="";
		if (map.get("userid").equals(userid)&&map.get("password").equals(password)) {
			msg = "환영합니다." + member.getAddress()+"에 사시는" +member.getAge()+"세 되스는"+member.getName()+"님";
		
		}
		
		else if(map.get("userid").equals(userid)&&!map.get("password").equals(password)){
			msg = "비밀번호를 잘못 입력했다. 다시해라";

		}else{
			msg = "입력하신 아이디는 존재하지 않거나, 일치하지 않는다. 다시 입력하라.";
		}
		return msg;
		
		
	}


}
