package com.mycompany.invoise.invoice.repository;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {


}
