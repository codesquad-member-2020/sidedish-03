package kr.codesquad.sidedish.business.ktdto

import kr.codesquad.sidedish.business.dto.BadgeDto

data class DishDto(
        val topImage: String,
        val description: String,
        val point: String,
        val deliveryInfo: String,
        val deliveryFee: String,
        val normalPrice: String,
        val salePrice: String,
        var thumbImages: List<String>? = emptyList(),
        var detailSectionImages: List<String>? = emptyList(),
        var  badges: List<BadgeDto>? = emptyList()
)
