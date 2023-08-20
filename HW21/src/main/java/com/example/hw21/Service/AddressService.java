package com.example.hw21.Service;

import com.example.hw21.Api.ApiException;
import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repostory.AddressRepository;
import com.example.hw21.Repostory.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher= teacherRepository.findTeacherById(addressDTO.getTeacher_Id());
        Address address=new Address(null,addressDTO.getArea(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }
    public void updateAddress(Integer Id,AddressDTO addressDTO){
        Address address=addressRepository.getReferenceById(Id);

        if (address==null){
            throw  new ApiException("not found Id");
        }
        address.setArea(addressDTO.getArea());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer Id){
        Address address=addressRepository.getReferenceById(Id);
        Teacher teacher=teacherRepository.findTeacherById(Id);

        if (address==null){
            throw  new ApiException("not found Id");
        }
        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }
}
