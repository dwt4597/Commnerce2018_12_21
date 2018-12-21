package com.biz.commerce.exec;

import com.biz.commerce.service.*;

public class cmsexec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mimc = "src/com/biz/commerce/매입매출데이터.txt";
		String spjb = "src/com/biz/commerce/상품정보.txt";
		String save = "src/com/biz/commerce/매입매출정보.txt";
		String[] files = {mimc, spjb, save};
		comService cms = new comService(files);
		
		cms.readspjb();
		cms.readmimc();
		cms.Match();
		cms.saving();
	}

}
