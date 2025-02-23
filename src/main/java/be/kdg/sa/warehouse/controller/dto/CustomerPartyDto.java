package be.kdg.sa.warehouse.controller.dto;

import be.kdg.sa.warehouse.domain.CustomerParty;
import java.util.UUID;

public record CustomerPartyDto(UUID id, String name, String address) {
    public CustomerPartyDto(CustomerParty customerParty) {
        this(
                customerParty.getId(),
                customerParty.getName(),
                customerParty.getAddress()
        );
    }
}