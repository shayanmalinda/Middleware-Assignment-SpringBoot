package com.shayanmalinda.springboot.repository;

import com.shayanmalinda.springboot.entity.Book;
import com.shayanmalinda.springboot.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

}
 