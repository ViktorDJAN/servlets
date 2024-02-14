package org.example.command;


import org.example.command.action.*;
import org.example.command.show.ShowAdminPageCommand;
import org.example.command.show.ShowAuthorizationCommand;
import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    AUTHORIZATION(new AuthorizationCommand()),
    BAN_USER(new BanUserByAdminCommand()),
    SEND_CHAT_MESSAGE(new ChatSendMessageCommand()),


    SHOW_ADMIN_PAGE(new ShowAdminPageCommand()),
    SHOW_AUTHORIZATION_PAGE(new ShowAuthorizationCommand()),
    SHOW_CHAT_PAGE(new ShowChatPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
