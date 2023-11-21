package com.gn3.kpc.localnews.model.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "dsvncode")
@Data
@EntityListeners(AuditingEntityListener.class)
public class DsvnCode {
    @Id
    private String dsvnCode;
    @NotBlank
    private String city;
    @NotBlank
    private String dsvn;
}
