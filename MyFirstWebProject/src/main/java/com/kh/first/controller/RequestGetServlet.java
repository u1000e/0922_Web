package com.kh.first.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 매핑값은 서블릿마다 고유한 값이어야함
@WebServlet("/get.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestGetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 톰캣 실행 -> web.xml 파싱 
		 * init() => service() => doGet()/doPost() => destroy()
		 * 서블릿 생명주기 / 싱글톤 패턴으로 객체 하나만을 사용 / 톰캣이 멀티스레드 처리(스레드풀)
		 */
		// System.out.println("헉 진짜임?");
		
		/*
		 * Dynamic WebProject진행 시 Servlet을 Controller로 사용
		 * 
		 * 1. 데이터 가공
		 * 2. 요청 처리(Service호출)
		 * 3. 결과값 반환(응답화면지정)
		 * 
		 * View에서 Get방식으로 요청 시 doGet()가 호출됨!!
		 * 
		 */
		// System.out.println("GET방식으로 호출됨!!");
		/*
		 * 인자값으로 두 개 넘어옴
		 * 
		 * 첫 번째 매개변수 HttpServletRequest 타입에는 요청 시 전달된 내용들이 담김
		 * => 요청 전송 방식, 요청 URL, 요청한 사용자의 정보, 사용자가 input요소에 입력한 값 등...
		 * 
		 * 두 번째 매개변수 HttpServletResponse 타입은 요청 처리 후 응답할 때 사용하는 객체
		 * 
		 * 요청 처리 스텝
		 * 
		 * 1. 우선 요청을 처리하기 위해서 요청 시 전달된 값(사용자가 입력한값)들을 뽑는다.
		 * => key-value세트로 담겨있음(name속성값=value속성값)
		 * => request의 Parameter라는 곳에서 전달값을 뽑아내야함
		 * 
		 * 2. 뽑아낸 값을 가공해서 요청 처리를 진행해야함(Service -> DAO -> DB)
		 * 
		 * 3. 처리결과에 따른 성공 / 실패 페이지 응답
		 */
		
		/*
		 * request의 parameter영역으로부터 전달된 데이터 값을 뽑아내는 방법
		 * 
		 * - request.getParameter("키값") : String(input요소에 적어놓은 name속성값)
		 * => 반환형이 String이기 떄문에 다른 자료형으로 사용해야 한다면 Parsing해야함
		 * 
		 * - request.getParameterValues("키값") : String[]
		 * => 하나의 key값으로 여러 개의 value들을 받아야 할 경우
		 */
		
		// 1단계. 값 뽑기
		String name = request.getParameter("name");
		System.out.println(name);
		// "셀 수 없음"
		// "홍길동" / ""(텍스트상자가 비어있을 경우 빈문자열) / null
		
		String gender = request.getParameter("gender");
		System.out.println(gender);
		// "남" / "여" / "선택 안 함" / null
		
		int age = Integer.parseInt(request.getParameter("age"));
		// Wrapper클래스를 이용해서 파싱
		System.out.println(age);
		// "14" / ""
		// "" : NumberFormatException이 발생
		
		String city = request.getParameter("city");
		System.out.println(city);
		// "서울" / "제주도"
		
		double height = Double.parseDouble(request.getParameter("height"));
		System.out.println(height);
		int realHeight = (int)height;
		
		String[] foods = request.getParameterValues("food");
		System.out.println(Arrays.toString(foods));
		// ["떡볶이", "초밥"] / null
		
		// 자주보는 상태코드
		// 404 : 파일 또는 요청을 받아주는 서블릿을 찾지 못했을 때 발생
		//			=> 경로를 잘 못 적었거나 파일명에 오타가 났을 때
		// 500 : 자바 소스코드상의 오류(예외발생)
		
		// 2단계. 데이터가공
		// Person person = new Person(name, gender, age, city, height, foods);
		// 만들었다 침
		
		// 3단계. 요청 처리(DB와의 상호작용 == JDBC/MyBatis)
		// 보통의 흐름 : Controller에서 Service의 메소드를 호출하면서 값을 전달
		// -> DAO호출 -> DB SQL문(INSERT)문 실행 -> 정수형태의 결과값 반환
		// int result = new PersonService().savePerson(person);
		
		// 4단계. 결과값 반환 or 응답화면 지정
		// 무조건 성공했다고 가정
		
		// 순수 Servlet만 사용해서 응답데이터 넘기기
		// 사용자에게 HTML + CSS + JS 응답
		
		/*
		 * 요청 처리에 성공했습니다!
		 * 
		 * XXX님은
		 * XX살이며,
		 * XXX에 삽니다.
		 * 키는 XXXcm이고
		 * 
		 * 성별은 case 1. 선택을 안했습니다.
		 * 		case 2. 남성입니다.
		 * 		case 3. 여성입니다.
		 * 
		 * 좋아하는 음식 case 1. 없습니다.
		 * 			  case 2. 치킨머시기~ 떡볶이~
		 * 
		 */
		
		// 1단계) 응답 데이터 형식 지정 -> 문서형태의 HTML / 인코딩 방식 UTF-8
		response.setContentType("text/html; charset=UTF-8");
		
		// 2단계) 출력 스트림 생성
		// 스트림 InputStream / OutputStream
		//		  Reader    /  Writer
		PrintWriter pw = response.getWriter();
		
		// 3단계) 스트림을 이용해서 HTML데이터 출력
		pw.println("<html>");
			pw.println("<head>");
				pw.println("<title>순수 서블릿으로 응답해보기</title>");
				pw.println("<style>");
		
					pw.println("#name{color : orange}");
					pw.println("#age{color : orangered}");
					pw.println("#city{color : forestgreen}");
					pw.println("#height{color : green}");
					pw.println("#gender{color : gold}");
				
				pw.println("</style>");
			pw.println("</head>");
			pw.println("<body>");
			
				pw.println("<h1>요청 처리에 성공했습니다.</h1>");
				
				pw.printf("<span id='name'>%s</span>님은 <br>", name);
				pw.printf("<span id='age'>%d</span>살이며, <br>", age);
				pw.printf("<span id='city'>%s</span>에 삽니다.<br>", city);
				
				pw.printf("키는 <span id='height'>%.1f</span>cm이고 <br><br>", height);
			
				pw.print("성별은 ");
				if(gender == null || "선택안함".equals(gender)) {
					pw.println("선택을 안했습니다.");
				} else if(gender.equals("남")) {
					pw.println("<span id='gender'>남자</span>입니다.");
				} else {
					pw.println("<span id='gender'>여자</span>입니다.");
				}
				
				pw.print("좋아하는 음식은");
				if(foods == null) {
					
					pw.println("없습니다.");
					
				} else {
					
					pw.println("<ul>");
					
					for(int i = 0; i < foods.length; i++) {
						pw.printf("<li style='color:\"plum\"'>%s</li>", foods[i]);
					}
					
					pw.println("</ul>");
					pw.println("입니다.");
				}
				
			pw.println("<script>");
				pw.println("alert('축하해~~~');");
			pw.println("</script>");
			
			pw.println("</body>");
		pw.println("</html>");
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
