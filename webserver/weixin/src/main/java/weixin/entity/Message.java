package weixin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author zjz20
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Person sender;
    
    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Person receiver;
    
    @Column(name = "created_at")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "msg_content")
    private String msgContent;
    
    @Column(name = "image")
    private String imagePath;

    public Message() {
    }

    public Message(Person sender, 
                   Person receiver, 
                   Date createdAt, 
                   String msgContent, 
                   String imagePath) {
        this.sender = sender;
        this.receiver = receiver;
        this.createdAt = createdAt;
        this.msgContent = msgContent;
        this.imagePath = imagePath;
    }
    
}
