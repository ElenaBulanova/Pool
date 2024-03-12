package com.example.pool.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "session_fines_t")
public class SessionFines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    Session session;

    @ManyToOne
    @JoinColumn(name = "fine_id")
    Fine fine;

    @Column(name = "count")
    private Integer count;

}
