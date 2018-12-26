package com.biz.commerce.service;

import java.io.*;
import java.util.*;

import com.biz.commerce.vo.*;

public class comService {
	/*
	 * 각 데이터를 관리할 List변수들 선언
	 */
	List<ProductVO> pList; // 상품정보 table
	List<cmcVO> spjbList; //상품정보 table
	List<cmcVO> mimcList; //매입매출정보 table
	/*
	 * Text 파일 관련 변수들 선언
	 */
	String mimc; //매입매출 파일이름
	String spjb; //상품정보 파일 이름
	String save; //저장할 주소 이름
	/*
	 * comService 클래스로 객체를 생성할때
	 * 호출되는 생성자를 선언
	 * 
	 * 이 클래스는 Text 파일을 읽어서
	 * 매입매출 관련 업무를 수행할 것이므로
	 * 생성자에서는 Text 파일의 경로 정보를 매개변수로
	 * 받아서 변수에 저장하는 코드를 수행한다.
	 */
	public comService(String[] files) {
		/*
		 * 매개변수로 받은 files의 내용을
		 * this.~ member변수에 저장하여
		 * 다른 method에서 사용할 수 있도록 준비.
		 */
		
		/*
		 * 매입매출정보의 list를 담을 list를 초기화한다.
		 */
		spjbList = new ArrayList();
		mimcList = new ArrayList();
		/*
		 * 상품정보의 list를 담을 pList를 초기화한다
		 */
		this.pList = new ArrayList<>();
		
		this.mimc = files[0];
		this.spjb = files[1];
		this.save = files[2];

	}
	/*
	 * 상품정보.txt 파일을 읽어
	 * pList가 잘 만들어 졌는지 확인하는 메서드 선언
	 */
	public void pView() {
		for(ProductVO vo : pList) {
			System.out.println(vo);
		}
	}
	
	
	/*
	 * 상품정보.txt 파일에서 문자열을 읽어서 
	 * pList 에 저장하는 메서드 선언
	 */
	
