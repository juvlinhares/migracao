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
@Table(name = "RF_MOVIMENTACOES")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NROREGISTRO")
    private Integer nroregistro;
    @Column(name = "CODCOLIGADA")
    private String codColigada;

    @Column(name = "CODAGENCIA")
    private String codAgencia;

    @Column(name = "NUMERO_NOTA")
    private Integer numeroNota;

    @Column(name = "TIPO_OPERACAO")
    private String tipoOperacao;

    @Column(name = "ID_APLICACAO")
    private String idAplicacao;

    @Column(name = "CODIGO_CLIENTE")
    private String codigoCliente;

    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;

    @Column(name = "PAPEL")
    private String papel;

    @Column(name = "TIPO_EMISSOR")
    private String tipoEmissor;

    @Column(name = "CPF_CNPJ_EMISSOR")
    private String cpfCnpjEmissor;

    @Column(name = "TIPORENDIMENTO")
    private String tipoRendimento;

    @Column(name = "DATA_OPERACAO")
    private Timestamp dataOperacao;

    @Column(name = "DATA_VENC_OPERACAO")
    private Timestamp dtVencOperacao;

    @Column(name = "DATA_EMISSAO")
    private Timestamp dataEmissao;

    @Column(name = "DATA_VENCIMENTO")
    private Timestamp dataVencimento;

    @Column(name = "TAXA_OPERACAO")
    private Double taxaOperacao;

    @Column(name = "TIPO_TAXA")
    private String tipoTaxa;

    @Column(name = "INDEXADOR")
    private String indexador;

    @Column(name = "PERCENTUAL_INDICE")
    private Double percentualIndice;

    @Column(name = "CUSTODIA")
    private String custodia;

    @Column(name = "CODIGO_ATIVO")
    private String codigoAtivo;

    @Column(name = "LIQ_FINANCEIRA")
    private String liqFinanceira;

    @Column(name = "CODAGENCIALIQ")
    private String codAgenciaLiq;

    @Column(name = "NUMCONTALIQ")
    private String numContaLiq;

    @Column(name = "CODGERENTE")
    private String codGerente;

    @Column(name = "NUMCOMANDO")
    private String numComando;

    @Column(name = "DATA_LIQUIDEZ")
    private Timestamp dataLiquidez;

    @Column(name = "VLRIDA")
    private Double vlrida;

    @Column(name = "VLRVOLTA")
    private Double vlrvolta;

    @Column(name = "VLRIRF")
    private Double vlrirf;

    @Column(name = "VLRIOF")
    private Double vlriof;

    @Column(name = "PU_OPERACAO")
    private Double puOperacao;

    @Column(name = "QTD_OPERACAO")
    private Double qtdOperacao;

    @Column(name = "VLRIDA_NEG")
    private Double vlridaNeg;

    @Column(name = "TAXAOPERACAO_NEG")
    private Double taxaOperacaoNeg;

    @Column(name = "PERCENTUAL_INDICE_NEG")
    private Double percentualIndiceNeg;

    @Column(name = "PUAPLICACAO_NEG")
    private Double puAplicacaoNeg;

    @Column(name = "STATUS_PROCESSADO")
    private String statusProcessado;

    @Column(name = "NUMESTOQUE")
    private Double numEstoque;

    @Column(name = "TIPO_CONDICAO_RESG")
    private String tipoCondicaoResg;

    @Column(name = "BLOQUEIO_GARANTIA")
    private String bloqueioGarantia;

    @Column(name = "DP_TIPO_OPERACAO")
    private String dpTipoOperacao;

    @Column(name = "DP_PAPEL")
    private String dpPapel;
    @Column(name = "DP_TIPO_TAXA")
    private String dpTipoTaxa;
    @Column(name = "DP_INDEXADOR")
    private String dpIndexador;
    @Column(name = "DP_CUSTODIA")
    private String dpCustodia;
    @Column(name = "DP_LIQ_FINANCEIRA")
    private String dpLiqFincanceira;
    @Column(name = "DP_CODGERENTE")
    private String dpCodGerente;

    public Movimentacao(CSVRecord record) throws ParseException {

        this.codColigada = record.get(0);
        this.codAgencia = record.get(1);
        this.numeroNota = Integer.valueOf(record.get(2));
        this.tipoOperacao = record.get(3);
        this.idAplicacao = record.get(4);
        this.codigoCliente = record.get(5);
        this.cpfCnpj = record.get(6).replaceAll("[^0-9]", "");
        this.papel = record.get(7);
        this.tipoEmissor = record.get(8);
        this.cpfCnpjEmissor = record.get(9).replaceAll("[^0-9]", "");
        this.tipoRendimento = record.get(10);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        this.dataOperacao = new Timestamp(sdf.parse(record.get(11)).getTime());
        this.dtVencOperacao = new Timestamp(sdf.parse(record.get(12)).getTime());
        this.dataEmissao = new Timestamp(sdf.parse(record.get(13)).getTime());
        this.dataVencimento = new Timestamp(sdf.parse(record.get(14)).getTime());
        this.taxaOperacao = Double.valueOf(record.get(15));
        this.tipoTaxa = record.get(16);
        this.indexador = record.get(17);
        this.percentualIndice = Double.valueOf(record.get(18));
        this.custodia = record.get(19);
        this.codigoAtivo = record.get(20);
        this.liqFinanceira = record.get(21);
        this.codAgenciaLiq = record.get(22);
        this.numContaLiq = record.get(23);
        this.codGerente = record.get(24);
        this.numComando = record.get(25);
        this.dataLiquidez = new Timestamp(sdf.parse(record.get(26)).getTime());
        this.vlrida = Double.valueOf(record.get(27));
        this.vlrvolta = Double.valueOf(record.get(28));
        this.vlrirf = Double.valueOf(record.get(29));
        this.vlriof = Double.valueOf(record.get(30));
        this.puOperacao = Double.valueOf(record.get(31));
        this.qtdOperacao = Double.valueOf(record.get(32));
        this.vlridaNeg = Double.valueOf(record.get(33));
        this.taxaOperacaoNeg = Double.valueOf(record.get(34));
        this.percentualIndiceNeg = Double.valueOf(record.get(35));
        this.puAplicacaoNeg = Double.valueOf(record.get(36));
        this.statusProcessado = record.get(37);
        this.numEstoque = Double.valueOf(record.get(38));
        this.tipoCondicaoResg = record.get(39);
        this.bloqueioGarantia = record.get(40);

    }
}
