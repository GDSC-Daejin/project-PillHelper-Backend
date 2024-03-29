package com.solchael.solchael.domain.wishlist.dto;

import com.solchael.solchael.domain.wishlist.entity.WishList;
import lombok.*;

/**
 * 화면에 보여지는 건 그냥 약 이름이랑 이미지만?
 * 약 누르면 해당 id로 상세조회 쿼리문 날리면 될듯??
 */
@Getter
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class WishListDto {

    private Long id;
    private Long medicineId;
    private String name;
    private String image;

    public static WishListDto toEntity(WishList wishList) {
        return WishListDto.builder()
                .id(wishList.getId())
                .medicineId(wishList.getMedicine().getId())
                .name(wishList.getMedicine().getName())
                .image(wishList.getMedicine().getItemImage())
                .build();
    }
}