	public void pRead() {
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr=new FileReader(spjb);
			buffer = new BufferedReader(fr);
			
			while(true) {
				String reader = buffer.readLine();
				if(reader == null) break;
					String[] pros = reader.split(":");
					ProductVO vo = new ProductVO();
					
					vo.setP_code(pros[0]);
					vo.setP_name(pros[1]);
					vo.setP_vat(pros[2]);
					
					int iPrice =Integer.valueOf(pros[3]);
					int oPrice =Integer.valueOf(pros[4]);
					vo.setP_iprice(iPrice);
					vo.setP_oprice(oPrice);
					
					pList.add(vo);
					
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
	
	
	
	/*
	 * mimcList에 저장되어있는 매입매출정보 리스트를
	 * console에 표시해서
	 * 잘 저장되어 있는지 검사하는 메서드를 선언
	 */
	public void ioView() {
		for(cmcVO vo : mimcList) {
			System.out.println(vo);
		}
	}
	
	/*
	 * list 들에 담긴 데이터를 사용해서
	 * 매입매출list를 출력하는 메서드를 선언
	 * 1. list에 담겨있는 상품코드를 사용해서
	 * 		pList에 담겨있는 상품정보를 찾아서 가져오기
	 */
	public void viewIoInfo() {
		for(cmcVO iv : mimcList) {
			for(ProductVO pv : pList) {
				if(iv.getStrPCode().equals(pv.getP_code())) {
					System.out.println(iv.getStrPCode());
					System.out.println(pv.getP_name());
				}
			}
		}
	}
	public void viewIoInfo2() {
		for(cmcVO iv : mimcList) {
			/*
			 * serchProduct() 메서드에게
			 * 상품코드를 전달해주고
			 * pList로부터 상품을 찾아라 라고 명령
			 * 
			 */
			ProductVO v = searchProduct(iv.getStrPCode());
			/*
			 * 만약 searchPro..() 메서드가 null을 보내오면
			 * 일단 그 상품은 무시하고
			 * (상품명을 없는 것으로 처리)
			 * 그 다음 매입매출 정보를 처리
			 */
			if(v == null) continue;
			
			// v가 null이 아니면 ( = 상품코드를 찾았으면)
		}
	}
	
	
	public ProductVO searchProduct(String pCode) {
		for(ProductVO pv : pList) {
			if(pCode.equals(pv.getP_code())) {
				return pv;
			}
		}
		return null;
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
					pw.println(v.getStrDate() + ":" + "매입" 
					+ ":" + v.getStrPCode() + ":" 
					+ v.getStrName() + ":"+ v.getIntPrice() 
					+ ":" + v.getIntQuan() + ":" 
					+ v.getIntPrice() * v.getIntQuan() + ":"+ "0");
				}
				if (v.getStrIO().equals("2")) {
					pw.println(v.getStrDate() + ":" 
				+ "매출" + ":" + v.getStrPCode() 
					+ ":" + v.getStrName() + ":"
				+ v.getIntPrice() + ":" + v.getIntQuan() + ":" 
					+ "0" + ":"+ v.getIntPrice() * v.getIntQuan());
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
		/*
		 * Text 파일을 읽기 위한 FileReader 객체 선언
		 */
		FileReader fr;
		/*
		 * FileReader로 읽은 내뇽에서 문자열을
		 * 쉽게 추출할 수  있도록 연결되는 Buffer 객체 선언
		 */
		BufferedReader buffer;

		try {
			/*
			 * 생성자에서 값이 할당된 files의 내용을 참조하여
			 * 파일을 읽기 위하여 open하는 코드
			 * 
			 * 이 코드는 작동되는 과정에서 불가항력적인
			 * 문제가 발생할 소지가 있으므로
			 * 반드시 try..catch 문으로 감싸 주어야한다.
			 */
			fr = new FileReader(mimc);
			/*
			 * FileReader로 open된 파일 정보를
			 * Buffer에 연결하여 준다.
			 * 이 코드가 실행되면
			 * BufferedReader는 일단 파일을 읽어서
			 * 메모리의 Buffer 영역에 저장해 둔다.
			 */
			buffer = new BufferedReader(fr);

			/*
			 * 무한반복문을 이용해서
			 * Buffer에 저장된 파일내용에서
			 * 한줄씩(문자열)로 읽어서 처리한다.
			 */
			while (true) {
				/*
				 * Buffer에서 한줄을 읽어서 
				 * reader 변수에 저장.
				 */
				String reader = buffer.readLine();
				
				/*
				 * 만약 reader에 저장된 값이 null이면
				 * 모든 문자열을 다 읽었다는 것이므로
				 * 반복문을 종료한다.
				 */
				if (reader == null)
					break;
				/*
				 * 반복문이 조욜되지 않았으므로
				 * (reader 변수에 문자열이 담겨 있다는 것)
				 * 코드가 실행되어 console에 
				 * 해당 문자열을 표시한다.
				 * 
				 * sysout(reader);
				 */
				
				/*
				 * reader문자열을 콜론(:)으로 분리해서
				 * cmcVO에 담고 
				 * mimclist에 추가하는 부분 
				 */
				
				/*
				 * String.split() 메서드를 사용해서
				 * 문자열 분해하고 strF 문자열 배열에 저장.
				 */
				String[] strF = reader.split(":");
				/*
				 * 새로운 vo를 생성(선언과 초기화)
				 */
				cmcVO vo = new cmcVO();
				
				/*
				 * vo의 각 member변수에 값을 저장(할당)
				 */
				vo.setStrDate(strF[0]);
				vo.setStrPCode(strF[1]);
				vo.setStrIO(strF[2]);
				/*
				 * vo.intPrice는 int형 변수이므로
				 * 문자열을 int로 먼저 변환한다.
				 */
				int intprice = Integer.valueOf(strF[3]);
				/*
				 * 변환된 intPrice를 vo.intPrice에 저장
				 */
				vo.setIntPrice(intprice);
				
				int intquan = Integer.valueOf(strF[4]);
				vo.setIntQuan(intquan);
				/*
				 * member변수가 setting된 vo를
				 * mimclist에 추가
				 */
				mimcList.add(vo);

			}
			/*
			 * 파일을 모두 사용(읽기)했으므로
			 * 안전하게 닫아준다. 
			 */
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