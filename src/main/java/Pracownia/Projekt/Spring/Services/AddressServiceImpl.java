//package Pracownia.Projekt.Spring.Services;
//
//import Pracownia.Projekt.Spring.Entities.*;
//import Pracownia.Projekt.Spring.Repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AddressServiceImpl implements AddressService{
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    @Override
//    public Iterable<Address> listAllAddresses() {
//        return addressRepository.findAll();
//    }
//
//    @Override
//    public Iterable<Address> listAllForeignAddresses() {
//        return addressRepository.findByCountryNot("Polska");
//    }
//
//    @Override
//    public Address saveAddress(Address address) {
//        return addressRepository.save(address);
//    }
//
//    @Override
//    public boolean checkIfExist(Integer address_id) {
//        if (addressRepository.checkIfExist(address_id) > 0)
//            return true;
//        else
//            return false;
//    }
//
//    @Override
//    public void deleteByAddressId(int id)
//    {
//        Integer personId = addressRepository.FindPerson(id);
//        if(personId != null) {
//            addressRepository.ChangeBookId(personId);
//        }
//        addressRepository.deleteById(id);
//    }
//}
