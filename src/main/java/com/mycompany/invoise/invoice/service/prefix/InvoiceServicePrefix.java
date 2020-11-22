package com.mycompany.invoise.invoice.service.prefix;

import com.mycompany.invoise.core.entity.invoice.Invoice;


import com.mycompany.invoise.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//@Service
public class InvoiceServicePrefix implements InvoiceServiceInterface {
    @Value("${invoice.lastNumber}")
    private   long lasNumber = 112L;
    @Value("${invoice.prefix}")
    private String prefix;


    @Autowired
    private InvoiceRepositoryInterface invoiceRepository;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public long getLasNumber() {
        return lasNumber;
    }

    public void setLasNumber(long lasNumber) {
        this.lasNumber = lasNumber;
    }

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice create(Invoice invoice) {
        invoice.setNumber(String.valueOf(prefix+(++lasNumber)));
        invoiceRepository.save(invoice);
        return invoice;
    }

    @Override
    public Invoice getInvoiceById(String number) {
        return  invoiceRepository.findById(number).orElseThrow();
    }



}
