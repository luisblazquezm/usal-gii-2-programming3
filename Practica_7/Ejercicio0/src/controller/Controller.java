package controller;

import data.Model;

public class Controller {

	Model m = new Model();
	
	public void storeIntoModel(int num1,int num2){
		m.setData(num1,num2);
	}

	public void getSuma() {
		int temp = m.getInfo_1() + m.getInfo_2();
		m.setResults(temp);
	}

	public int getInfo_1() {
		return m.getInfo_1();
	}
	
	public int getInfo_2() {
		return m.getInfo_2();
	}

	public int getInfo_Resultado() {
		return m.getInfo_result();
	}
	

}
