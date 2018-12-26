package com.biz.commerce.exec;

import com.biz.commerce.service.*;

public class cmsexec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * comService 클래스를 객체로 선언하여 매입매출 업무를 수행할 준비
		 * 
		 * 변수를 매개변수로 전달 == 매입매출정보를 저장하고 있는 파일 이름을 매개변수로 전달하는 것과 같다.
		 */
		/*
		 * 매입매출정보를 저장하고 있는 파일 이름(경로)를 문자열 변수에 저장
		 */
		String mimc = "src/com/biz/commerce/매입매출데이터.txt";
		String spjb = "src/com/biz/commerce/상품정보.txt";
		String save = "src/com/biz/commerce/매입매출정보.txt";
		String[] files = { mimc, spjb, save };
		comService cms = new comService(files);
		/*
		 * 매입매출정보.TXT 파일에서 데이터를 읽어서 comService에 저장하는 메서드 호출(실행)
		 */
		cms.readspjb();
		/*
		 * 위에서 메서드를 실행했으므로 매입매출정보가 저장되어있을것이다.
		 */
		cms.readmimc();
		/*
		 * 정보확인하기.
		 * 
		 * cms.ioView();
		 */
		
		/*
		 * 상품정보를 읽어 pList에 저장하기 위해서
		 cms.pRead() 메서드 실행
		 */
		cms.pRead();
		cms.pView();
		cms.Match();
		cms.saving();
	}

}
