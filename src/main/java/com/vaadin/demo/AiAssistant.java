package com.vaadin.demo;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AiAssistant {

    @SystemMessage("""
            You are a friendly and helpful assistant.
            Answer the questions as accurately as possible using the provided documents.
            If you do not know the answer, say "I don't know".
            """)
    TokenStream chat(@MemoryId String chatId, @UserMessage String userMessage);
}
