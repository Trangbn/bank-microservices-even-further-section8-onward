package com.review.cards.controller;

import com.review.cards.dto.CardsContactInfoDto;
import com.review.cards.dto.CardsDto;
import com.review.cards.dto.ResponseDto;
import com.review.cards.services.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CardsController {

    private final ICardsService cardsService;

    public CardsController(ICardsService cardsService) {
        this.cardsService = cardsService;
    }

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private CardsContactInfoDto cardsContactInfoDto;

    @PostMapping("/create")
    public boolean create(@RequestBody CardsDto card) {
        return cardsService.createCard(card);
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam("mobileNumber") String mobileNumber) {
        CardsDto foundCard = cardsService.findByMobileNumber(mobileNumber);
        if (foundCard == null) {
            throw new RuntimeException("Card not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(foundCard);
    }

    @DeleteMapping("/delete")
    public boolean deleteCards(@RequestParam("mobileNumber") String mobileNumber) {
        return cardsService.deleteCard(mobileNumber);
    }

    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/cards-info")
    public  ResponseEntity<CardsContactInfoDto> getCardsInfo(){
        return  ResponseEntity.status(HttpStatus.OK).body(cardsContactInfoDto);
    }
}
