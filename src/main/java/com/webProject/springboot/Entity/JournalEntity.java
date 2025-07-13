package com.webProject.springboot.Entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.Builder;

// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;
// import lombok.Value;

@Document
@Data

// @NoArgsConstructor
// @AllArgsConstructor
// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode
// @Value
// @Builder
public class JournalEntity {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;
}