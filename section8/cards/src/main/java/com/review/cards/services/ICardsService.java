package com.review.cards.services;

import com.review.cards.dto.CardsDto;
import com.review.cards.dto.ResponseDto;

public interface ICardsService {
    CardsDto findByMobileNumber(String mobileNumber);
    boolean createCard(CardsDto cardDto);
    boolean deleteCard(String mobileNumber);
    ResponseDto updateCards(CardsDto cardDto);
}
