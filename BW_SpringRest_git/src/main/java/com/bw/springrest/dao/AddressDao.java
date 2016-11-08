package com.bw.springrest.dao;

import java.util.List;

import com.bw.springrest.model.Address;

public interface AddressDao {

	void saveAddress(Address address);

	void mergeAddress(Address address);

	Address findAddressById(long id);

	void deleteAddressById(long id);

	List<Address> findAllAddresses();

}
