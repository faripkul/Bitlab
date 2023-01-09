package spring.hibernate.task.task;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.List;

@Entity
@Table (name = "t_applicationsss")
@Getter
@Setter
public class BitlabApplications {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "commentary",columnDefinition = "TEXT")
    private String commentary;

    @Column(name = "phone")
    private String phone;

    @Column(name = "handled")
    private boolean handled;

    @ManyToOne
    private BitlabCourses courses;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<BitlabOperators> operators;

}
