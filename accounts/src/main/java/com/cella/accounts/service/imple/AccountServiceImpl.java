package com.cella.accounts.service.imple;

import java.time.LocalDateTime;
import java.util.Random;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.stereotype.Service;

import com.cella.accounts.constants.AccountsConstants;
import com.cella.accounts.dto.AccountsDto;
import com.cella.accounts.dto.CustomerDto;
import com.cella.accounts.entity.Accounts;
import com.cella.accounts.entity.Customer;
import com.cella.accounts.exceptions.CustomerAlreadyExistsException;
import com.cella.accounts.exceptions.ResourceNotFoundException;
import com.cella.accounts.mapper.AccountsMapper;
import com.cella.accounts.mapper.CustomerMapper;
import com.cella.accounts.repository.AccountsRepository;
import com.cella.accounts.repository.CustomerRepository;
import com.cella.accounts.service.IAccountService;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = new Customer();
        CustomerMapper.toCustomer(customerDto, customer);
        var customerExists = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (!customerExists.isPresent()) {
            Customer savedCustomer = customerRepository.save(customer);
            accountsRepository.save(createNewAccount(savedCustomer));

        } else {
            throw new CustomerAlreadyExistsException(
                    "Customer already exists" + customerExists.get().getMobileNumber());
        }

    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

    @Override
    public CustomerDto fetchCustomer(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "CustomerId",
                        customer.getCustomerId().toString()));
        CustomerDto customerDto = new CustomerDto();
        CustomerMapper.toCustomerDto(customer, customerDto);
        customerDto.setAccountsDto(AccountsMapper.toAccountsDto(account, new AccountsDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountDto = customerDto.getAccountsDto();
        if (accountDto != null) {
            Accounts accounts = accountsRepository.findById(accountDto.getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "AccountNumber",
                            accountDto.getAccountNumber().toString()));
            AccountsMapper.toAccounts(accountDto, accounts);

            accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();

            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerId", customerId.toString()));

            CustomerMapper.toCustomer(customerDto, customer);
            customer.setCustomerId(customerId);
            customerRepository.save(customer);

            isUpdated = true;

        }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());

        return true;

    }

}
