package BDCC2.khadidi.salma.exam.Service;

import BDCC2.khadidi.salma.exam.DTOS.*;
import BDCC2.khadidi.salma.exam.Entities.Invité;
import BDCC2.khadidi.salma.exam.Entities.Modérateur;
import BDCC2.khadidi.salma.exam.Entities.Speaker;

import java.util.List;

public interface ConferenceService {
    ConferenceDTO getConféranceDTO(String id);
    List<ConferenceDTO> listConférence();
    ConferenceDTO updateConférence(String id);
    ConferenceDTO deleteConférence(String id);

    List<ParticipantDTO> listParticipant();
    InvitéDTO saveInvité(Invité invité);
    ModérateurDTO saveModérateur(Modérateur modérateur);
    SpeakerDTO saveSpeaker(Speaker speaker);
    ParticipantDTO getParticipant(Long id);
    SpeakerDTO getSpeakerDTO();
    ModérateurDTO getModérateur();
    InvitéDTO getInvité();
    ParticipantDTO updateParticipant(Long id);
    ParticipantDTO deleteParticipant(Long id);
    List<CommentaireDTO> listCommentaires();

    List<SessionDTO> listSessions();
    SessionDTO getSession(String id);
}