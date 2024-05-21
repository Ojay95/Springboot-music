package com.ojay.MusicApp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
public class MusicResource extends RepresentationModel<MusicResource> {
    private Music music;


}
