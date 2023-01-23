package models;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Milestone {
    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String references;
    private String description;
    @ToString.Exclude
    private boolean completed;

}
