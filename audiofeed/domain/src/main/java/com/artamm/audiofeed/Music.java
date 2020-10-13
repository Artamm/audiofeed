package com.artamm.audiofeed;

import io.r2dbc.spi.Blob;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.io.File;
import java.lang.annotation.Documented;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Music {

    @Id
    Long id;
    String author;
    String title;



    byte[] musicfile;
    String filename;


    LocalDate added;



}
