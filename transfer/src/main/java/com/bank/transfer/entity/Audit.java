package com.bank.transfer.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "audit")
public class Audit {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name="id")
    Long Id;

    @Column(name = "entity_type")
    String entityType;

    @Column(name="operation_type")
    String operation;

    @Column(name="created_by")
    String createdBy;

    @Column(name="modified_by")
    String modifiedBy;

    @Column(name = "created_at")
    Date createdAt;

    @Column(name = "modified_at")
    Date modifiedAt;

    @Column(name="new_entity_json")
    String newEntityJson;

    @Column(name="entity_json")
    String entityJson;
}
