package com.geekster.Music.Streaming.Service.API.repository;

import com.geekster.Music.Streaming.Service.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {


}
