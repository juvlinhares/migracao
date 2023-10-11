package com.migracao.autbank.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.csv.CSVRecord;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RF_COND_RESGATE")
public class CondResgate {
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

	@Column(name = "CODIGO_ATIVO")
	private String codigoAtivo;

	@Column(name = "DATA_RESGATE")
	private Timestamp dataResgate;

	@Column(name = "PERCENTUAL_INDICE")
	private Double percentualIndice;

	@Column(name = "TAXA_JUROS")
	private Double taxaJuros;

	@Column(name = "TIPO_TAXA")
	private String tipoTaxa;

	@Column(name = "DP_TIPO_TAXA")
	private String dpTipoTaxa;

	public CondResgate(CSVRecord record) throws ParseException {
		this.codColigada = record.get(0);
		this.codAgencia = record.get(1);
		this.idAplicacao = record.get(2);
		this.codigoAtivo = record.get(3);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		this.dataResgate = new Timestamp(sdf.parse(record.get(4)).getTime());
		this.percentualIndice = Double.valueOf(record.get(5));
		this.taxaJuros = Double.valueOf(record.get(6));
		this.tipoTaxa = record.get(7);
	}
}
