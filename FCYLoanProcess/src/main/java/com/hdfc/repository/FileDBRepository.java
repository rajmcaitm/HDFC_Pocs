package com.hdfc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.entities.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {

}