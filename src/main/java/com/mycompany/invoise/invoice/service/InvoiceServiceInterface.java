package com.mycompany.invoise.invoice.service;
import com.mycompany.invoise.core.entity.invoice.Invoice;

import com.mycompany.invoise.invoice.repository.InvoiceRepositoryInterface;


public interface InvoiceServiceInterface {
    public Invoice create(Invoice invoice);
    public Invoice getInvoiceById(String number);
    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
    public Iterable<Invoice> getInvoiceList();
}
