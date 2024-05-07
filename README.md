# Java AI chatbot that uses your documents as context 

This app demonstrates how you can create a custom AI chatbot that can use your own documents to answer questions using RAG (retrieval augmented generation).
The chatbot uses LangChain4j and the OpenAI API to generate responses and the Vaadin framework to create the user interface.

Documents are parsed with the Apache Tika library to support most common files.

## Configuration

To use the application, you need to configure the following two properties in the `application.properties` file:

- `langchain4j.open-ai.streaming-chat-model.api-key`, defaults to the `OPENAI_API_KEY` environment variable
- `docs.location`, the location of the documents to be used by the chatbot. 

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).
