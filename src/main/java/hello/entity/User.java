package hello.entity;

import java.sql.Timestamp;
import java.time.Instant;

public class User {
    private int id;
    private String name;
    private String avatar;
    private Instant createdAt;
    private Instant updatedAt;

    public User(int id, String name, String avatar, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}





