package jp.ac.ohara.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.schedule.model.Schedule;
import jp.ac.ohara.schedule.repository.ScheduleRepository;

@Service
@Transactional
public class ScheduleService {

	@Autowired
	private ScheduleRepository repository;

	

	/**
	 * アドレス帳一覧の取得
	 * @return List<Schedule>
	 */
	public List<Schedule> getscheduleList() {
		List<Schedule> entityList = this.repository.findAll();
		return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	
	 */
	public Schedule get(@NonNull Long index) {
		Schedule schedule = this.repository.findById(index).orElse(new Schedule());
		return schedule;
	}

	/**
	 * アドレス帳一覧の取得
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull Schedule schedule) {
		this.repository.save(schedule);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}