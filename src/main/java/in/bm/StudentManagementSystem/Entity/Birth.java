package in.bm.StudentManagementSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Birth {

@Column(name="Birth",nullable = false)
    private LocalDate birthdate;



    public Birth(LocalDate birthDate)
    {

      this.birthdate=birthDate;


    }




}
