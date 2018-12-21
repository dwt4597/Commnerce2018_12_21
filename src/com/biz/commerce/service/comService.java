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
				
					st.setStrdate1(vo.getStrdate1());
					st.setStrcode1(vo.getStrcode1());
					st.setStrio1(vo.getStrio1());
					st.setPrice1(vo.getPrice1());
					st.setSu1(vo.getSu1());	
				}
			}
		}
	public void saving() {
		String gNum = save;
		
		FileWriter fw;
		PrintWriter pw;
		cmcVO vo = new cmcVO();
		try {
			
			pw = new PrintWriter(save);
			String mimcz = vo.getStrio1();
			
			String danga = vo.getPrice1();
			
			int danga1 = Integer.valueOf(danga);
			String su = vo.getSu1();
			int su1 = Integer.valueOf(su);
			
			for(cmcVO v : spjbList) {
			if(v.getStrio1().equals("1")) {
				pw.println(
					v.getStrdate1()+":"
					+ "매입"+":"
					+ v.getStrcode2() + ":"
					+ v.getStrname2() + ":"
					+ v.getPrice1() + ":"
					+ v.getSu1()+":"
					+ danga1 * su1+":"
					+ "0"
			);
			} 
			if (v.getStrio1().equals("1")) {
				pw.println(
						v.getStrdate1()+":"
						+ "매출"+":"
						+ v.getStrcode2() + ":"
						+ v.getStrname2() + ":"
						+ v.getPrice1() + ":"
						+ v.getSu1()+":"
						+ "0"+":"
						+ danga1 * su1
				);
			}
			
			pw.close();
			
			}
					
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
			
			// -- 파일을 읽기 위해 open

			// -- 파일 읽기 실행
			while (true) {
				String reader = buffer.readLine();
				
				if (reader == null)
					break;
				String[] strF = reader.split(":");
				
				cmcVO vo = new cmcVO();
				vo.setStrcode2(strF[0]);
				vo.setStrname2(strF[1]);
				vo.setStrgs2(strF[2]);
				vo.setMid2(strF[3]);
				vo.setMcd2(strF[4]);
				vo.setPum2(strF[5]);
				vo.setJmic2(strF[6]);
				
				
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
				vo.setStrdate1(strF[0]);
				vo.setStrcode1(strF[1]);
				vo.setStrio1(strF[2]);
				vo.setPrice1(strF[3]);
				vo.setSu1(strF[4]);
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