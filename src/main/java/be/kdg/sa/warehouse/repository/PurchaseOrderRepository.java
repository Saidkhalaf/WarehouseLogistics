package be.kdg.sa.warehouse.repository;

import be.kdg.sa.warehouse.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, UUID> {
    PurchaseOrder findByReferenceUUID(UUID referenceUUID);
}
