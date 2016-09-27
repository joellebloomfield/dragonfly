package com.ge.predix.labs.data.jpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class DeviceId implements Serializable {
	/**
	 * Composite index
	 */
	private static final long serialVersionUID = -7004161273384360237L;
	Integer deviceId;
	Date tmStmp;
	

}
