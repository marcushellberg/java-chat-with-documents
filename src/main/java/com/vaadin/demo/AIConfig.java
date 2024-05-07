package com.vaadin.demo;

import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.Tokenizer;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AIConfig {

    private static final Logger log = LoggerFactory.getLogger(AIConfig.class);

    @Value("${docs.location}")
    private String docsLocation;


    /*
     * Keep track of the chat history for each chat.
     * This is used to generate the context for the AI.
     * Consider using TokenWindowChatMemory for more control.
     */
    @Bean
    ChatMemoryProvider chatMemoryProvider() {
        return chatId -> MessageWindowChatMemory.withMaxMessages(10);
    }

    /*
     * Define the embedding store (Vector database) to use.
     * Defaults to an in-memory store, use a proper database for larger datasets.
     * See
     * https://docs.langchain4j.dev/integrations/embedding-stores/ for more information.
     */
    @Bean
    EmbeddingStore<TextSegment> embeddingStore() {
        return new InMemoryEmbeddingStore<>();
    }

    /*
     * Import the documents from the file system into the embedding store.
     * Note: In real-world scenarios, you most likely want to process docs
     * on a separate build server as they are updated, not in the app that's
     * consuming them.
     */
    @Bean
    ApplicationRunner docImporter(EmbeddingStore<TextSegment> embeddingStore) {
        return args -> {
            if (docsLocation == null || docsLocation.isEmpty()) {
                log.error("No document location specified, configure 'docs.location' in application.properties");
                return;
            }
            log.info("Importing documents from {}", docsLocation);
            var docs = FileSystemDocumentLoader.loadDocuments(docsLocation);
            EmbeddingStoreIngestor.ingest(docs, embeddingStore);
            log.info("Imported {} documents", docs.size());
        };
    }

    /*
     * Define the content retriever to use. This is used to retrieve the relevant parts of a documents
     * from the embedding store before answering questions.
     */
    @Bean
    ContentRetriever contentRetriever(EmbeddingStore<TextSegment> embeddingStore) {
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }
}
