package com.company.entity;

import com.company.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "tag")
public class TagEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
