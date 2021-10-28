package com.sara.sangam.entity

import lombok.Data
import java.time.LocalDateTime
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@Data
@MappedSuperclass
abstract class AbstractEntity {
    var createdTs: LocalDateTime = LocalDateTime.now()
    var updatedTs: LocalDateTime = LocalDateTime.now()

    @PrePersist
    fun prePersist() {
        this.createdTs = LocalDateTime.now()
        this.updatedTs = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        this.updatedTs = LocalDateTime.now()
    }
}