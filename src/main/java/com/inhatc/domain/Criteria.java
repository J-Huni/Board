package com.inhatc.domain;

public class Criteria {
	private int page;
	private int pagePost;
	private int morePost;
	
	public Criteria() {
		this.page = 1;
		this.pagePost = 12;
		this.morePost = 8;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public int getPagePost() {
		return pagePost;
	}

	public void setPagePost(int pagePost) {
		if(pagePost <= 0 || pagePost >=100) {
			this.pagePost = 12;
			return;
		}
		
		this.pagePost = pagePost;
	}
	
	public int getStartPage() {
		return (this.page - 1) * pagePost;
	}
	
	@Override
	public String toString() {
			return "Criteria [page=" + page + ", pagePost=" + pagePost + "]";
	}

	public int getMorePost() {
		return morePost;
	}

	public void setMorePost(int morePost) {
		this.morePost = morePost;
	}
}
