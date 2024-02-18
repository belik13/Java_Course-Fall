package edu.java.bot.MockDB;

import java.util.HashSet;

class User {

    User(Object chatId, HashSet<String> links) {
        this.chatId = chatId;
        this.links = links;
    }

    Object chatId;
    HashSet<String> links;
}
