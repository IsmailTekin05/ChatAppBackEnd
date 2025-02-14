package com.example.chatappbackend.repository;

import com.example.chatappbackend.model.Message;
import com.example.chatappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderAndReceiverOrderByTimestampDesc(User sender, User receiver);
    List<Message> findBySenderOrReceiverOrderByTimestampDesc(User sender, User receiver);
}