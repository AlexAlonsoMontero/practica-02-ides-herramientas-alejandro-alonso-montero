package com.bucador_ides.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bucador_ides.main.model.HerramientasDto;

@Service
public class HerramientasService implements HerramientasServiceInterface {

    private final ChatClient chatClient;

    public HerramientasService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Value("${text.system}")
    private String textSystem;
    @Value("${text.user}")
    private String textUser;

    @Override
    public List<HerramientasDto> getHerramientas(String tecnologia) {
        var systemTemplate = new PromptTemplate(textSystem);
        var userTemplate = new PromptTemplate(textUser);

        var prompt = new Prompt(
                systemTemplate.createMessage(Map.of("tecnologia", tecnologia)),
                userTemplate.createMessage(Map.of("tecnologia", tecnologia)));
        return List.of(chatClient
                .prompt(prompt)
                .call()
                .entity(HerramientasDto[].class));
    }

}
