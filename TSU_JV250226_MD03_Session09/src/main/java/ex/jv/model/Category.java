package ex.jv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String categoryName;
    @Column(name = "category_ds", columnDefinition = "text")
    private String description;
    @Column(name = "category_status")
    private Boolean status;
}
