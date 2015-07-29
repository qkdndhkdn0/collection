package util.hashmap;
//게터세터
public class Member {
	private String userid,password,name,address;
	private int age;
	
	public String getUserid() {
		return userid;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPassword() {
		return password;
	}
	public int getAge() {
		return age;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void Display(){
		
	}

}
