package be.kdg.sa.warehouse.controller.dto;

import be.kdg.sa.warehouse.domain.SellerParty;
import java.util.UUID;

public record SellerPartyDto(UUID id, String name, String address) {
    public SellerPartyDto(SellerParty sellerParty) {
        this(
                sellerParty.getId(),
                sellerParty.getName(),
                sellerParty.getAddress()
        );
    }
}