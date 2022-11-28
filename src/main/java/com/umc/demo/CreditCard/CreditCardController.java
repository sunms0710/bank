package com.umc.demo.CreditCard;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
//@RestController
@Controller
@RequestMapping("/card")
public class CreditCardController {

    @Autowired
    CreditCardRepository creditCardRepository;

    //고객의 모든 카드 조회 (주민번호로) 폼(완료)
    @GetMapping("/userForm")
    public String allCardsForm(){
        return "card/userForm";
    }

    // 고객의 모든 카드 조회 (주민번호로) (완료)
    @PostMapping("/user")
    public String getAllCards(@RequestParam("socialNumber") String socialNumber, Model model) {
        model.addAttribute("cards",creditCardRepository.getOnesAllCards(socialNumber));
        return "card/user";
    }


    //카드 번호로 연결 계좌 잔고 조회 폼(완료)
    @GetMapping("/account_balanceForm")
    public String accountBalanceForm(){
        return "card/account_balanceForm";
    }

    //카드 번호로 연결 계좌 잔고 조회(완료)
    @PostMapping("/account_balance")
    public String getAccountBalance(@RequestParam("cardNumber") int cardNumber, Model model) {
        model.addAttribute("accountBalance", creditCardRepository.getAccountBalance(cardNumber));
        return "card/account_balance";
    }

    //카드 한도 조회 폼(완료)
    @GetMapping("/limitForm")
    public String limitForm(){
        return "card/limitForm";
    }

    //카드 한도 조회(완료)
    @PostMapping("/limit")
    public String getLimit(@RequestParam("cardNumber") int cardNumber, Model model) {
        model.addAttribute("cardlimit",creditCardRepository.getLimit(cardNumber));
        return "card/limit";
    }
}