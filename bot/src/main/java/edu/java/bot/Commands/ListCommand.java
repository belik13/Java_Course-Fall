package edu.java.bot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.MockDB.MockDB;

public class ListCommand implements CommandInterface {

    public String command() {
        return "/list";
    }

    public String description() {
        return "Print all tracking links";
    }

    public SendMessage handle(Update update) {
        var chatId = update.message().chat().id();

        StringBuilder stringBuilder = new StringBuilder();
        var links = MockDB.getLinks(chatId);
        if (links == null || links.isEmpty()) {
            return new SendMessage(chatId, "No tracking links");
        }

        for (var link : links) {
            stringBuilder.append(link + "\n");
        }

        return new SendMessage(chatId, stringBuilder.toString());
    }

}
