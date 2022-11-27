package com.app.byeolbyeolsseudam.entity;

import com.app.byeolbyeolsseudam.type.CourseFinishedStatus;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_COURSE_FINISHED")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CourseFinished extends Period {
    @Id @GeneratedValue @NotNull
    private Long courseFinishedId;
    @NotNull
    private CourseFinishedStatus courseFinishedStatus;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @Builder
    public CourseFinished(CourseFinishedStatus courseFinishedStatus, Member member, Course course) {
        this.courseFinishedStatus = courseFinishedStatus;
        this.member = member;
        this.course = course;
    }

    public void update(CourseFinishedStatus courseFinishedStatus, Course course){
        this.courseFinishedStatus = courseFinishedStatus;
        this.course = course;
    }
}
