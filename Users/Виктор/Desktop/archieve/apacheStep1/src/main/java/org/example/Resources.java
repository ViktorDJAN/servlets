package org.example;

public final class Resources {

    public static final String PAGE_LOGIN = "/WEB-INF/jsp/login.jsp";
    public static final String PAGE_CHAT = "/WEB-INF/jsp/chat.jsp";
    public static final String PAGE_AUTHORIZATION = "/WEB-INF/jsp/authorization.jsp";
    public static final String PAGE_ADMIN = "/WEB-INF/jsp/admin_page.jsp";


    public static final String COMMAND_SHOW_ADMIN_PAGE = "chat?command=show_admin_page";
    public static final String COMMAND_SHOW_LOGIN_PAGE = "chat?command=show_login_page";
    public static final String COMMAND_SHOW_AUTHORIZATION_PAGE = "chat?command=show_authorization_page";
    public static final String COMMAND_SHOW_CHAT_PAGE = "chat?command=show_chat_page";

    private Resources() {
    }
}
