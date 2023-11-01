package com.bachelor.nexa.repositories;

import com.bachelor.nexa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByPlayerName(String playername);

    List<User> findTop10ByOrderByLevelDesc();
}
