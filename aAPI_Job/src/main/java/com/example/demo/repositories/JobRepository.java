package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.job.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
