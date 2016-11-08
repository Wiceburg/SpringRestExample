package com.bw.springrest.service;

import java.util.List;

import com.bw.springrest.model.Address;

public interface AddressService {

	Address findAddressById(long id);

	void saveAddress(Address address);

	void mergeAddress(Address address);

	void updateAddress(Address address);

	void deleteAddressById(long id);

	List<Address> findAllAddresses();

	public boolean isAddressExist(Address address);

}
