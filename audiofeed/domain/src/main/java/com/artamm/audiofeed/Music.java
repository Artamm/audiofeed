package com.artamm.audiofeed;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.File;
import java.util.Date;

@Data
@NoArgsConstructor

public class Music {

    @Id
    Long id;
    String author;
    String title;

    File musicfile;
    String filename;

    Date added;



}
