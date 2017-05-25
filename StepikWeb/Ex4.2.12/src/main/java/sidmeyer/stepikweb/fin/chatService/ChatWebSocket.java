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
        chatService.add(this);
        this.session = session;
    }

    @OnWebSocketMessage
    public void onMessage(String data) {
        try {
            chatService.addMessage(new ChatMessage(Main.staticTestUser, data));
            session.getRemote().sendString("you wrote: " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {

    }
}
