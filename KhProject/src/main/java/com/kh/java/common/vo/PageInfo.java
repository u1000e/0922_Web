package com.kh.java.common.vo;

public class PageInfo {
	private int listCount;
	private int currentPage;
	private int pageLimit;
	private int boardLimit;
	private int startPage;
	private int endPage;
	private int maxPage;
	private int offset;
	public PageInfo() {
		super();
	}
	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int startPage, int endPage,
			int maxPage, int offset) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
		this.offset = offset;
	}
	
	public int getListCount() {
		return listCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public int getBoardLimit() {
		return boardLimit;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public int getOffset() {
		return offset;
	}
	
	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", startPage=" + startPage + ", endPage=" + endPage + ", maxPage="
				+ maxPage + ", offset=" + offset + "]";
	}

}
