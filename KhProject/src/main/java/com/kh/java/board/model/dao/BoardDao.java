package com.kh.java.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.board.model.dto.BoardDto;
import com.kh.java.board.model.dto.ImageBoardDto;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.board.model.vo.Category;
import com.kh.java.board.model.vo.Reply;
import com.kh.java.common.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public List<Board> selectBoardList(SqlSession sqlSession, PageInfo pi){
		return sqlSession.selectList("boardMapper.selectBoardList", pi);
	}
	
	public List<Category> selectCategory(SqlSession sqlSession){
		return sqlSession.selectList("boardMapper.selectCategory");
	}
	
	public int insertBoard(SqlSession sqlSession, Board board) {
		return sqlSession.insert("boardMapper.insertBoard", board);
	}
	
	public int insertAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("boardMapper.insertAttachment", at);
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	public Attachment selectAttachment(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectAttachment", boardNo);
	}
	
	public Long selectBoardWriter(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoardWriter", boardNo);
	}
	
	public int deleteBoard(SqlSession sqlSession, Board board) {
		return sqlSession.update("boardMapper.deleteBoard", board);
	}
	
	public int deleteAttachment(SqlSession sqlSession, Long boardNo) {
		return sqlSession.update("boardMapper.deleteAttachment", boardNo);
	}
	
	public int updateBoard(SqlSession sqlSession, Board board) {
		return sqlSession.update("boardMapper.updateBoard", board);
	}
	
	public int updateAttachment(SqlSession sqlSession, Attachment at) {
		return sqlSession.update("boardMapper.updateAttachment", at);
	}
	
	public int searchedCount(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.selectOne("boardMapper.searchedCount", map);
	}
	
	public List<Board> selectSearchList(SqlSession sqlSession, Map<String, Object> map){
		return sqlSession.selectList("boardMapper.selectSearchList", map);
	}
	
	public int insertImageBoard(SqlSession sqlSession, Board board) {
		return sqlSession.insert("boardMapper.insertImageBoard", board);
	}
	
	public int insertAttachmentList(SqlSession sqlSession, Attachment at) {
		return sqlSession.insert("boardMapper.insertAttachmentList", at);
	}
	
	public List<ImageBoardDto> selectImageList(SqlSession sqlSession){
		return sqlSession.selectList("boardMapper.selectImageList");
	}
	
	public List<Attachment> selectAttachmentList(SqlSession sqlSession, int boardNo){
		return sqlSession.selectList("boardMapper.selectAttachment", boardNo);
	}
	
	public BoardDto selectBoardAndAttachment(SqlSession sqlSession, Long boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoardAndAttachment", boardNo);
	}
	
	public int insertReply(SqlSession sqlSession, Reply reply) {
		return sqlSession.insert("boardMapper.insertReply", reply);
	}
	
	public List<Reply> selectReply(SqlSession sqlSession, Long boardNo){
		return sqlSession.selectList("boardMapper.selectReply", boardNo);
	}
	
	
	
	
	
}
