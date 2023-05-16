package git.rinarose3.abjava;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ablist/")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping
    public List<AddressBook> getPeople() {

        return addressBookRepository.findAll();
    }

    @PostMapping
    public AddressBook postPeople(@RequestBody AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    @PutMapping
    public ResponseEntity<AddressBook> putPeople(@RequestBody AddressBook addressBook) {
        Optional<AddressBook> addressBookOptional = addressBookRepository.findById(addressBook.getId());
        if (addressBookOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        AddressBook existingAddressBook = addressBookOptional.get();
        existingAddressBook.setName(addressBook.getName());
        existingAddressBook.setFam(addressBook.getFam());
        existingAddressBook.setMail(addressBook.getMail());
        existingAddressBook.setTel(addressBook.getTel());
        existingAddressBook.setNote(addressBook.getNote());

        AddressBook updatedAddressBook = addressBookRepository.save(existingAddressBook);

        return ResponseEntity.ok(updatedAddressBook);

    }

}
