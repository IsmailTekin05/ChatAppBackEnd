package com.example.chatappbackend.service;

import com.example.chatappbackend.model.ChatRoom;
import com.example.chatappbackend.model.User;
import com.example.chatappbackend.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    public Optional<ChatRoom> getChatRoomById(Long id) {
        return chatRoomRepository.findById(id);
    }

    public List<ChatRoom> getChatRoomsByParticipant(User user) {
        return chatRoomRepository.findByParticipant(user);
    }

    public List<ChatRoom> getGroupChatRooms() {
        return chatRoomRepository.findByIsGroup(true);
    }

    public List<ChatRoom> getDirectChatRooms() {
        return chatRoomRepository.findByIsGroup(false);
    }

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public void deleteChatRoom(Long id) {
        chatRoomRepository.deleteById(id);
    }
}