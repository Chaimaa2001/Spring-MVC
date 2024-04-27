package com.emsi.patientsmvc20;

import com.emsi.patientsmvc20.entities.Patient;
import com.emsi.patientsmvc20.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvc20Application {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvc20Application.class, args);
    }

   // @Bean
        CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"CHAIMAA",new Date(),false,170)
            );
            patientRepository.save(
                    new Patient(null,"AHMED",new Date(),true,180)
            );

            patientRepository.save(
                    new Patient(null,"SALAH",new Date(),false,180)
            );
            patientRepository.save(
                    new Patient(null,"SARA",new Date(),true,500)
            );

            patientRepository.findAll().forEach(p-> System.out.println(p.getName()));
        };
        }

}
