
package com.bw.springrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.springrest.model.Address;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Address findAddressById(long id) {
		System.out.println("daoImpl");
		Address address = (Address)getSession().get(Address.class, id);
		return address;
	}

	public void saveAddress(Address address) {
		getSession().save(address);
	}

	public void mergeAddress(Address address) {
		getSession().merge(address);
	}

	public void deleteAddressById(long id) {
		Object o = getSession().load(Address.class, id);
		getSession().delete(o);
	}

	public List<Address> findAllAddresses() {
		@SuppressWarnings("unchecked")
		List<Address> addressList = getSession().createCriteria(Address.class).list();
		return addressList;
	}

}

