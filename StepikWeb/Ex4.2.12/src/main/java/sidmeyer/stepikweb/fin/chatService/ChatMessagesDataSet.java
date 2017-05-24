package sidmeyer.stepikweb.fin.chatService;

import sidmeyer.stepikweb.fin.dbService.datasets.UsersDataSet;

import javax.persistence.*;

/**
 * Created by stas on 24.05.17.
 */
@Entity
@Table(name = "Messages")
public class ChatMessagesDataSet {

    @Id
    @Column(name = "MessageId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @Column(name = "Message")
    private final String message;

    @Column(name = "UserId")
    private final long userId;



    public ChatMessagesDataSet(String message, UsersDataSet user) {
        this.message = message;
        this.userId = user.getUserId();
    }

}
