package com.yash.dev.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.dev.rest.model.NoteUtil;

/**
 * Created by Yashwanth Anand S
 **/

public interface NoteRepository extends JpaRepository<NoteUtil, Long> {

}
