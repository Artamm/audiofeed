package com.artamm.audiofeed;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Subscriber {
    @Id
    Long id;
    String email;

}
