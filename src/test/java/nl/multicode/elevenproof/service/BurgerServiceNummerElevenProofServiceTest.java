package nl.multicode.elevenproof.service;

import static org.mockito.Mockito.verify;

import nl.multicode.elevenproof.generator.Generator;
import nl.multicode.elevenproof.model.ProofType;
import nl.multicode.elevenproof.validation.ElevenProof;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BurgerServiceNummerElevenProofServiceTest {

    @Mock
    private Generator elevenproofGenerator;
    @Mock
    private ElevenProof elevenProof;
    @InjectMocks
    private BurgerServiceNummerElevenProofService service;

    @Test
    @DisplayName("Given the Service is configured correctly"
        + "When the generate() method is called"
        + "Then the BangAccountGenerator member is called with the correct elevenProofType")
    void generate() {

        service.generate();
        verify(elevenproofGenerator).generate(ProofType.BSN);
    }

    @Test
    @DisplayName("Given the Service is configured correctly"
        + "When the isValid() method is called"
        + "Then the elevenProof is called with the number")
    void isValid() {

        final var bsn = "bsn";
        service.isValid(bsn);
        verify(elevenProof).isElevenProof(bsn);
    }
}