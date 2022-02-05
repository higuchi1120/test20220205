package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.CustDataBean;
import com.example.demo.bean.CustDataViewBean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 
 * 顧客テーブルリポジトリServiceのDTO
 */
@Data
@Component
@AllArgsConstructor
public class CustDataRepositoryServiceDTO {
	
	private List<CustDataBean> custDataList;	// Entityのリスト
	
	/**
	 * Entityリストからそれにチェック状態を加えたリストを取得
	 * @return
	 */
	public List<CustDataViewBean> getCustDataViewList() {
		
		List<CustDataViewBean> _list = new ArrayList<CustDataViewBean>();
		
		for(CustDataBean _bean : custDataList) {
			CustDataViewBean _viewBean = new CustDataViewBean();
			_viewBean.setCustDataBean(_bean);
			_list.add(_viewBean);
		}
		
		return _list;
		
	}

}
