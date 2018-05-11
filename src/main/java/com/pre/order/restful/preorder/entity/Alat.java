package com.pre.order.restful.preorder.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author : Otorus
 * @since : 4/19/18
 */

@Entity
@Data
public class Alat {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    private Double harga;

    @Column(nullable = false, unique = true)
    private String nama;
}
