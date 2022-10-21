package nl.multicode.elevenproof.controller;

import lombok.RequiredArgsConstructor;
import nl.multicode.elevenproof.model.Command;
import nl.multicode.elevenproof.model.ProofType;
import nl.multicode.elevenproof.service.ElevenProofService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@RequiredArgsConstructor
public class ElevenProofController implements ProofController {

    private static final Logger logger = LogManager.getLogger(ElevenProofController.class);
    private final Map<ProofType, ElevenProofService> elevenProofServices;

    @Override
    public void handleRequest(ProofType proofType, Command command, String number) {
        final var service = elevenProofServices.get(proofType);

        switch (command) {
            case VALIDATE ->
                    logger.info("{} is {} {}", number, service.isValid(number) ? "valid" : "invalid", proofType.getValue());
            case GENERATE -> logger.info("Generated: {}", service.generate().orElse(null));
            case UNKNOWN ->
                    logger.error("Cannot handle request: {}, {}, {}", proofType.getValue(), command.getValue(), number);
        }
    }
}