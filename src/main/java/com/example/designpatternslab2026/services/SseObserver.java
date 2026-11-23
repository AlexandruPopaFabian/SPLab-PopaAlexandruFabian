package com.example.designpatternslab2026.services;

import com.example.designpatternslab2026.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class SseObserver implements Observer {
    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
        this.emitter.onCompletion(() -> {});
        this.emitter.onTimeout(() -> emitter.complete());
        this.emitter.onError((e) -> emitter.complete());
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(SseEmitter.event()
                    .data(book, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            emitter.completeWithError(e);
        }
    }
}