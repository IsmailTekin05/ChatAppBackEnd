package com.example.chatappbackend.repository;

import com.example.chatappbackend.model.ChatRoom;
import com.example.chatappbackend.model.Message;
import com.example.chatappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatRoomOrderBySentAtAsc(ChatRoom chatRoom);

    List<Message> findByUserAndSentAtBetween(User user, LocalDateTime start, LocalDateTime end);

    List<Message> findByChatRoomAndIsReadFalseAndUserNot(ChatRoom chatRoom, User currentUser);
}