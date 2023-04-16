package nl.multicode.elevenproof.controller;

import lombok.RequiredArgsConstructor;
import nl.multicode.elevenproof.openapi.model.BurgerServiceNumber;
import nl.multicode.elevenproof.service.BurgerServiceNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/bsn")
@RestController
@RequiredArgsConstructor
public class BurgerServiceNumberController implements ElevenproofController<ResponseEntity<BurgerServiceNumber>> {

  private final BurgerServiceNumberService service;

  @GetMapping("/generate")
  public ResponseEntity<BurgerServiceNumber> generate() {

    return ResponseEntity.ok(BurgerServiceNumber.builder()
        .number(service.generate().number())
        .build());
  }

  @GetMapping("/validate/{number}")
  public ResponseEntity<BurgerServiceNumber> validate(@PathVariable String number) {

    return ResponseEntity.ok(BurgerServiceNumber.builder()
        .number(number)
        .isElevenproof(service.isValid(number))
        .build());
  }
}
