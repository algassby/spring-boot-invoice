package com.mycompany.invoise.invoice.repository.database;
/*import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static org.springframework.jdbc.core.JdbcTemplate.*;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Invoice create(Invoice invoice) {
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connection->{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO INVOICE(CUSTOMER_NAME, ORDER_NUMBER) VALUES (?,?) ", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, invoice.getCustomerName());
            ps.setString(2,invoice.getOrderNumber());
            return ps;
        },kh);
        invoice.setNumber(kh.getKey().toString());
        return  invoice;
    }
*/
/*
    @Override
    public List<Invoice> list() {
        /*Invoice invoice1 = new Invoice();
        invoice1.setCustomerName("EDF");
        invoice1.setNumber("NUM_1");

        Invoice invoice2 = new Invoice();
        invoice2.setNumber("NUM_2");
        invoice2.setCustomerName("La poste");
         */
/*
        return jdbcTemplate.query("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE", (rs, rowNum)->new Invoice(
                String.valueOf(rs.getLong("INVOICE_NUMBER")), rs.getString("CUSTOMER_NAME")));
    }

    @Override
    public Invoice getById(String number) {
        return jdbcTemplate.queryForObject("SELECT INVOICE_NUMBER, CUSTOMER_NAME, ORDER_NUMBER FROM INVOICE WHERE INVOICE_NUMBER=?", new Object[]{number}, (rs, rowNum)->new Invoice(
                String.valueOf(rs.getLong("INVOICE_NUMBER")), rs.getString("CUSTOMER_NAME"), rs.getString("ORDER_NUMBER")));
    }

    public static void main(String [] args){
        InvoiceRepositoryDatabase invoiceRepositoryDatabase = new InvoiceRepositoryDatabase();

        System.out.println(invoiceRepositoryDatabase.list().toString());
    }
}
*/