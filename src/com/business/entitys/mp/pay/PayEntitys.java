package com.business.entitys.mp.pay;

public class PayEntitys {
private String appointment_id;

public PayEntitys() {
	super();
}

public PayEntitys(String appointment_id) {
	super();
	this.appointment_id = appointment_id;
}

@Override
public String toString() {
	return "PayEntitys [appointment_id=" + appointment_id + "]";
}

public String getAppointment_id() {
	return appointment_id;
}

public void setAppointment_id(String appointment_id) {
	this.appointment_id = appointment_id;
}
}
