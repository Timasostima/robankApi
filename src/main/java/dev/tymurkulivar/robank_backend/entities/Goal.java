package dev.tymurkulivar.robank_backend.entities;

import dev.tymurkulivar.robank_backend.dto.GoalDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer index;
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private RobankUser user;

    public Goal(GoalDTO dto) {
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.index = dto.getIndex();
    }
}
