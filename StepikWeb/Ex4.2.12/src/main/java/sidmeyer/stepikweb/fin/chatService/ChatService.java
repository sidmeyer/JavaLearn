package sidmeyer.stepikweb.fin.chatService;

import sidmeyer.stepikweb.fin.dbService.datasets.ChatMessage;
import sidmeyer.stepikweb.fin.dbService.datasets.User;

/**
 * Created by stas on 24.05.17.
 */
public interface ChatService {

    void add(ChatWebSocket chatWebSocket);

    void addMessage(ChatMessage chatMessage);
}
