package org.example.apicollection.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecipitacaoDTO {
    private LocalDate data;
    private Double precipitacaoMm;
}