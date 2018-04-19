package com.pre.order.restful.preorder.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author : Otorus
 * @since : 4/19/18
 */
@Entity
@Data
public class Pesan {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @DateTimeFormat(pattern="dd-mm-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_pesan",nullable = false)
    private Date tglPesan;

    @Column(nullable = false)
    private String catatan;

    @NotNull
    @DateTimeFormat(pattern="dd-mm-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_datang", nullable = false)
    private Date tglDatang;

    @Column(nullable = false)
    private Double total;
}
