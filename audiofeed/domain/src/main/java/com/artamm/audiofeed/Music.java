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
@Getter @Setter
public class Music extends MusicInfo {

//    @Id
//    Long id;
//    String author;
//    String title;
//    LocalDate added;

    byte[] musicfile;
    String filename;




    public Music(String author, String title, String filename) {
        this.author = author;
        this.title = title;
        this.filename = filename;
    }

    public Music(MusicGet musicGet){
        setAuthor(musicGet.getAuthor());
        setTitle(musicGet.getTitle());
    }
}
