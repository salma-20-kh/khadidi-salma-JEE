package BDCC2.khadidi.salma.exam.DTOS;


import lombok.Data;

@Data
public class InvitéDTO extends ParticipantDTO {
    private Long id;
    private String nom;
    private String email;
    private String photo;
    private String affiliation;
}
