package kr.codesquad.sidedish.business.ktdto

import kr.codesquad.sidedish.business.dto.BadgeDto

data class DishDto(
        val topImage: String,
        val description: String,
        val point: String,
        val deliveryInfo: String,
        val deliveryFee: String,
        val normalPrice: String,
        val salePrice: String
) {
    var thumbImages: List<String> = ArrayList()
    var detailSectionImages: List<String> = ArrayList()
    var badges: List<BadgeDto> = ArrayList()

    override fun toString(): String {
        return "DishDto(topImage='$topImage', description='$description', point='$point', deliveryInfo='$deliveryInfo', deliveryFee='$deliveryFee', normalPrice='$normalPrice', salePrice='$salePrice', thumbImages=$thumbImages, detailSectionImages=$detailSectionImages, badges=$badges)"
    }
}
