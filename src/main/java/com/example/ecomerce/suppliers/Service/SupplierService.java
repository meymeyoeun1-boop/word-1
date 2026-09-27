package com.example.ecomerce.suppliers.Service;

import com.example.ecomerce.suppliers.dto.Request.SupplierRequest;
import com.example.ecomerce.suppliers.dto.Request.SupplierRequestUpdate;
import com.example.ecomerce.suppliers.dto.Response.SupplierResponse;
import java.util.List;

public interface SupplierService {

    List<SupplierResponse> getAllSuppliers();

    SupplierResponse getSupplierById(Long id);

    SupplierResponse addSupplier(SupplierRequest request);

    SupplierResponse deleteSupplier(Long id);

    SupplierResponse updateSupplier(Long id, SupplierRequestUpdate requestUpdate);

}
