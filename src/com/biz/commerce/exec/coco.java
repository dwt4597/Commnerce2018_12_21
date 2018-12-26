package com.biz.commerce.exec;

public class coco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1부터 100까지 연속된 숫자중에서 짝수인 숫자만 모아서 그 덧셈을 하여 나에게 보여주렴
		 * 
		 */
		int intSum = 0;
		for (int i = 1; i <= 100; i++) {
			/*
			 * if(i%2 == 0) { intSum += i; }
			 */

			intSum += addEven(i);
		}
	}

	public static int addEven(int num) {
		if (num % 2 == 0)
			return num;
		else return 0;
	}

}
