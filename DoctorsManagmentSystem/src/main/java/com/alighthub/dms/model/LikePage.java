package com.alighthub.dms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LikePage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int likePageId;
	
	public int getLikePageId() {
		return likePageId;
	}

	public void setLikePageId(int likePageId) {
		this.likePageId = likePageId;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	private long count;

}
