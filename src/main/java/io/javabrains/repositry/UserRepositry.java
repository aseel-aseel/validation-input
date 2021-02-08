package io.javabrains.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.entity.User;


@Repository
public interface UserRepositry extends JpaRepository<User,Long>{

}
