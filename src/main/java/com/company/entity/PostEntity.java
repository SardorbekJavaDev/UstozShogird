package com.company.entity;

import com.company.entity.base.PosterBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "post")
public class PostEntity extends PosterBaseEntity {

    @Column(nullable = false)
    private String profession;

}
