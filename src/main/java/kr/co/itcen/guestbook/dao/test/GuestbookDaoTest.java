package kr.co.itcen.guestbook.dao.test;

import java.util.List;

import kr.co.itcen.guestbook.dao.GuestbookDao;
import kr.co.itcen.guestbook.vo.GuestbookVo;


public class GuestbookDaoTest {
	public static void main(String[] args) {
		insertTest();
		getListTest();
		deleteTest();
	}
	
	private static void deleteTest() {
		GuestbookVo guestVo = new GuestbookVo();
		guestVo.setNo(4L);
		guestVo.setPassword("1234");
		new GuestbookDao().delete(guestVo);
	}
	
	public static void insertTest() {
		GuestbookVo guestVo = new GuestbookVo();
		guestVo.setName("임성주3");
		guestVo.setPassword("1234");
		guestVo.setContents("테스트중");
		
		new GuestbookDao().insert(guestVo);
		
		
	}
	
	public static void getListTest() {
		List<GuestbookVo> guestList = new GuestbookDao().getList();
		for(GuestbookVo guestVo : guestList) {
			System.out.println(guestVo);
		}
	}
}