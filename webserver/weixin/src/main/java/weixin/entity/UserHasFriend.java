package weixin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author zjz20
 */
@Data
@Entity
@Table(name = "userhasfriend")
public class UserHasFriend implements Serializable {

        @Data
        @Embeddable
        public static class Id implements Serializable {

                @Column(name = "user1_id")
                private long user1Id;

                @Column(name = "user2_id")
                private long user2Id;

                public Id() {
                }

                public Id(long user1Id, long user2Id) {
                        this.user1Id = user1Id;
                        this.user2Id = user2Id;
                }

        }

        @EmbeddedId
        private Id id;

        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
        private Date createdAt;

        public UserHasFriend() {
        }

        public UserHasFriend(long user1Id,
                             long user2Id,
                             Date createdAt) {
                this.id = new Id(user1Id, user2Id);
                this.createdAt = createdAt;
        }
}
