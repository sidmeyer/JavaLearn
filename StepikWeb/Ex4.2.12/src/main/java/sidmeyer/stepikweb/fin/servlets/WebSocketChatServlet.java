package sidmeyer.stepikweb.fin.servlets;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import sidmeyer.stepikweb.fin.chatService.ChatService;
import sidmeyer.stepikweb.fin.chatService.ChatWebSocket;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "WebSocketChatServlet", urlPatterns = {"/chat"})
public class WebSocketChatServlet extends WebSocketServlet {
    private static final long LOGOUT_TIME = 10 * 60 * 1000;
    private final ChatService chatService;

    public WebSocketChatServlet(ChatService chatService) {
        this.chatService = chatService;
    }


    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        webSocketServletFactory.setCreator((req, resp) -> new ChatWebSocket(chatService));
    }
}
