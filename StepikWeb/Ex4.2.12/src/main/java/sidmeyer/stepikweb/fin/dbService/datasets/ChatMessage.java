package sidmeyer.stepikweb.fin.dbService.datasets;

import sidmeyer.stepikweb.fin.dbService.datasets.User;

import javax.persistence.*;

/**
 * Created by stas on 24.05.17.
 */
@Entity
@Table(name = "Messages")
public class ChatMessage {

    @Id
    @Column(name = "MessageId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long messageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private final User user;

    @Column(name = "Message")
    private final String message;

    public ChatMessage(long messageId, User user, String message) {
        this.messageId = messageId;
        this.user = user;
        this.message = message;
    }

//    public ChatMessage() {
//    }

    public long getMessageId() {
        return messageId;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "messageId=" + messageId +
                ", user=" + user +
                ", message='" + message + '\'' +
                '}';
    }
}
