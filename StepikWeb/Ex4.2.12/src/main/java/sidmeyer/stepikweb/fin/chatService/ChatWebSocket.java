package sidmeyer.stepikweb.fin.chatService;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import sidmeyer.stepikweb.fin.dbService.datasets.ChatMessage;
import sidmeyer.stepikweb.fin.dbService.datasets.User;
import sidmeyer.stepikweb.fin.main.Main;

import java.io.IOException;

/**
 * Created by stas on 24.05.17.
 */
@WebSocket
public class ChatWebSocket {

    private ChatService chatService;
    private Session session;

    public ChatWebSocket(ChatService chatService) {
        this.chatService = chatService;
    }

    @OnWebSocketConnect
    public void onOpen(Session session) {
        this.session = session;
        chatService.add(this);
    }

    @OnWebSocketMessage
    public void onMessage(String data) {
            chatService.addMessage(new ChatMessage(Main.staticTestUser, data));
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {

    }

    public void sendMessage(String message) {
        try {
            session.getRemote().sendString("your message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
