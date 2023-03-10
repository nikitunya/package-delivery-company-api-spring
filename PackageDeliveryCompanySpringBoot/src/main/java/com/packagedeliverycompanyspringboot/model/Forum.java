package com.packagedeliverycompanyspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Forum {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String forumTitle;
    private String forumDescription;

    @JsonIgnore
    @OneToMany (mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;


    public Forum(String forumTitle, String forumDescription) {
        this.forumTitle = forumTitle;
        this.forumDescription = forumDescription;
    }

    @Override
    public String toString() {
        return forumTitle +
                ", " + forumDescription;
    }
}
