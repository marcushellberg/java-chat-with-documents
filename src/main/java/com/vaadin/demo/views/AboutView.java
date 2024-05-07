package com.vaadin.demo.views;

import com.vaadin.demo.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
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
                new H1("About DocsChat"),
                new Html("""
                        <div>
                            <p>
                                DocsChat is an example chat application that provides an AI chatbot that uses your own documents as context.
                                The application is built with <a href="https://vaadin.com">Vaadin</a> and <a href="https://github.com/langchain4j/langchain4j">LangChain4j</a>.
                            </p>
                            <p>
                                The application supports both OpenAI (requires an <a href="https://openai.com/index/openai-api">API key</a>), and local models through an OpenAI compatible API like <a href="https://ollama.com/">Ollama</a>.
                            </p>
                            <p>
                                You can find the source code for this application on <a href="https://github.com/marcushellberg/doc-chat">GitHub</a>.
                            </p>
                        </div>
                        """)
        );
    }
}
