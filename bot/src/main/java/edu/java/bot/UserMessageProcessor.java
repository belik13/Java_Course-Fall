package edu.java.bot;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.Commands.CommandInterface;
import edu.java.bot.Commands.HelpCommand;
import edu.java.bot.Commands.ListCommand;
import edu.java.bot.Commands.StartCommand;
import edu.java.bot.Commands.TrackCommand;
import edu.java.bot.Commands.UntrackCommand;
import java.util.List;

public class UserMessageProcessor {

        private UserMessageProcessor() {
        }

        public static List<? extends CommandInterface> commands() {
            return List.of(
                new HelpCommand(),
                new StartCommand(),
                new ListCommand(),
                new TrackCommand(),
                new UntrackCommand()
            );
        }

        public static SendMessage process(Update update) {
            if (update.message() == null) {
                return null;
            }

            for (var command : commands()) {
                if (command.supports(update)) {
                    return command.handle(update);
                }
            }

            return new SendMessage(update.message().chat().id(), "No such command, use /help");
        }
    }
