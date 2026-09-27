package com.example.ecomerce.suppliers.controller;


import com.example.ecomerce.product.common.BaseRestController;
import com.example.ecomerce.product.common.HttpBodyResponse;
import com.example.ecomerce.suppliers.Service.SupplierService;
import com.example.ecomerce.suppliers.dto.Request.SupplierRequest;
import com.example.ecomerce.suppliers.dto.Request.SupplierRequestUpdate;
import com.example.ecomerce.suppliers.dto.Response.SupplierResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SuppliersController  extends BaseRestController {
    private final SupplierService supplierService;

    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/list")
    public List<SupplierResponse> getAllSupplier() {
        return supplierService.getAllSuppliers();
    }
    @GetMapping("/{id}")
    public SupplierResponse getSupplierById(@PathVariable Long id )
    {return supplierService.getSupplierById(id);}

    @PostMapping("/create")
    public SupplierResponse addSupplier(@RequestBody SupplierRequest request) {
        return supplierService.addSupplier(request);
    }

    @DeleteMapping("/{id}")
    public SupplierResponse deleteSupplier(@PathVariable Long id){
        return supplierService.deleteSupplier(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpBodyResponse<SupplierResponse>> updateSupplier(
            @PathVariable Long id,
            @Valid @RequestBody SupplierRequestUpdate requestUpdate){
        SupplierResponse updateSupplier = supplierService.updateSupplier(id, requestUpdate);
        return responseSucceed(updateSupplier);
    }


}



