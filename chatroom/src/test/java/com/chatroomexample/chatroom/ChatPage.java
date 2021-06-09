package com.chatroomexample.chatroom;

import com.chatroomexample.chatroom.Model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "submitMessage")
    private WebElement submitMessage;

    @FindBy(className = "chatMessageUsername")
    private WebElement firstMessageUsername;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;

    public ChatPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void sendMessage(String text){
        messageText.sendKeys(text);
        submitMessage.click();
    }

    public ChatMessage getFirstMessage(){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessageText(firstMessageText.getText());
        chatMessage.setUsername(firstMessageUsername.getText());
        return chatMessage;
    }
}
