package com.example.designpatternslab2026.commands;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsynchronousCommandExecutor implements CommandExecutor {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Override
    public <T> T execute(Command<T> command) {
        executorService.submit(command::execute);
        return null; // Pentru asincron se returnează răspuns 202 Accepted în controller
    }
}