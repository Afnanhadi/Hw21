package com.example.hw21.Controller;

import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    private ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("add address");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateAddress(@RequestBody @Valid AddressDTO addressDTO, @PathVariable Integer id){
        addressService.updateAddress(id,addressDTO);
        return ResponseEntity.status(200).body("Update address");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable  Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Delete address");
    }


}
