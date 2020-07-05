package com.alighthub.dms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alighthub.dms.model.Feedback;
import com.alighthub.dms.model.Student;

/*
 * 
 * @author Ravindra Sonawane
 * @page Student Dao
 * @time 08/09/2019 - 9.20 PM
 * @purpose To controll student dao
 * 
 *
 */
@Repository
public interface StudentDao extends JpaRepository<Student,Integer>{
	
	//@Query("from Student s join Feedback f on s.studentFeed=f.feedbackId")
	//public List<Student> getStudentFeedback();
	

}
