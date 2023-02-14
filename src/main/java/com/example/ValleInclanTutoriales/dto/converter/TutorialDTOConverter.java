package com.example.ValleInclanTutoriales.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import com.example.ValleInclanTutoriales.dto.TutorialDTO;
import com.example.ValleInclanTutoriales.model.Tutorial;


@Component @RequiredArgsConstructor
public class TutorialDTOConverter {
    private final ModelMapper modelMapper;

    public TutorialDTO convertToDTO(Tutorial tutorial) {
        return modelMapper.map(tutorial, TutorialDTO.class);
    }
    
}
