package com.example.chatappbackend.service;

import com.example.chatappbackend.model.ChatRoom;
import com.example.chatappbackend.model.Message;
import com.example.chatappbackend.model.User;
import com.example.chatappbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    public List<Message> getMessagesByChatRoom(ChatRoom chatRoom) {
        return messageRepository.findByChatRoomOrderBySentAtAsc(chatRoom);
    }

    public List<Message> getMessagesByUserInTimeRange(User user, LocalDateTime start, LocalDateTime end) {
        return messageRepository.findByUserAndSentAtBetween(user, start, end);
    }

    public List<Message> getUnreadMessagesByChatRoom(ChatRoom chatRoom, User currentUser) {
        return messageRepository.findByChatRoomAndIsReadFalseAndUserNot(chatRoom, currentUser);
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    public void markAsRead(List<Message> messages) {
        messages.forEach(message -> message.setRead(true));
        messageRepository.saveAll(messages);
    }
}