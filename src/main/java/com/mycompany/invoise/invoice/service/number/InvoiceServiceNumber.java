package com.mycompany.invoise.invoice.service.number;


import com.mycompany.invoise.core.entity.invoice.Invoice;

import com.mycompany.invoise.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    //@Value("124")
    //private   long lasNumber = 124L;
    @Autowired
    private InvoiceRepositoryInterface invoiceRepository;
   // @Autowired
    //private CustomerRepositoryInterface customerRepositoryInterface;


    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    @Override
    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
      // Iterable<Invoice> invoices =  invoiceRepository.findAll();
       //ceci permet d'iniatiliser le client de chaque facture
      // invoices.forEach(invoice -> invoice.getCustomer().getName());
       return invoiceRepository.findAll();
    }
    @Override
    //@Transactional
    public Invoice create(Invoice invoice) {
      //customerRepositoryInterface.save(invoice.getCustomer());
        return   invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(String number) {
        return  invoiceRepository.findById(number).orElseThrow();
    }


}
