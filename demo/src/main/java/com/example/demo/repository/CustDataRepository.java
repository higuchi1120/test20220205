package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.CustDataBean;

/**
 * @author
 * 顧客テーブルリポジトリ
 */
@Repository
public interface CustDataRepository extends JpaRepository<CustDataBean, Long>{
	
	/**
	 * 顧客テーブル検索
	 * 不完全一致 AND検索
	 * SELECT * FROM TEST.TABLE1 
	 * WHERE custname LIKE "%custname%" AND address LIKE "%address%" AND telenum LIKE "%telenum%" AND notes LIKE "%notes%";
	 * @param custname
	 * @param address
	 * @param telenum
	 * @param notes
	 * @return
	 */
	public List<CustDataBean> findByCustnameLikeAndAddressLikeAndTelenumLikeAndNotesLike(String custname,String address,String telenum,String notes);

}
