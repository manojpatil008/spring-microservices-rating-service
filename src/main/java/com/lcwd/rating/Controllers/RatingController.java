package com.lcwd.rating.Controllers;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.payload.RatingDto;
import com.lcwd.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create rating
    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto){
        RatingDto ratingDto1 = ratingService.createRating(ratingDto);
        return new ResponseEntity<RatingDto>(ratingDto1, HttpStatus.CREATED);
    }

    //get all ratings
    @GetMapping
    public ResponseEntity<List<RatingDto>> getAllRatings(){
        List<RatingDto> listOfRatings = ratingService.getAllRatings();
        return new ResponseEntity<>(listOfRatings,HttpStatus.OK);
    }

    //get single rating
    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingDto> getRatingById(@PathVariable String ratingId){
        RatingDto ratingDto = ratingService.getRatingById(ratingId);
        return new ResponseEntity<>(ratingDto,HttpStatus.OK);
    }

    //get rating lists by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RatingDto>> getRatingByUserId(@PathVariable String userId){
        List<RatingDto> ratingDtoList = ratingService.getAllRatingsByUserId(userId);
        return new ResponseEntity<>(ratingDtoList,HttpStatus.OK);
    }

    //get ratings by hotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<RatingDto>> getRatingsByHotelId(@PathVariable String hotelId){
        List<RatingDto> ratingDtoList = ratingService.getAllRatingsByHotelId(hotelId);
        return new ResponseEntity<>(ratingDtoList,HttpStatus.OK);
    }
}
















