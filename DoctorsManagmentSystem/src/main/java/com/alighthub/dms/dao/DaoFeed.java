package com.alighthub.dms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alighthub.dms.model.Feedback;
@Repository
public interface DaoFeed extends JpaRepository<Feedback, Integer> {
	
	@Query("from Feedback f where f.feedbackId=100")
	public List<Feedback> getfeedAll();

}
