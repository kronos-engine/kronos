package com.domino.kronos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Audit {
    @Field("created_by")
    @CreatedBy
    private String createdBy;
    @Field("created_date")
    @CreatedDate
    private LocalDateTime createdDate;
    @Field("modified_by")
    @LastModifiedBy
    private String modifiedBy;
    @Field("modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    @Version
    private int version;
}
