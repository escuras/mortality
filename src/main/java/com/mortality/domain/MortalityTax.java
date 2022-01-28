package com.mortality.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@JsonPropertyOrder({
        "País",
        "Taxa de mortalidade masculina",
        "Taxa de mortalidade feminina"

})
@Builder
public class MortalityTax {

    @JsonProperty("País")
    String country;

    @JsonProperty("Taxa de mortalidade feminina")
    String femaleTax;

    @JsonProperty("Taxa de mortalidade masculina")
    String maleTax;
}
