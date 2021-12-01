package com.sub_project.PhoneService.VO;

import com.sub_project.PhoneService.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Phone phone;
    private Manufacturer manufacturer;
}
