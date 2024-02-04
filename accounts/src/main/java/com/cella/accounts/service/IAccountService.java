package com.cella_store_api.accounts.service;

import com.cella_store_api.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     * 
     * @param customerDto 
     */
    void createAccount(CustomerDto customerDto);

    /**
     * 
     * @param mobileNumber
     * @return CustomerDto based on mobileNumber
     */
    CustomerDto fetchCustomer(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return boolean indecating if the account created or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     * 
     * @param mobileNumber
     * @return boolean if the account is deleted
     */
    boolean deleteAccount(String mobileNumber);

}
