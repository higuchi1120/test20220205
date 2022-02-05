package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustDataRepositoryServiceDTO;
import com.example.demo.repository.CustDataRepository;

/**
 * @author
 * 顧客テーブルリポジトリサービス
 */
@Service
@Transactional
public class CustDataRepositoryService {
	
	@Autowired
	CustDataRepository _custDataRepository;

	/**
	 * 全件取得
	 * @return
	 */
	public CustDataRepositoryServiceDTO getAllCustData(){
		
		return new CustDataRepositoryServiceDTO(_custDataRepository.findAll());
		
	}
	
	/**
	 * 検索
	 * @param custname
	 * @param address
	 * @param telenum
	 * @param notes
	 * @return
	 */
	public CustDataRepositoryServiceDTO searchCustData(String custname,String address,String telenum,String notes){
		
		return new CustDataRepositoryServiceDTO(_custDataRepository.findByCustnameLikeAndAddressLikeAndTelenumLikeAndNotesLike("%"+custname+"%","%"+address+"%","%"+telenum+"%","%"+notes+"%"));
		
	}
	
	/**
	 * 登録
	 * @param _dto
	 */
	public void insertCustData(CustDataRepositoryServiceDTO _dto) {
		// 更新系と共通化もできるが、別の機能と考え分けておく
		_custDataRepository.save(_dto.getCustDataList().get(0));
		
	}
	
	/**
	 * 削除
	 * @param _dto
	 */
	public void deleteCustData(CustDataRepositoryServiceDTO _dto) {
		
		_custDataRepository.deleteAll(_dto.getCustDataList());
		
	}
	
	/**
	 * 更新
	 * @param _dto
	 */
	public void updateCustData(CustDataRepositoryServiceDTO _dto) {
		
		_custDataRepository.saveAll(_dto.getCustDataList());
		
	}
	
}
