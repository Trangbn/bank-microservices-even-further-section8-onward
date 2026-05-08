package com.review.cards.services.impl;

import com.review.cards.dto.CardsDto;
import com.review.cards.dto.ResponseDto;
import com.review.cards.entity.Cards;
import com.review.cards.mapper.CardsMapper;
import com.review.cards.repository.CardsRepository;
import com.review.cards.services.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardsService implements ICardsService {

    private CardsRepository cardsRepository;

    @Override
    public CardsDto findByMobileNumber(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new RuntimeException("Cannot find Cards by mobile number")
        );

        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }

    @Override
    public boolean createCard(CardsDto cardDto) {

        Cards cards = CardsMapper.mapToCards(cardDto, new Cards());
        try {
            cardsRepository.save(cards);
        } catch (Exception e) {
            throw new RuntimeException("cannot save cards");
        }

        return true;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        boolean isDeleted = false;
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new RuntimeException("Cannot find Cards by mobile number"));
        cardsRepository.delete(cards);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public ResponseDto updateCards(CardsDto cardDto) {
        return null;
    }
}
