package com.websitedungcuthethao.dto;

public class AbstractDTO {

	private int page;
	private int limit;
	private int totalPage;
	private Long totalItem;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Long getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Long totalItem) {
		this.totalItem = totalItem;
	}
	@Override
	public String toString() {
		return "AbstractDTO [page=" + page + ", limit=" + limit + ", totalPage=" + totalPage + ", totalItem="
				+ totalItem + "]";
	}
	
	
}
