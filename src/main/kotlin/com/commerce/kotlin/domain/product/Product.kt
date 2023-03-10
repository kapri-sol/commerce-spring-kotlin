package com.commerce.kotlin.domain.product

import com.commerce.kotlin.common.entity.BaseEntity
import com.commerce.kotlin.domain.seller.Seller
import jakarta.persistence.*
import jakarta.persistence.FetchType.LAZY
import org.hibernate.annotations.Where

@Where(clause = "deleted IS FALSE")
@Entity
class Product(
    title: String,
    description: String,
    image: String,
    price: Int,
    stockQuantity: Int,
) : BaseEntity()
{
    @GeneratedValue
    @Id
    val id: Long? = null

    @ManyToOne(fetch = LAZY)
    @JoinColumn
    var seller: Seller? = null
        private set

    var title: String = title
        private set

    var image: String = image
        private set

    @Column(columnDefinition = "TEXT")
    var description: String = description
        private set

    var price: Int = price
        private set

    var stockQuantity: Int = stockQuantity
        private set

    var deleted: Boolean? = false

    init {
        if (stockQuantity <= 0) {
            throw Error()
        }
    }

    fun connectSeller(seller: Seller) {
        if (this.seller != null) {
            throw Error()
        }
        this.seller = seller
    }

    fun remove() {
        this.deleted = true
    }

    fun changeName(name: String) {
        this.title = name
    }

    fun changeDescription(description: String) {
        this.description = description
    }

    fun changeImage(image: String) {
        this.image = image
    }

    fun increaseQuantity(increaseCount: Int) {
        if (increaseCount <= 0) {
           throw Error()
        }
        this.stockQuantity += increaseCount
    }

    fun order(orderCount: Int) {
        if (this.stockQuantity < orderCount) {
            println(this.stockQuantity)
            println(orderCount)
           throw IllegalStateException("Stock Quantity is Inefficient")
        }
        this.stockQuantity -= orderCount
    }
}