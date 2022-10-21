package nl.multicode.elevenproof.generator;

import nl.multicode.elevenproof.model.ProofType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BurgerServiceNummerGeneratorTest {

    @Test
    void generate() {
        assertThat(new BurgerServiceNummerGenerator().generate(ProofType.BSN)).isNotEmpty();
    }

    @Test
    void generate_empty() {
        assertThat(new BurgerServiceNummerGenerator().generate(ProofType.BANK_ACCOUNT)).isEmpty();
    }
}