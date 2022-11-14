
package com.kosa.instagram.feed.model;

public class HashtagVo {
	
	private String hashtag; // 해시태그
	private int cnt;        // 카운트
	
	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "HashtagVo [hashtag=" + hashtag + ", cnt=" + cnt + "]";
	}
}
