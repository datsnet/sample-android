package jp.eclipsebook;

import java.io.Serializable;

public 	class MyData implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name1 = null;
	private String name2 = null;
	private int age = 0;
	
	public MyData(String name1, String name2, String age) {
		super();
		this.name1 = name1;
		this.name2 = name2;
		try {
			this.age = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "MyData \n" + name1 + " " + name2 + "\n" + age + " old";
	}

	public String getName1() { return name1; }
	public void setName1(String name1) { this.name1 = name1; }
	public String getName2() { return name2; }
	public void setName2(String name2) { this.name2 = name2; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}
