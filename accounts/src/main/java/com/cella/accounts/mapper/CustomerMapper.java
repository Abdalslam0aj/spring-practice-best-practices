package com.cella.accounts.mapper;

import org.modelmapper.ModelMapper;

import com.cella.accounts.dto.AccountsDto;
import com.cella.accounts.dto.CustomerDto;
import com.cella.accounts.entity.Accounts;
import com.cella.accounts.entity.Customer;

/**
 * CustomerMapper
 */
public class CustomerMapper {

    public static CustomerDto toCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer toCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}