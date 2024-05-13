package com.vaadin.demo.views;

import com.vaadin.demo.AiAssistant;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.firitin.components.messagelist.MarkdownMessage;

import java.util.UUID;

@PageTitle("Chat")
@Route(value = "", layout = MainLayout.class)
public class ChatView extends VerticalLayout {

    private String chatId = UUID.randomUUID().toString();

    public ChatView(AiAssistant aiAssistant) {
        var newChatButton = new Button("New Chat");
        var messageList = new VerticalLayout();
        var messageInput = new MessageInput();

        setPadding(false);
        setSpacing(false);
        messageList.setPadding(false);
        messageList.setSpacing(false);

        newChatButton.addClassName("new-chat-button");
        newChatButton.addClickListener(e -> {
            chatId = UUID.randomUUID().toString();
            messageList.removeAll();
        });

        messageInput.setWidthFull();
        messageInput.addSubmitListener(e -> {
            var question = e.getValue();
            var answer = new MarkdownMessage("Assistant");

            messageList.add(new MarkdownMessage(question, "You"));
            messageList.add(answer);

            aiAssistant.chat(chatId, question)
                    .onNext(answer::appendMarkdownAsync)
                    .onError(err -> System.err.println("ooops" + e))
                    .start();
        });

        add(newChatButton);
        addAndExpand(new Scroller(messageList));
        add(messageInput);
    }

}
