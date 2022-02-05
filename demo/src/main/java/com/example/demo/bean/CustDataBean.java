package com.example.demo.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * 顧客テーブルEntity
 */
@Data
@Component
@Entity
@Table(name = "table1")
@NoArgsConstructor
@JsonPropertyOrder({"custname","address","telenum","notes"})
public class CustDataBean {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;			// ID(テーブルによる自動生成)

	@Column
	private String custname;	// 顧客名

	@Column
	private String address;		// 住所

	@Column
	private String telenum;		// 電話番号

	@Column
	private String notes;		// その他・備考	

}