package org.example.apicollection.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Precipitacao {
    private LocalDate data;
    private Double precipitacaoMm;
}