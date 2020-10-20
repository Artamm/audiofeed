package com.artamm.audiofeed;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@Getter @Setter
public class MusicInfo {
    @Id
    Long id;
    String author;
    String title;

    LocalDate added;


}
