package com.todoapp.app.io.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.id", nullable = false)
    private User user;

    @Column(nullable = false)
    @NotBlank
    @NotEmpty
    private String content;

    @Column(nullable = false)
    private Boolean completed = Boolean.FALSE;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public String getFormattedModifiedAt() {
        return this.modifiedAt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
    }
}