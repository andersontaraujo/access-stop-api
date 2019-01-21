package com.accessstop.station;

import com.accessstop.common.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "stations")
@EntityListeners(AuditingEntityListener.class)
public class Station extends AuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "number", nullable = false)
    private Long number;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "address", nullable = false)
    private String address;

    @Builder
    public Station(Long number, String name, String address, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.number = number;
        this.name = name;
        this.address = address;
    }
}
