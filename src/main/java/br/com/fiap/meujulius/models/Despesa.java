package br.com.fiap.meujulius.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.meujulius.controllers.ContaController;
import br.com.fiap.meujulius.controllers.DespesaController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Min(value = 0, message = "deve ser positivo") 
    @NotNull
    private BigDecimal valor;
    
    @NotNull
    private LocalDate data;
    
    @NotBlank @Size(min = 5, max = 255)
    private String descricao;

    @ManyToOne
    private Conta conta;

    public EntityModel<Despesa> toEntityModel(){
        return EntityModel.of(
            this, 
            linkTo(methodOn(DespesaController.class).show(id)).withSelfRel(),
            linkTo(methodOn(DespesaController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(DespesaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(ContaController.class).show(this.getConta().getId())).withRel("conta")
        );
    }

}
