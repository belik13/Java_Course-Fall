package edu.java.bot.Commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.MockDB.MockDB;

public class TrackCommand implements CommandInterface {

    public String command() {
        return "/track";
    }

    public String description() {
        return "Track new link";
    }

    public SendMessage handle(Update update) {
        var chatId = update.message().chat().id();
        String link = update.message().text().substring(command().length()).trim();

        if (link.equals("") || link.contains(" ")) {
            return new SendMessage(chatId, "Wrong arguments, send one link as argument");
        }

        MockDB.addLink(chatId, link);
        return new SendMessage(update.message().chat().id(), "Link succsefully added");
    }

}
