package com.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
