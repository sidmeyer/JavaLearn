package sidmeyer.stepikweb.fin.chatService;

import sidmeyer.stepikweb.fin.dbService.DbService;
import sidmeyer.stepikweb.fin.dbService.datasets.ChatMessage;

/**
 * Created by stas on 25.05.17.
 */
public class ChatServiceImpl implements ChatService {
    private final DbService dbService;

    public ChatServiceImpl(DbService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void add(ChatWebSocket chatWebSocket) {

    }

    public void addMessage(ChatMessage chatMessage) {
        dbService.addMessage(chatMessage.getUser(), chatMessage.getMessage());
    }
}
