package com.ust.patient_demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "patients",
    uniqueConstraints =
            {
                    @UniqueConstraint(columnNames = "email"),
                    @UniqueConstraint(columnNames = "phone")
            })
@EntityListeners((AuditingEntityListener.class))
@SequenceGenerator(initialValue = 100,name = "patient_seq", allocationSize = 1)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    private long id;
    private String fullName;
    private String email;
    private String phone;
    private LocalDate dob;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "patient-illness",
        joinColumns = { @JoinColumn(name = "patient_id")},
        inverseJoinColumns = {@JoinColumn(name = "illness_id")})
    List<Illness> illnesses;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
