package com.example.demo.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author
 * 顧客テーブルのレコードと、それがフォームでチェックされているかどうかを保持するbean
 * フォームではこの形で顧客情報を扱う
 */
@Data
@Component
public class CustDataViewBean {
	
	boolean checked;			// チェックボックス状態
	
	CustDataBean custDataBean;	// 顧客テーブルレコード
	
}
