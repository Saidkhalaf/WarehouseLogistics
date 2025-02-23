package be.kdg.sa.warehouse.controller.mvc;

import be.kdg.sa.warehouse.domain.Material;
import be.kdg.sa.warehouse.service.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public String getWarehouses(Model model) {
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        return "warehouses";
    }

    /*@GetMapping("/{warehouseId}/materials")
    public String getMaterials(@PathVariable UUID warehouseId, Model model) {
        List<Material> materials = warehouseService.getMaterials(warehouseId);
        model.addAttribute("materials", materials);
        model.addAttribute("totalMaterials", materials.size());
        return "materials";
    }*/
}
