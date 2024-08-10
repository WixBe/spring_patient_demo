package com.ust.patient_demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String illnessTerm;
}
