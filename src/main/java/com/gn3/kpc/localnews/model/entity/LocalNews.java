package com.gn3.kpc.localnews.model.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "localnews")
@Data
@EntityListeners(AuditingEntityListener.class)
public class LocalNews {
    @Id
    private String link;
    private String title;
    private String joinDate;
    @NotBlank
    private String cityNo;
    @NotBlank
    private String dvsnNo;
}
