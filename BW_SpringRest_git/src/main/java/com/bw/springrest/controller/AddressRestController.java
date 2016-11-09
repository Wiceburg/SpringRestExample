package com.bw.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bw.springrest.model.Address;
import com.bw.springrest.service.AddressService;
import com.fasterxml.jackson.annotation.JsonView;



@RestController
public class AddressRestController {
	
	@Autowired
	AddressService addressService;

	
	//-------------------Retrieve All Addresses--------------------------------------------------------	
	@JsonView(View.myFilter.class)
	@RequestMapping(value="/address", method=RequestMethod.GET)
	public ResponseEntity<List<Address>> listAllUsers() {
		List<Address> addresses = addressService.findAllAddresses();
		if(addresses.isEmpty()){
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
			//You may decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);
	}
	
	//-------------------Retrieve Single Address--------------------------------------------------------
	@RequestMapping(value="/address/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> getAddress(@PathVariable("id") long id){
		System.out.println("Fetch Address with id : " + id);
		Address address = addressService.findAddressById(id);
		if(address== null){
			System.out.println("Address with id " + id + " not found");
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
	
//	-------------------Create an Address--------------------------------------------------------
	@RequestMapping(value="/address/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createAddress(@RequestBody Address address, UriComponentsBuilder ucBuilder){
		System.out.println("Creating Address for " + address.getFirstName() + " " + address.getLastName());
		System.out.println("id is " + address.getId());
//		address is in transient status. So id is just 0, derived from the default long
		
		if(address.getId()==0){
			addressService.saveAddress(address);
		}else{
			addressService.mergeAddress(address);
		}
		
		
		System.out.println("id is " + address.getId());
//		address has been assigned an id and persisted. 
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);   
	}
	
//	------------------- Update an Address --------------------------------------------------------
    
    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
        System.out.println("Updating Address " + id);
         
        Address currentAddress = addressService.findAddressById(id);
         
        if (currentAddress==null) {
            System.out.println("Address with id " + id + " not found");
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
 
        currentAddress.setFirstName(address.getFirstName());
        currentAddress.setLastName(address.getLastName());
        currentAddress.setCity(address.getCity());
        currentAddress.setStreet(address.getStreet());
        currentAddress.setZip(address.getZip());
        currentAddress.setPhone(address.getPhone());
         
        addressService.updateAddress(currentAddress);
        return new ResponseEntity<Address>(currentAddress, HttpStatus.OK);
    }
    
//    ------------------- Delete an Address --------------------------------------------------------
    
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Address with id " + id);
 
        Address address = addressService.findAddressById(id);
        if (address == null) {
            System.out.println("Unable to delete. Address with id " + id + " not found");
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
 
        addressService.deleteAddressById(id);
        return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
    }
 
     
 
}
