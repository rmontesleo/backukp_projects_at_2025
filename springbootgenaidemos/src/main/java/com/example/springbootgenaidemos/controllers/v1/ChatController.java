package com.example.springbootgenaidemos.controllers.v1;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * 
 */
@RestController
@RequestMapping("/v1/chats")
public class ChatController {

    @Autowired    
    private OpenAiChatModel model;


    private ChatClient getDefaultClient(){
        return ChatClient.create(model);
    }

    @GetMapping("/greeting")       
    public String greeting(){
        String response = getDefaultClient()
            .prompt("Get and original say hello")
            .call()
            .content();
        return response;
    }

    @GetMapping("/simpleprompt")
    public String getMethodName(@RequestParam String prompt ) {
        String response = getDefaultClient()
            .prompt(prompt)
            .call()
            .content();
        return response;
    }


    @GetMapping("/pirate")
    public String responseLikeAPirate( @RequestParam String prompt ) {
        String response = getDefaultClient()
            .prompt(prompt)
            .system("You are a helpfull assistant that responds like a pirate")
            .call()
            .content();

        return response;
    }
    
    

}
