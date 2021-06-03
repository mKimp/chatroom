package com.chatroomexample.chatroom.Controller;

import com.chatroomexample.chatroom.Model.ChatForm;
import com.chatroomexample.chatroom.Services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatRoom(@ModelAttribute("messageForm") ChatForm messageForm, Model model){
        model.addAttribute("chatMessages", this.messageService.getList());
        return "chat";
    }
    @PostMapping
    public String postChatRoom(@ModelAttribute("messageForm") ChatForm messageForm, Model model){
        this.messageService.addMessage(messageForm);
        model.addAttribute("chatMessages", this.messageService.getList());
        messageForm.setUserMessage("");
        messageForm.setUserName("");
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
