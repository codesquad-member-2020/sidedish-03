package kr.codesquad.sidedish.business.ktdto

import kr.codesquad.sidedish.business.dto.BadgeDto

data class DishDto(
        val topImage: String,
        val description: String,
        val point: Long,
        val deliveryInfo: String,
        val deliveryFee: String,
        val normalPrice: Long,
        val salePrice: Long,
        var thumbImages: List<String>? = emptyList(),
        var detailSectionImages: List<String>? = emptyList(),
        var  badges: List<BadgeDto>? = emptyList()
)
