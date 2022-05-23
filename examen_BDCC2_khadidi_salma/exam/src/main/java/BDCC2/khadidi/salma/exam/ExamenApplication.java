package BDCC2.khadidi.salma.exam;

import BDCC2.khadidi.salma.exam.Entities.*;
import BDCC2.khadidi.salma.exam.Enums.InscriptionStatus;
import BDCC2.khadidi.salma.exam.Enums.participantGenre;
import BDCC2.khadidi.salma.exam.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamenApplication {


    public static void main(String[] args) {
        SpringApplication.run(ExamenApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ParticipantRepository participantRepository,
                                        SalleRepository salleRepository,
                                        SessionRepository sessionRepository,
                                        InscriptionRepository inscriptionRepository,
                                        ConférenceRepository conférenceRepository){
        return args -> {


            Stream.of("bouchra", "yahya").forEach(name -> {
                Speaker speaker=new Speaker();
                speaker.setNom(name);
                speaker.setEmail(name + "@gmail.com");
                speaker.setGenre(Math.random()>0.5? participantGenre.MASCULIN:participantGenre.FEMININ);
                speaker.setProfilPersonnel("speaker");
                participantRepository.save(speaker);
            });

            Stream.of("salle1", "salle2").forEach(name -> {
                Salle salle=new Salle();
                salle.setNom(name);
                salleRepository.save(salle);
            });

            salleRepository.findAll().forEach(acc->{
                for (int i = 0; i < 5; i++) {
                    Session session=new Session();
                    session.setId(UUID.randomUUID().toString());
                    session.setNom("session"+i);
                    sessionRepository.save(session);
                }
            });


            sessionRepository.findAll().forEach(session->{
                for (int i = 0; i < 5; i++) {
                    Inscription inscription= new Inscription();
                    inscription.setDate(new Date());
                    inscription.setPrix(Math.random()*1000);
                    inscription.setStatut(InscriptionStatus.EnCours);
                    inscriptionRepository.save(inscription);
                }

                for (int i = 0; i < 5; i++) {
                   Conférence conférence=new Conférence();
                   conférence.setId(UUID.randomUUID().toString());
                   conférence.setDate(new Date());
                   conférence.setHeureDébut(new Date());
                   conférence.setHeureFin(new Date());
                   conférence.setDescription("conference"+i);
                    conférenceRepository.save(conférence);
                }

                conférenceRepository.findAll().forEach(acc->{
                    for (int i = 0; i < 5; i++) {
                        Stream.of("mohammed", "yasmine").forEach(name -> {
                            Modérateur modérateur=new Modérateur();
                            modérateur.setNom(name);
                            modérateur.setEmail(name + "@gmail.com");
                            modérateur.setGenre(participantGenre.MASCULIN);
                            modérateur.setSpecialite("moderateur");
                            participantRepository.save(modérateur);
                        });
                    }
                });
            });


        };
    }


}
