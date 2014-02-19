package org.example.errorhandling.repr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Error")
@XmlAccessorType(XmlAccessType.FIELD)
public class Error {
	@XmlAttribute
	public String message;
}
