package sidmeyer.stepikweb.fin.chatService;

import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Created by stas on 24.05.17.
 */
@WebSocket
public class ChatWebSocket {

    private ChatService chatService;

    public ChatWebSocket(ChatService chatService) {
        this.chatService = chatService;
    }
}
