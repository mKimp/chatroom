package com.chatroomexample.chatroom.Model;

public class ChatMessage {
    private Integer messageId;
    private String username;
    private String messagetext;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messagetext;
    }

    public void setMessageText(String messageText) {
        this.messagetext = messageText;
    }
}
