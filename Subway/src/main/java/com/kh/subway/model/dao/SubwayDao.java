package com.kh.subway.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.subway.model.vo.Subway;

public class SubwayDao {
	
	public int insertOrder(SqlSession session, Subway order) {
		return session.insert("orderMapper.insertOrder", order);
	}
	
	public List<Subway> findAll(SqlSession session){
		return session.selectList("orderMapper.findAll");
	}

}
