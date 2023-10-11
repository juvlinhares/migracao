package com.migracao.autbank.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.csv.CSVRecord;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RF_SALDOS")
public class Saldo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NROREGISTRO")
    private Integer nroregistro;

    @Column(name = "CODCOLIGADA")
    private String codColigada;
    @Column(name = "CODAGENCIA")
    private String codAgencia;
    @Column(name = "ID_APLICACAO")
    private String idAplicacao;
    @Column(name = "DATAPOSICAO")
    private Timestamp dataPosicao;
    @Column(name = "POSICAO")
    private String posicao;
    @Column(name = "QUANTIDADE")
    private Double quantidade;
    @Column(name = "VLRAPLICADO")
    private Double vlrAplicado;
    @Column(name = "VLRCURVA_CORRIDOS")
    private Double vlrcurvaCorridos;
    @Column(name = "VLRCURVA_UTEIS")
    private Double vlrcurvaUteis;
    @Column(name = "VLRVENCIMENTO")
    private Double vlrvencimento;
    @Column(name = "VLRIOF_CORRIDOS")
    private Double vlriofCorridos;
    @Column(name = "VLRIOF_UTEIS")
    private Double vlriofUteis;
    @Column(name = "VLRIRF_CORRIDOS")
    private Double vlrirfCorridos;
    @Column(name = "VLRIRF_UTEIS")
    private Double vlrirfUteis;
    @Column(name = "VLRAPROPRIACAO_CORRIDOS")
    private Double vlrapropriacaoCorridos;
    @Column(name = "VLRAPROPRIACAO_UTEIS")
    private Double vlrapropriacaoUteis;
    @Column(name = "VLRIDA_NEG")
    private Double vlrIdaNeg;

    public Saldo(CSVRecord record) throws ParseException {
        this.codColigada = record.get(0);
        this.codAgencia = record.get(1);
        this.idAplicacao = record.get(2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        this.dataPosicao = new Timestamp(sdf.parse(record.get(3)).getTime());
        this.posicao = record.get(4);
        this.quantidade = Double.valueOf(record.get(5));
        this.vlrAplicado = Double.valueOf(record.get(6));
        this.vlrcurvaCorridos = Double.valueOf(record.get(7));
        this.vlrcurvaUteis = Double.valueOf(record.get(8));
        this.vlrvencimento = Double.valueOf(record.get(9));
        this.vlriofCorridos = Double.valueOf(record.get(10));
        this.vlriofUteis = Double.valueOf(record.get(11));
        this.vlrirfCorridos = Double.valueOf(record.get(12));
        this.vlrirfUteis = Double.valueOf(record.get(13));
        this.vlrapropriacaoCorridos = Double.valueOf(record.get(14));
        this.vlrapropriacaoUteis = Double.valueOf(record.get(15));
        this.vlrIdaNeg = Double.valueOf(record.get(16));
    }
}
