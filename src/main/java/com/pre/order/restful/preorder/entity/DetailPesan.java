package com.pre.order.restful.preorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author : Otorus
 * @since : 4/19/18
 */

@Entity
@Data
@Table(name = "detail_pesan")
public class DetailPesan {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_pesan", nullable = false)
    private Pesan pesan;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_alat", nullable = false)
    @JsonIgnore
    private Alat alat;

    @NotNull
    @Column(nullable = false)
    @Min(0)
    private int jumlah;

    //@NotNull
    //@Column(nullable = false)
    //private Double harga;

    @NotNull
    @Column(nullable = false)
    private Double diskon;

   // @NotNull
    //@Column(nullable = false)
    //private Double total;

}
