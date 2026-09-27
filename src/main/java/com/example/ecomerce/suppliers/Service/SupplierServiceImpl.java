package com.example.ecomerce.suppliers.Service;


import com.example.ecomerce.suppliers.Repository.SupplierRepository;
import com.example.ecomerce.suppliers.dto.Request.SupplierRequest;
import com.example.ecomerce.suppliers.dto.Request.SupplierRequestUpdate;
import com.example.ecomerce.suppliers.dto.Response.SupplierResponse;
import com.example.ecomerce.suppliers.entity.Supplier;
import com.example.ecomerce.suppliers.exceptionSupplier.SupplierNotFoundException;
import com.example.ecomerce.suppliers.mapper.SupplierMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;


    @Override
    @Transactional
    public List<SupplierResponse> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(supplierMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public SupplierResponse getSupplierById(Long id) {
    Supplier supplier = supplierRepository.findById(id)
            .orElseThrow(() -> new SupplierNotFoundException(id));
     return supplierMapper.toResponse(supplier);
    }

    @Override
    @Transactional
    public SupplierResponse addSupplier(SupplierRequest request) {
        Supplier newSupplier = supplierMapper.toEntity(request);
        Supplier savedSupplier = supplierRepository.save(newSupplier);
        return supplierMapper.toResponse(savedSupplier);
    }

    @Override
    @Transactional
    public SupplierResponse deleteSupplier(Long id) {
        if(supplierRepository.existsById(id)){
            throw new SupplierNotFoundException(id);
        }
        supplierRepository.deleteById(id);

        return null;
    }

    @Override
    @Transactional
    public SupplierResponse updateSupplier(Long id, SupplierRequestUpdate requestUpdate) {
        Supplier oldData = supplierRepository.findById(id)
                .orElseThrow(()-> new SupplierNotFoundException(id));

        oldData.setName(requestUpdate.getName());
        oldData.setContact_person(requestUpdate.getContact_person());
        oldData.setEmail(requestUpdate.getEmail());
        oldData.setPhone(requestUpdate.getPhone());

        Supplier savedSupplier = supplierRepository.save(oldData);
        return supplierMapper.toResponse(savedSupplier);
    }




}
