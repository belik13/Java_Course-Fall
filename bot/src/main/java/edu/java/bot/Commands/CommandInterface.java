package edu.java.bot.Commands;

import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public interface CommandInterface {
    String command();

    String description();

    SendMessage handle(Update update);

    default boolean supports(Update update) {
        if (update.message().text().startsWith(command())) {
            return true;
        }

        return false;
    }

    default BotCommand toApiCommand() {
        return new BotCommand(command(), description());
    }
}
