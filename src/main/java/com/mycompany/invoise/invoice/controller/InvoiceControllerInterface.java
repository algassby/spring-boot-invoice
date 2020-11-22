package com.mycompany.invoise.invoice.controller;

import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;

public interface InvoiceControllerInterface {
    public  String createInvoice(Invoice invoice);

    void setInvoiceService(InvoiceServiceInterface invoiceService);
}
