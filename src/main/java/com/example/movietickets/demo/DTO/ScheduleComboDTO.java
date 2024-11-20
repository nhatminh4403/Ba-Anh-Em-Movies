package com.example.movietickets.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ScheduleComboDTO {
    private Long scheduleId;
    private String comboId;
    public ScheduleComboDTO(Long scheduleId, String comboId) {
        this.scheduleId = scheduleId;
        this.comboId = comboId;
    }

}
