package in.bm.StudentManagementSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Phone {

@Column(name = "code",nullable = false)
    private String countryCode;
@Column(name = "number",nullable = false)
    private String number;

    public Phone(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }
}
