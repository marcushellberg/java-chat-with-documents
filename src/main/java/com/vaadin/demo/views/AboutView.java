package com.vaadin.demo.views;

import com.vaadin.demo.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    public AboutView() {
        add(
                new H1("About Docs Chat"),
                new Paragraph("Docs Chat is a simple chat application that uses LangChain4j to provide AI-powered responses. " +
                        "The AI is trained on a set of documents that are imported into the system. " +
                        "The AI is able to provide responses based on the context of the conversation."),
                new Paragraph("This application is built using Vaadin and LangChain4j."),
                new Paragraph("You can find the source code for this application on GitHub: TODO")
        );
    }
}
