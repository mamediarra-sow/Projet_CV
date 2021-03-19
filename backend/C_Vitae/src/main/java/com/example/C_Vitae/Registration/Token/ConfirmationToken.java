package com.example.C_Vitae.Registration.Token;
import com.example.C_Vitae.Model.Personne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class ConfirmationToken {
    @Id
    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_sequence"
    )
    private Integer id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(nullable = false,name = "personne_id")
    private Personne personne;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt,Personne personne) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.personne = personne;
    }
}
