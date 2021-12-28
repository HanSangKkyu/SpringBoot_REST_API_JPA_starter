package com.example.demo.repository.mysql;

import com.example.demo.entity.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository // 없어도 된다.
public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository<User, Long>를 상속만해도 CRUD는 자동으로 만들어 진다.

}
