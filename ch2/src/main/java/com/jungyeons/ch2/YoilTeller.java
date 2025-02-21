package com.jungyeons.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class YoilTeller {
@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		//1.입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy= Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		//2. 작업
		//왜 Calender cal = new Calendar(); 안하고 getInstance 하지?
		//Calender는 추상클래스라서 
		Calendar cal = Calendar.getInstance();
		//왜 mm안하고 mm-1하지 ? 
		//Calender 클래스에서 월은 0부터 시작함.
		cal.set(yyyy, mm-1, dd);
	    //dayofweek 이거는 뭐한거야? 해당 클래스의 날짜를 정수로 반환함. 1-> 일요일 이런식
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		//한글자 씩 매칭
		char yoil = "일월화수목금토".charAt(dayOfweek);
		
		//3. 출력
		//sysout안하려면 response 에서 얻어와야함.
		//브라우저로 출력하려면 타입을 써줘야 함.
		response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println(year + "년 "+month+"월"+day+"일은 ");
		out.println(yoil+"요일입니다.");
	}
}
