package BDCC2.khadidi.salma.exam.Mappers;

import BDCC2.khadidi.salma.exam.DTOS.*;
import BDCC2.khadidi.salma.exam.Entities.*;
import org.springframework.beans.BeanUtils;

public class ConferenceMapper {
    public InvitéDTO fromInvité(Invité invité){
        InvitéDTO invitéDTO = new InvitéDTO();
        BeanUtils.copyProperties(invité, invitéDTO);
        invitéDTO.setType(invité.getClass().getSimpleName());
        return invitéDTO;
    }

    public Invité fromInvitéDTO(InvitéDTO invitéDTO){
        Invité invité = new Invité();
        BeanUtils.copyProperties(invitéDTO, invité);
        return invité;
    }

    public ModérateurDTO fromModérateur(Modérateur modérateur){
        ModérateurDTO modérateurDTO = new ModérateurDTO();
        BeanUtils.copyProperties(modérateur, modérateurDTO);
        modérateurDTO.setType(modérateur.getClass().getSimpleName());
        return modérateurDTO;
    }

    public Modérateur fromModérateurDTO(ModérateurDTO modérateurDTO){
        Modérateur modérateur = new Modérateur();
        BeanUtils.copyProperties(modérateurDTO, modérateur);
        return modérateur;
    }

    public SpeakerDTO fromSpeaker(Speaker speaker){
        SpeakerDTO speakerDTO = new SpeakerDTO();
        BeanUtils.copyProperties(speaker, speakerDTO);
        speakerDTO.setType(speaker.getClass().getSimpleName());
        return speakerDTO;
    }

    public Speaker fromSpeakerDTO(SpeakerDTO speakerDTO){
        Speaker speaker= new Speaker();
        BeanUtils.copyProperties(speakerDTO, speaker);
        return speaker;
    }

    public SessionDTO fromSession(Session session){
        SessionDTO sessionDTO = new SessionDTO();
        BeanUtils.copyProperties(session, sessionDTO);
        return sessionDTO;
    }

    public Session fromSessionDTO(SessionDTO sessionDTO){
        Session session= new Session();
        BeanUtils.copyProperties(sessionDTO, session);
        return session;
    }

    public ConferenceDTO fromConférence(Conférence conférence){
        ConferenceDTO conférenceDTO = new ConferenceDTO();
        BeanUtils.copyProperties(conférence,conférenceDTO);
        conférenceDTO.setSpeaker(fromSpeaker(conférence.getSpeaker()));
        return conférenceDTO;
    }

    public Conférence fromConférenceDTO(ConferenceDTO conférenceDTO){
        Conférence conférence = new Conférence();
        BeanUtils.copyProperties(conférenceDTO, conférence);
        conférence.setSpeaker(fromSpeakerDTO(conférenceDTO.getSpeaker()));
        return conférence;
    }
}
