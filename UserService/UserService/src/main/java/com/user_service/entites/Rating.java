package com.user_service.entites;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Rating {

    private String ratingid;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
