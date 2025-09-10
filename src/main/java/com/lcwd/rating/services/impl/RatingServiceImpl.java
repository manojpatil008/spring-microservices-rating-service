package com.lcwd.rating.services.impl;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.exceptions.ResourceNotFoundException;
import com.lcwd.rating.payload.RatingDto;
import com.lcwd.rating.repositories.RatingRepository;
import com.lcwd.rating.services.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating = modelMapper.map(ratingDto,Rating.class);
        Rating rating1 = ratingRepository.save(rating);
        return modelMapper.map(rating1,RatingDto.class);
    }

    @Override
    public List<RatingDto> getAllRatings() {
        List<Rating> ratingList = ratingRepository.findAll();
        return ratingList.stream().map(rating -> modelMapper.map(rating,RatingDto.class)).collect(Collectors.toList());
    }

    @Override
    public RatingDto getRatingById(String ratingId) {
        Rating rating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating with given Id not found" + ratingId));
        return modelMapper.map(rating,RatingDto.class);
    }

    @Override
    public List<RatingDto> getAllRatingsByUserId(String userId) {
        List<Rating> ratingList = ratingRepository.findByUserId(userId);
        return ratingList.stream().map(rating -> modelMapper.map(rating,RatingDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> getAllRatingsByHotelId(String hotelId) {
        List<Rating> ratingList = ratingRepository.findByHotelId(hotelId);
        return ratingList.stream().map(rating -> modelMapper.map(rating,RatingDto.class)).collect(Collectors.toList());
    }
}
