package com.pilot.reservation;

public class ReservationRegistered extends AbstractEvent {

	private Long id;
	private Integer scheduleId;
	private String resveEmpno;
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
	
}
