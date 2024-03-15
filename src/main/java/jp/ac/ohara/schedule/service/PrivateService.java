package jp.ac.ohara.schedule.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.schedule.model.Private;
import jp.ac.ohara.schedule.repository.PrivateRepository;
 
@Service
@Transactional
public class PrivateService {
 
	@Autowired
	private PrivateRepository repository;
 
	/**
	 * アドレス帳一覧の取得
	 * @return List<Private>
	 */
	public List<Private> getprivateList() {
	    List<Private> entityList = this.repository.findAll();
	    return entityList;
	}
 
	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	
	 */
	public Private get(@NonNull Long index) {
		Private privates = this.repository.findById(index).orElse(new Private());
		return privates;
	}
 
	/**
	 * アドレス帳一覧の取得
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull Private privates) {
		this.repository.save(privates);
	}
 
	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}