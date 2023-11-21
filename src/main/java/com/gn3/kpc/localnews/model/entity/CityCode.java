package com.gn3.kpc.localnews.model.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "citycode")
@Data
@EntityListeners(AuditingEntityListener.class)
public class CityCode {
    @Id
    private String localCode;
    @NotBlank
    private String city;
}
