package com.ajulay.second.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "second")
@Data
@Accessors(chain = true)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private Date time;
}
