package com.pilot.reservation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

import com.pilot.reservation.config.kafka.KafkaProcessor;

@Entity
@Table(name="Reservation_table")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer scheduleId;
	private String resveEmpno;
	private String comptYn;
	
	@PostPersist
	public void onPostPersist(){
		ReservationRegistered reservationRegistered = new ReservationRegistered();
		BeanUtils.copyProperties(this, reservationRegistered);
		reservationRegistered.publishAfterCommit();
	}
	
	public void onPostUpdate() {
		ReservationCompleted reservationCompleted = new ReservationCompleted();
		BeanUtils.copyProperties(this, reservationCompleted);
		reservationCompleted.publishAfterCommit();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getResveEmpno() {
		return resveEmpno;
	}
	public void setResveEmpno(String resveEmpno) {
		this.resveEmpno = resveEmpno;
	}
	public String getComptYn() {
		return comptYn;
	}
	public void setComptYn(String comptYn) {
		this.comptYn = comptYn;
	}
	
	
}
