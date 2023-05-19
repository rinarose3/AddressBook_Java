package git.rinarose3.abjava;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Entity
@Table(name = "addressbook")

public class AddressBook{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String fam;
    private String tel;
    private String mail;
    private String note;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getFam() {
        return fam;
    }
    public String getTel() {
        return tel;
    }
    public String getMail() {
        return mail;
    }
    public String getNote() {
        return note;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setFam(String fam) {
        this.fam = fam;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public List<HashMap<String,String>> getFieldNames() {
        List<HashMap<String, String>> fieldNames = new ArrayList<>();

        HashMap<String, String> itemName = new HashMap<>() {{
            put("field", "name");
            put("label", "Имя");
            put("value", getName());
        }};
        fieldNames.add(itemName);

        HashMap<String, String> itemFam = new HashMap<>() {{
            put("field", "fam");
            put("label", "Фамилия");
            put("value", getFam());
        }};
        fieldNames.add(itemFam);

        HashMap<String, String> itemTel = new HashMap<>() {{
            put("field", "tel");
            put("label", "Телефон");
            put("value", getTel());
        }};
        fieldNames.add(itemTel);

        HashMap<String, String> itemMail = new HashMap<>() {{
            put("field", "mail");
            put("label", "mail");
            put("value", getMail());
        }};
        fieldNames.add(itemMail);

        HashMap<String, String> itemNote = new HashMap<>() {{
            put("field", "note");
            put("label", "Заметки");
            put("value", getNote());
        }};
        fieldNames.add(itemNote);

        return fieldNames;
    }

    public void setData(AddressBook addressBook) {
        this.name = addressBook.getName();
        this.fam = addressBook.getFam();
        this.tel = addressBook.getTel();
        this.mail = addressBook.getMail();
        this.note = addressBook.getNote();
    }
}
