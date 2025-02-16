package com.example.chatappbackend.controller;

import com.example.chatappbackend.exception.UserNotFoundException;
import com.example.chatappbackend.model.ChatRoom;
import com.example.chatappbackend.model.User;
import com.example.chatappbackend.service.ChatRoomService;
import com.example.chatappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final UserService userService;

    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService, UserService userService) {
        this.chatRoomService = chatRoomService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<ChatRoom>> getAllChatRooms() {
        return ResponseEntity.ok(chatRoomService.getAllChatRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable Long id) {
        return chatRoomService.getChatRoomById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    for (User participant : chatRoom.getParticipants()) {
        User user = userService.getUserById(participant.getId())
                .orElseThrow(() -> new UserNotFoundException("User with ID " + participant.getId() + " not found."));
        participants.add(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteChatRoom(@PathVariable Long id) {
        return chatRoomService.getChatRoomById(id)
                .map(chatRoom -> {
                    chatRoomService.deleteChatRoom(chatRoom.getId());
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/groups")
    public ResponseEntity<List<ChatRoom>> getGroupChatRooms() {
        return ResponseEntity.ok(chatRoomService.getGroupChatRooms());
    }

    @GetMapping("/direct")
    public ResponseEntity<List<ChatRoom>> getDirectChatRooms() {
        return ResponseEntity.ok(chatRoomService.getDirectChatRooms());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChatRoom>> getChatRoomsByUser(@PathVariable Long userId) {
        return userService.getUserById(userId)
                .map(user -> ResponseEntity.ok(chatRoomService.getChatRoomsByParticipant(user)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
