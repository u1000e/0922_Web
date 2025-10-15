package com.kh.java.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.board.model.dao.BoardDao;
import com.kh.java.board.model.dto.BoardDto;
import com.kh.java.board.model.dto.ImageBoardDto;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.board.model.vo.Category;
import com.kh.java.board.model.vo.Reply;
import com.kh.java.common.Template;
import com.kh.java.common.vo.PageInfo;

public class BoardService {
	
	private BoardDao bd = new BoardDao();
	
	public int selectListCount() {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = bd.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public List<Board> selectBoardList(PageInfo pi){
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Board> boards = bd.selectBoardList(sqlSession, pi);
		
		sqlSession.close();

		return boards;
	}
	
	public List<Category> selectCategory(){
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Category> categories = bd.selectCategory(sqlSession);
		
		sqlSession.close();
		
		return categories;
	}
	
	public int insert(Board board, Attachment at) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// INSERT를 두 번 수행
		// BOARD 테이블에 한 번 => 무조건
		int boardResult = bd.insertBoard(sqlSession, board);
		// ATTACHEMTN 테이블에 한 번 => 파일이 존재할 때만 가야함
		int atResult = 1;
		if(at != null) {
			at.setRefBno(board.getBoardNo());
			atResult = bd.insertAttachment(sqlSession, at);
		}
		// 두 개의 DML구문을 하나의 트랜잭션으로 묶어서 처리
		if(boardResult * atResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		// 트랜잭션처리까지 끝내고 난 후 성공실패여부를 반환
		return (boardResult * atResult);
	}
	
	public Map<String, Object> selectBoard(int boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// SELECT 두 번 하기 + 조회수 증가
		
		// 총 DB에 3번 가야함
		// UPDATE BOARD => COMMIT
		// SELECT BOARD
		// SELECT ATTACHMENT
		int result = bd.increaseCount(sqlSession, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
			Board board = bd.selectBoard(sqlSession, boardNo);
			Attachment at = bd.selectAttachment(sqlSession, boardNo);
			Long userNo = bd.selectBoardWriter(sqlSession, boardNo);
			// System.out.println(board);
			// System.out.println(at);
			Map<String, Object> map = new HashMap();
			map.put("board", board);
			map.put("at", at);
			map.put("boardWriter", userNo);
			return map;
		}
		return null;
	}
	
	public int deleteBoard(Board board) {
		
		SqlSession sqlSession = Template.getSqlSession();
		int result = bd.deleteBoard(sqlSession, board);
		Attachment at = bd.selectAttachment(sqlSession, board.getBoardNo().intValue());
		int result2 = 1;
		
		if(at != null) {
			result2 = bd.deleteAttachment(sqlSession, board.getBoardNo());
		}

		if(result * result2 > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result * result2;
	}
	
	public int update(Board board, Attachment at) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int boardResult = bd.updateBoard(sqlSession, board);
		
		// Attachment~
		// 새 첨부파일이 없을 때
		int atResult = 1;
		
		// 새 첨부파일이 존재할 경우
		if(at != null) {
			if(at.getFileNo() != null) {
				// case 1
				// 기존에 첨부파일이 있따 => UPDATE
				atResult = bd.updateAttachment(sqlSession, at);
			} else {
				// case 2
				// 기존 첨부파일 없음 => INSERT
				atResult = bd.insertAttachment(sqlSession, at);
			}
		} // 없으면 뭐 할거없음
		
		// 둘 다 성공했을 때 만 commit;
		// 하나라도 실패했으면 rollback;
		if(boardResult * atResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return (boardResult * atResult);
	}
	
	public int searchedCount(Map<String, Object> map) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int count = bd.searchedCount(sqlSession, map);
		
		sqlSession.close();
		
		return count;
	}
	
	public List<Board> selectSearchList(Map<String, Object> map){
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Board> boards = bd.selectSearchList(sqlSession, map);
		
		sqlSession.close();
		
		return boards;
	}
	
	public int insertImage(Board board, List<Attachment> files) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// 보드에 INSERT하는거 만들어놨음
		// Attachment에 INSERT하는거 만들어놨음
		
		int result = 0;
		
		try {
			// 1. 게시글 INSERT
			result = bd.insertImageBoard(sqlSession, board);
			
			// 2. 게시글 INSERT가 성공 시 첨부파일들 INSERT
			if(result > 0) {
				
				// 첨부파일 개수만큼 INSERT
				for(Attachment file : files) {
					file.setRefBno(board.getBoardNo());
					
					result = bd.insertAttachmentList(sqlSession, file);
					
					if(result == 0) {
						break;
					}
				}
			}
			
			// 3. 다성공했으면 Commit
			if(result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			result = 0;
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public List<ImageBoardDto> selectImageList(){
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<ImageBoardDto> boards = bd.selectImageList(sqlSession);
		
		sqlSession.close();
		
		return boards;
	}
	
	public BoardDto selectImageDetail(Long boardNo){
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// UPDATE KH_BOARD
		int updateResult = bd.increaseCount(sqlSession, boardNo.intValue());
		
		// SELECT ONE KH_BOARD
		// SELECT LIST KH_ATTACHMENT
		if(updateResult > 0) {
			sqlSession.commit();
			//Board board = bd.selectBoard(sqlSession, boardNo.intValue());
			//List<Attachment> files = bd.selectAttachmentList(sqlSession, boardNo.intValue());
			//Map<String, Object> map = new HashMap();
			//map.put("board", board);
			//map.put("files", files);
			BoardDto boards = bd.selectBoardAndAttachment(sqlSession, boardNo);
			// System.out.println(boards);
			return boards;
		}
		
		return null;
	}
	
	
	public int insertReply(Reply reply) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = bd.insertReply(sqlSession, reply);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public List<Reply> selectReply(Long boardNo){
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Reply> reply = bd.selectReply(sqlSession, boardNo);
		
		sqlSession.close();
		
		return reply;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
