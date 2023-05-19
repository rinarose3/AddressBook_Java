package git.rinarose3.abjava;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ablist/")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping
    public List<AddressBook> getPeople() {
        return addressBookService.getAllAddressBook();
    }

    @PostMapping
    public ResponseEntity<AddressBook> postPeople(@RequestBody AddressBook addressBook) {
        return ResponseEntity.ok(addressBookService.saveAddressBook(addressBook));
    }

    @PutMapping
    public ResponseEntity<AddressBook> putPeople(@RequestBody AddressBook addressBook) {
        try {
            return ResponseEntity.ok(addressBookService.updateAddressBook(addressBook));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletePeople(@RequestParam("id") Long id) {
        try {
            addressBookService.deleteAddressBookById(id);
            return ResponseEntity.ok("Удаление произведено успешно");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
