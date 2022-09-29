package Skeleton;

import java.util.Arrays;
import java.util.Date;

public class Human {
	private String name;
	private int age;
	private boolean sexIsMale;
	private Date birthday;
	private double hight;
	private Human[] parents = new Human[]{ , };
	private String[] children;
	
	public Human() {
	}
	
	public Human(String name, int age, boolean sexIsMale, Date birthday, double hight, String[] children) {
		this.name = name;
		this.age = age;
		this.sexIsMale = sexIsMale;
		this.birthday = birthday;
		this.hight = hight;
		this.children = children;
	}
	
	public Human(String name, int age, boolean sexIsMale, Date birthday, double hight, Human[] parents,
	             String[] children) {
		this.name = name;
		this.age = age;
		this.sexIsMale = sexIsMale;
		this.birthday = birthday;
		this.hight = hight;
		this.parents = parents;
		this.children = children;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isSexIsMale() {
		return sexIsMale;
	}
	
	public void setSexIsMale(boolean sexIsMale) {
		this.sexIsMale = sexIsMale;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public double getHight() {
		return hight;
	}
	
	public void setHight(double hight) {
		this.hight = hight;
	}
	
	public String[] getChildren() {
		return children;
	}
	
	public void setChildren(String[] children) {
		this.children = children;
	}
	
	public Human[] getParents() {
		return parents;
	}
	
	public void setParents(Human[] parents) {
		this.parents = parents;
	}
	
	@Override
	public String toString() {
		return "Human{" +
		       "name='" + name + '\'' +
		       ", age=" + age +
		       ", sexIsMale=" + sexIsMale +
		       ", birthday=" + birthday +
		       ", hight=" + hight +
		       ", parents=" + Arrays.toString(children) +
		       '}';
	}
	
}
