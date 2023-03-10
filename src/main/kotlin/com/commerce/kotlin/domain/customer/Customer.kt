package com.commerce.kotlin.domain.customer

import com.commerce.kotlin.common.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.Where

@Where(clause = "deleted IS FALSE")
@Entity
class Customer(
    name: String,
    address: String,
) : BaseEntity()
{
    @Id
    @GeneratedValue
    val id: Long? = null

    var name: String = name
        private set

    var address: String = address
        private set

    var deleted: Boolean = false

    fun remove() {
        this.deleted = true
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun updateAddress(address: String) {
        this.address = address
    }
}