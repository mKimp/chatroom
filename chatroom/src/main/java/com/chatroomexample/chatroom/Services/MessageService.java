package com.chatroomexample.chatroom.Services;

import com.chatroomexample.chatroom.Mapper.MessageMapper;
import com.chatroomexample.chatroom.Model.ChatForm;
import com.chatroomexample.chatroom.Model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }
    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUserName());
        switch (chatForm.getMessageType()){
            case "Say":
                newMessage.setMessageText(chatForm.getUserMessage());
                break;
            case "Shout":
                newMessage.setMessageText(chatForm.getUserMessage().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(chatForm.getUserMessage().toLowerCase());
                break;

        }
        messageMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getList() {
        if (messageMapper.getAllMessages() == null)
            return null;
        else
            return messageMapper.getAllMessages();
    }

}
