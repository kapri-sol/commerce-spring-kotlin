package com.commerce.kotlin.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.Where
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Where(clause = "deleted IS FALSE")
@Entity
class Seller(
    name: String,
    address: String,
)
{
    @Id
    @GeneratedValue
    val id: Long? = null;

    var name: String? = name
        private set;

    var address: String? = address
        private set;

    private var deleted: Boolean = false;

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now();

    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now();

    fun remove() {
        this.deleted = true;
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun updateAddress(address: String) {
        this.address = address
    }
}