package com.company.java.oop.features;

class Person{}
class Male extends Person{} //is a
class Female extends Person{}
class Family{
	//has a (组合)
	private Male male;
	public void setMale(Male male) {
		this.male = male;
	}
	//has a
	private Female female;
	public void setFemale(Female female) {
		this.female = female;
	}
}
class Team{
	//has a
	private Family[] familys;
	public Team(Family[] familys) {
		super();
		this.familys = familys;
	}
}
public class TestCompose01 {
   public static void main(String[] args) {
	    Family f1=new Family();
	    f1.setMale(new Male());
	    f1.setFemale(new Female());
	    
	    Family f2=new Family();
	    f2.setMale(new Male());
	    f2.setFemale(new Female());
	    Team t1=new Team(new Family[] {f1,f2} );
   }
}





