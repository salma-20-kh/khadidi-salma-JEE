package BDCC2.khadidi.salma.exam.DTOS;

import lombok.Data;

import java.util.Date;

@Data
public class CommentaireDTO {
    private Long id;
    private Date date;
    private String contenu;
    private int nombreLikes;
}
