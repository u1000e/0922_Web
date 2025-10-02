package com.kh.java.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.MyRenamePolicy;
import com.kh.java.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/insert.image")
public class ImageInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 첨부파일 -> multi/form-data -> 조건문 -> 서버로 파일을 올려주자
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1) MutipartRequest 생성
			// 1_1. 용량
			int maxSize = 100000000;
			
			// 1_2. 경로
			String savePath = request.getServletContext()
									 .getRealPath("/resources/image_upfiles");
			
			// 2) 객체 생성과 동시에 파일 업로드
			MultipartRequest multiRequest = 
					new MultipartRequest(request, savePath, maxSize, "UTF-8"
										,new MyRenamePolicy());
			
			// 파일업로드 끝!
			
			// 뽀드랑 아따치먼트랑 인서트
			
			// 3) multiRequest참조해서 값뽑기 => getParamter() 호출
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("userInfo");
			Long userNo = member.getUserNo();
			
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			String boardWriter = String.valueOf(userNo);
			
			// 4) 가공
			Board board = new Board();
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setBoardWriter(boardWriter);
			
			// Attachment
			// => 사진게시글 작성 양식 required
			// 게시글 당 최소 한 개의 첨부파일은 존재
			/*
			Attachment at1 = null;
			Attachment at2 = null;
			Attachment at3 = null;
			Attachment at4 = null;
			if(multiRequest.getOriginalFilename("file1") != null) {
				at1 = new Attachment();
				at.setOrignsd
			}
			if(multiRequest.getOriginalFilename("file2") != null) {
				
			}
			if(multiRequest.getOriginalFilename("file3") != null) {
				
			}
			if(multiRequest.getOriginalFilename("file4") != null) {
				
			}
			*/
			List<Attachment> files = new ArrayList();
			// 키값 file1  ~ file4
			for(int i = 1; i <= 4; i++) {
				String key = "file" + i;
				// System.out.println(key);
				
				// 조건검사 name속성값을 이용해서 파일이 있는가? 없는가?
				if(multiRequest.getOriginalFileName(key) != null) {
					// 파일이 존재한다.
					
					Attachment at = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/image_upfiles");
					
					// 대표이미지 == file1
					at.setFileLevel(i == 1 ? 1 : 2);
					
					files.add(at);
				}
			}
			// 요청처리 -> 서비스단으로 전달
			int result = new BoardService().insertImage(board, files);
			
			if(result > 0) {
				
				response.sendRedirect(request.getContextPath() + "/images");
			} else {
				request.setAttribute("msg", "게시글 작성 실패");
				request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp")
					   .forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
