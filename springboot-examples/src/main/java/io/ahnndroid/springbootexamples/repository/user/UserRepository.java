package io.ahnndroid.springbootexamples.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ahnndroid.springbootexamples.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
