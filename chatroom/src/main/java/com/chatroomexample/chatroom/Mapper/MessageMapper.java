package com.chatroomexample.chatroom.Mapper;

import com.chatroomexample.chatroom.Model.ChatMessage;
import com.chatroomexample.chatroom.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getAllMessages();


    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messagetext}")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int addMessage(ChatMessage chatMessage);
}
