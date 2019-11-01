package com.company.java.generic;
interface Task<Param,Result>{//泛型 Param,Result
	Result execute(Param param);
}
class IntegerConvertTask 
      implements Task<String,Integer>{
	@Override
	public Integer execute(String param) {
		return Integer.valueOf(param);
	}
}
public class TestGeneric02 {

}
