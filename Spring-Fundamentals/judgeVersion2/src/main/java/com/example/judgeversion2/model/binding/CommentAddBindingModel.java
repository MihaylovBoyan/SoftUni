package com.example.judgeversion2.model.binding;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentAddBindingModel {

    private Integer score;
    private String textContent;
    private Long homeworkId;

    @Min(value = 2, message = "score must be more than 2!")
    @Max(value = 6, message = "score must be less than 7!")
    public Integer getScore() {
        return score;
    }

    public CommentAddBindingModel setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Size(min = 3, message = "Text content length must be more than 3 chars")
    @NotBlank
    public String getTextContent() {
        return textContent;
    }

    public CommentAddBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public CommentAddBindingModel setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
        return this;
    }
}
