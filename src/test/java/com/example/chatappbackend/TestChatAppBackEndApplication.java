package com.example.chatappbackend;

import org.springframework.boot.SpringApplication;

public class TestChatAppBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.from(ChatAppBackEndApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
