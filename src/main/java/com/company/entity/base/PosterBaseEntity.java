package com.company.entity.base;

import com.company.entity.AttachEntity;
import com.company.entity.UserEntity;
import com.company.enums.GenStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
@Setter
@Getter
@MappedSuperclass
public class PosterBaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false,nullable = false)
    private String id;


    @Column(name = "user_id")
    private String userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "attach_id")
    private String attachId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_id", insertable = false, updatable = false)
    private AttachEntity attach;

    @Column(nullable = false)
    private String payment;

    @Column
    private Integer viewCount;
    @Column(nullable = false)
    private String timeToApply;
    @Column
    private String purpose;
    @Column
    private Boolean viewUsers;  //admin

    @Column
    @Enumerated(EnumType.STRING)
    private GenStatus status;


    @Column
    private Boolean visible;
    @Column
    private LocalDateTime createdDate = LocalDateTime.now();
    @Column
    private LocalDateTime updatedDate;
    @Column
    private LocalDateTime deletedDate;
}
