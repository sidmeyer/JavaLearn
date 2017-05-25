package sidmeyer.stepikweb.fin.dbService.datasets;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Messages")
public class ChatMessage implements Serializable {

    private static final long serialVersionUID = -5170875020617735653L;

    @Id
    @Column(name = "MessageId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    @Column(name = "Message")
    private String message;

    public ChatMessage(User user, String message) {
        this.messageId = messageId;
        this.user = user;
        this.message = message;
    }

    public ChatMessage() {
    }

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
