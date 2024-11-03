package com.example.URLShortner.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "request_entity")
public class RequestEntity {
    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId
    @Column(nullable = false)
    private String requestKey; // Change the name from 'key' to 'requestKey'

    @Column(nullable = false)
    private String URL;

    public String getKey() {
        return requestKey;
    }
    public RequestEntity(String requestKey, String url) {
        this.requestKey = requestKey;
        this.URL = url;
    }
}
