# Java AI chatbot that uses your documents as context 

This app demonstrates how you can create a custom AI chatbot that can use your own documents to answer questions using RAG (retrieval augmented generation).
The chatbot uses LangChain4j and the OpenAI API to generate responses and the Vaadin framework to create the user interface.

Documents are parsed with the Apache Tika library to support most common files.

## Configuration

This app supports OpenAI and local OpenAI compatible APIs. 

You need an [OpenAI API key](https://platform.openai.com/api-keys) to use OpenAI. 
Local mode has been tested with [Ollama](https://ollama.com/) and the `llama3` model.

**Update `application.properties` before running the application.** 

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).
