package com.review.cards.mapper;

import com.review.cards.dto.CardsDto;
import com.review.cards.entity.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto (Cards cards, CardsDto cardsDto){
        cardsDto.setCardId(cards.getCardId());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards){
        cards.setCardId(cardsDto.getCardId());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setCardType(cardsDto.getCardType());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        return cards;
    }
}
