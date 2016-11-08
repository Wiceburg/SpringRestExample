package com.bw.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bw.springrest.dao.AddressDao;
import com.bw.springrest.model.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao dao;

	public Address findAddressById(long id) {
		return dao.findAddressById(id);
	}

	public void saveAddress(Address address) {
		dao.saveAddress(address);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateAddress(Address address) {
		Address entity = dao.findAddressById(address.getId());
		if (entity != null) {
			entity.setFirstName(address.getFirstName());
			entity.setLastName(address.getLastName());
			entity.setCity(address.getCity());
			entity.setStreet(address.getStreet());
			entity.setZip(address.getZip());
			entity.setPhone(address.getPhone());
		}
	}

	public void deleteAddressById(long id) {
		dao.deleteAddressById(id);
	}

	public List<Address> findAllAddresses() {
		return dao.findAllAddresses();
	}

	public boolean isAddressExist(Address address) {
		return dao.findAddressById(address.getId()).equals(address);
	}

	public void mergeAddress(Address address) {
		dao.mergeAddress(address);

	}

}
