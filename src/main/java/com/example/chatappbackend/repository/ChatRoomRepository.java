package com.example.chatappbackend.repository;

import com.example.chatappbackend.model.ChatRoom;
import com.example.chatappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    @Query("SELECT cr FROM ChatRoom cr JOIN cr.participants p WHERE p = :user")
    List<ChatRoom> findByParticipant(User user);

    List<ChatRoom> findByIsGroup(boolean isGroup);
}