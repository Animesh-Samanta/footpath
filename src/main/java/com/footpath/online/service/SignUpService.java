package com.footpath.online.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footpath.online.model.Address;
import com.footpath.online.model.Customer;
import com.footpath.online.entity.CustomerEntity;
import com.footpath.online.dao.CustomerDao;
import com.footpath.online.entity.AddressEntity;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SignUpService {

	@Autowired
	private CustomerDao customerDao;
	public boolean insertNewUser(Customer customerModel) {
		CustomerEntity customerEntity =customerDao.findByEmail(customerModel.getEmail());
		if(customerEntity==null) {
		customerEntity = new CustomerEntity();
        customerEntity.setName(customerModel.getName());
        customerEntity.setEmail(customerModel.getEmail());
        customerEntity.setPassword(customerModel.getPassword());

        // Convert addresses
        List<Address> addressModels = customerModel.getAddresses();
        List<AddressEntity> addressEntities = new ArrayList<>();
        if (addressModels != null) {
            for (Address addressModel : addressModels) {
                AddressEntity addressEntity = new AddressEntity();
                addressEntity.setCity(addressModel.getCity());
                addressEntity.setPin(addressModel.getPin());
                addressEntity.setFullAddress(addressModel.getFullAddress());
                addressEntity.setCustomer(customerEntity); // Set the relationship
                addressEntities.add(addressEntity);
            }
        }
        customerEntity.setAddresses(addressEntities);
        customerDao.save(customerEntity);

		return true;
		}
		return false;
	}
	
	
	
	
	
}
