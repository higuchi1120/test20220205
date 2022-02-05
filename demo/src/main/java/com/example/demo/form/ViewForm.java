package com.example.demo.form;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.CustDataViewBean;

import lombok.Data;

/**
 * @author
 * 顧客テーブルの表示/更新/削除フォーム
 */
@Data
@Component
public class ViewForm {

	private List<CustDataViewBean> custDataViewList;
	
}


