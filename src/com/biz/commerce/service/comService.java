package com.biz.commerce.service;

import java.io.*;
import java.util.*;

import com.biz.commerce.vo.*;

public class comService {
	List<cmcVO> spjbList;
	List<cmcVO> mimcList;
	String mimc;
	String spjb;
	String save;

	public comService(String[] files) {
		spjbList = new ArrayList();
		mimcList = new ArrayList();
		this.mimc = files[0];
		this.spjb = files[1];
		this.save = files[2];

	}

	public void Match() {
		for (cmcVO vo : mimcList) {
			for (cmcVO st : spjbList) {
				if (vo.getStrPCode().equals(st.getStrPCode())) {
					vo.setStrName(st.getStrName());
					vo.setStrTex(st.getStrTex());
					vo.setIntIPrice(st.getIntIPrice());
					vo.setIntOPrice(st.getIntOPrice());
					vo.setStrPum(st.getStrPum());
					vo.setStrDept(st.getStrDept());
				}
			}
		}
	}

	public void saving() {

		PrintWriter pw;
		try {

			pw = new PrintWriter(save);

			for (cmcVO v : mimcList) {
				if (v.getStrIO().equals("1")) {
					//
					pw.println(v.getStrDate() + ":" + "매입" + ":" + v.getStrPCode() + ":" + v.getStrName() + ":"
							+ v.getIntPrice() + ":" + v.getIntQuan() + ":" + v.getIntPrice() * v.getIntQuan() + ":"
							+ "0");
				}
				if (v.getStrIO().equals("2")) {
					pw.println(v.getStrDate() + ":" + "매출" + ":" + v.getStrPCode() + ":" + v.getStrName() + ":"
							+ v.getIntPrice() + ":" + v.getIntQuan() + ":" + "0" + ":"
							+ v.getIntPrice() * v.getIntQuan());
				}

			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readspjb() {

		FileReader fr;

		BufferedReader buffer;

		try {
			fr = new FileReader(spjb);

			buffer = new BufferedReader(fr);

			while (true) {
				String reader = buffer.readLine();

				if (reader == null)
					break;
				String[] strF = reader.split(":");

				cmcVO vo = new cmcVO();
				vo.setStrPCode(strF[0]);
				vo.setStrName(strF[1]);
				vo.setStrTex(strF[2]);
				int intIPrice = Integer.valueOf(strF[3]);
				int intOPrice = Integer.valueOf(strF[4]);
				vo.setIntIPrice(intIPrice);
				vo.setIntOPrice(intOPrice);
				vo.setStrPum(strF[5]);
				vo.setStrDept(strF[6]);
				spjbList.add(vo);

			}
			buffer.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readmimc() {

		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(mimc);
			buffer = new BufferedReader(fr);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null)
					break;
				String[] strF = reader.split(":");

				cmcVO vo = new cmcVO();
				vo.setStrDate(strF[0]);
				vo.setStrPCode(strF[1]);
				vo.setStrIO(strF[2]);
				int intprice = Integer.valueOf(strF[3]);
				vo.setIntPrice(intprice);
				int intquan = Integer.valueOf(strF[4]);
				vo.setIntQuan(intquan);
				mimcList.add(vo);

			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}