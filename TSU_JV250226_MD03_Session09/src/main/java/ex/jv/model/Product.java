package ex.jv.model;

import com.mysql.cj.protocol.ColumnDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id", columnDefinition = "char(5)")
    private String productId;
    @Column(name = "product_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String productName;
    @Column(name = "product_price", columnDefinition = "float check(product_price>0)", nullable = false)
    private float price;
    @Column(name = "product_status", columnDefinition = "bit default(1)")
    private Boolean status;
    //khoa ngoai foreign key
    @ManyToOne
    @JoinColumn(name = "category_Id", referencedColumnName = "category_Id")
    private Category catalog;
}
