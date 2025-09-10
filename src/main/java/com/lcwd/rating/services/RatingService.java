package com.lcwd.rating.services;

import com.lcwd.rating.payload.RatingDto;

import java.util.List;

public interface RatingService {
    //create
    RatingDto createRating(RatingDto ratingDto);

    //get all ratings
    List<RatingDto> getAllRatings();

    //get single rating
    RatingDto getRatingById(String ratingId);

    //get all ratings by userId
    List<RatingDto> getAllRatingsByUserId(String userId);

    //get all ratings by hotelId
    List<RatingDto> getAllRatingsByHotelId(String hotelId);
}
