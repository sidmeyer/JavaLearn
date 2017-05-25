package sidmeyer.stepikweb.fin.chatService;

import sidmeyer.stepikweb.fin.dbService.DbService;
import sidmeyer.stepikweb.fin.dbService.datasets.ChatMessage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stas on 25.05.17.
 */
public class ChatServiceImpl implements ChatService {
    private final DbService dbService;

    private Set<ChatWebSocket> chatSockets = new HashSet<>();

    public ChatServiceImpl(DbService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void add(ChatWebSocket chatWebSocket) {
        chatSockets.add(chatWebSocket);
    }

    public void addMessage(ChatMessage chatMessage) {
        dbService.addMessage(chatMessage.getUser(), chatMessage.getMessage());

        for (ChatWebSocket currentChatWebSocket : chatSockets) {
            currentChatWebSocket.sendMessage(chatMessage.getMessage());
        }
    }
}
