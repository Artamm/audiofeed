package com.artamm.audiofeed;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter  @Setter
public class MusicGet extends MusicInfo {

    String musicfile;
    String filename;


}
