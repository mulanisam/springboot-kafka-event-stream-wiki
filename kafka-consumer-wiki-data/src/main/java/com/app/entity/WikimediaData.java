package com.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "wiki_recentChanges")
@Data
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikiEventData;
}
