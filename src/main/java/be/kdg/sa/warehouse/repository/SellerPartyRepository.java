package be.kdg.sa.warehouse.repository;

import be.kdg.sa.warehouse.domain.SellerParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerPartyRepository extends JpaRepository<SellerParty, UUID> {

}
