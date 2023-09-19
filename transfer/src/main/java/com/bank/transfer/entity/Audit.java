package com.bank.transfer.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema ="transfer", name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    Long Id;

    @Column(name = "entity_type", nullable = false, length = 40)
    String entityType;

    @Column(name="operation_type", nullable = false)
    String operationType;

    @Column(name="created_by", nullable = false)
    String createdBy;

    @Column(name="modified_by")
    String modifiedBy;

    @Column(name = "created_at", nullable = false)
    Timestamp createdAt;

    @Column(name = "modified_at")
    Timestamp modifiedAt;

    @Column(name="new_entity_json")
    String newEntityJson;

    @Column(name="entity_json", nullable = false)
    String entityJson;
}
